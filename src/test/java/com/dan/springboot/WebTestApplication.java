package com.dan.springboot;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WebTestApplication {
    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void test1(){
        ResponseEntity<String> stringResponseEntity=restTemplate.getForEntity(
                "http://localhost:80/mail/basic",String.class
        );
        Assert.assertEquals(HttpStatus.OK,stringResponseEntity.getStatusCode());
        Assert.assertEquals("success",stringResponseEntity.getBody());
    }
}
