package com.dan.springboot.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@RestController
@RequestMapping(value = "/mail")
public class MailComponent {
    @Autowired
    private JavaMailSender javaMailSender;

    @RequestMapping(value = "/basic")
    public String mail(){
        try {
            sendBasic();
            return "success";
        } catch (MessagingException e) {
            return "普通方式传输 failed";
        }
    }
    @RequestMapping(value = "/basic1")
    public String mail1(){
        senderBasic1();
        return "mail1 hepler传输 finished";
    }
    @RequestMapping(value = "/basic2")
    public String mail2(){
        try {
            senderBasic2();
            return "mail2 附件传送 finished";
        } catch (MessagingException e) {
            return "mail2 附件传送 failed";
        }

    }
    @RequestMapping(value = "/basic3")
    public String mail3(){
        try {
            senderBasic3();
            return "mail3 内联资源 finished";
        } catch (MessagingException e) {
            return "mail3 内联资源 failed";
        }
    }


    /**
     * 发送普通邮件给个人
     * @throws MessagingException
     */
    private void sendBasic() throws MessagingException {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        mimeMessage.setRecipient(Message.RecipientType.TO
                ,new InternetAddress("17691032732@163.com"));
        mimeMessage.setText("Hello ,this is my program is sending email to you.");
        mimeMessage.setFrom("2296560776@qq.com");
//        邮件主题
        mimeMessage.setSubject("Dear honey");
        javaMailSender.send(mimeMessage);
    }
    /**
     * 用helper类来进行发邮件
     */
    private void senderBasic1(){
//        MimeMessageHelper类更直观一点，也能发邮件
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage);
        try {
            helper.setTo("17691032732@163.com");
            helper.setFrom("2296560776@qq.com");
            helper.setSubject("Dear honey Helper");
            helper.setText("Hello ,this is my program is sending email to you.it is second");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mimeMessage);
    }
    //--------------------复杂邮件示例--------------------------
    /**
     * 发送带附件邮件
     */
    private void senderBasic2() throws MessagingException {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
        try {
            helper.setTo("17691032732@163.com");
            helper.setFrom("2296560776@qq.com");
            helper.setSubject("程序发带附件的邮件");
            helper.setText("Hello,this is my third time sending mail to you");
            ClassPathResource file=new ClassPathResource("dan.jpg");
            helper.addAttachment("mypicture.jpg",file);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    /**
     *  内联资源
     */
    private void senderBasic3() throws MessagingException {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
        try {
            helper.setTo("17691032732@163.com");
            helper.setFrom("2296560776@qq.com");
            helper.setSubject("程序发内联资源邮件");
            helper.setText("Hello,this is my four time sending mail to you");
            //资源引用处设置cid,资源标识
            helper.setText("<html><body><img src='cid:img123'></body></html>",true);
            ClassPathResource file=new ClassPathResource("dan.jpg");
            //添加资源时指定cid,资源标识符
            helper.addInline("img123",file);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
