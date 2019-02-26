package com.dan.springboot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//把这个类和属性文件关联起来
@ConfigurationProperties(prefix = "app.pay")
@Component
@Data
public class PayPerporties {
    private Alipay alipay = new Alipay();
    private WxPay wxPay = new WxPay();
    /**
     * 支付宝可配置参数
     */
    @Data
    private static class Alipay {
        private String gateway = "https://openapi.alipay.com/gateway.do";
        private String privateKey ;
        private String publicKey ;
        private String aliPublicKey ;
        private String appId ;
        private String method = "alipay.trade.app.pay";
        private String format = "json";
        private String charset = "utf-8";
        private String signType = "RSA2";
        private String version = "1.0";
        private String notifyUrl;
//省略了getter和setter方法
    }
    /**
     * 微信支付配置
     */
    @Data
    private static class WxPay {
        /**
         * 应用ID
         */
        private String appId ;
        /**
         * 商户平台设置的密钥
         */
        private String apiKey ;
        /**
         * 商户号
         */
        private String mchId;
        /**
         * 交易类型
         */
        private String tradeType = "APP";
        /**
         * 签名类型
         */
        private String signType = "MD5";
        /**
         * 支付通知地址
         */
        private String payNotifyUrl;
        /**
         * 退款通知接口
         */
        private String refundNotifyUrl;
//省略了getter和setter方法
    }
}
