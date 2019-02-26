package com.dan.springboot.config;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ExampleBean {
    private String name="jack";
    public void init(){}
    public void destroy(){}
}
