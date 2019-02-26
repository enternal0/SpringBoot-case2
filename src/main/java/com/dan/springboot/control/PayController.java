package com.dan.springboot.control;

import com.dan.springboot.config.PayPerporties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
@RequestMapping
public class PayController {
    @Autowired
    private PayPerporties payPerporties;
    @RequestMapping(value = "/pay",method = RequestMethod.GET)
    public String payInfo(){
        return payPerporties.toString();
    }
}
