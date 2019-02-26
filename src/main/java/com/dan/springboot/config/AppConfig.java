package com.dan.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

//这个类相当于一个xml文件
@Configuration
public class AppConfig {

    @Bean(value = "hello")
    public String helloString(){
        return "hello";
    }

    @Bean(initMethod = "init",destroyMethod = "destroy")
    @Scope(scopeName = "prototype")
    public ExampleBean exampleBean(){
        return new ExampleBean();
    }
}
