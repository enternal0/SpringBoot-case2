package com.dan.springboot;

import com.dan.springboot.config.ExampleBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//SpringBoot的测试
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestSpringApplication {
    @Autowired
    private static ExampleBean exampleBean;
    @Test
   public void  test1(){
        Assert.assertEquals("jack",  exampleBean.getName());
   }
}
