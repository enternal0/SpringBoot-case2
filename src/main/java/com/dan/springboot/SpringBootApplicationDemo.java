package com.dan.springboot;


import com.dan.springboot.config.ExampleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;


@SpringBootApplication(scanBasePackages = "com.dan.springboot")
public class SpringBootApplicationDemo {
    public static void main(String[] args) {
      ApplicationContext context=SpringApplication.run(SpringBootApplicationDemo.class,args);
      ExampleBean exampleBean1= (ExampleBean) context.getBean("exampleBean");
      ExampleBean exampleBean2= (ExampleBean) context.getBean("exampleBean");
      System.out.println(exampleBean1==exampleBean2);
    }
}
