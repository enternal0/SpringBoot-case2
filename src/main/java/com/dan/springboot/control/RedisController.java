package com.dan.springboot.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RequestMapping(value = "/redis")
@RestController
public class RedisController {

    @Autowired
    private StringRedisTemplate redisTemplate;
    @RequestMapping(value = "/add")
    public Map<String,String> addInfo(@RequestParam(value = "key") String key,
                                      @RequestParam(value = "value") String value){
//        opsForValue意思是我们操作一个KV类型
       redisTemplate.opsForValue().set(key,value);
       Map<String,String> data=new HashMap<>();
       data.put(key, value);
       return data;
    }

    @RequestMapping(value = "/query")
    public Map<String,String> query(@RequestParam(value = "key") String key){
        Map<String,String> data=new HashMap<>();
        String value=redisTemplate.opsForValue().get(key);
        data.put(key,value);
        return data;
    }

    @RequestMapping(value = "/del")
    public Map<String,String> delete(@RequestParam(value = "key") String key){
        Map<String,String> data=new HashMap<>();
        String value=redisTemplate.opsForValue().get(key);
        redisTemplate.delete(key);
        data.put(key,value);
        return data;
    }

    /**
     * 把K的值遍历一遍 set j_1 abc set J-2 def  keys j*所有J开头的都会展现出来
     * http://localhost/redis/list?key=j*
     * http://localhost/redis/list?key=*
     * @param key
     * @return
     */
    @RequestMapping(value = "/list")
    public Map<String,String> list(@RequestParam(value = "key") String key){
        Map<String,String> data=new HashMap<>();
//        key必须是String
        Set<String> keys=redisTemplate.keys(key);
        for(String k:keys){
            if(redisTemplate.type(k)==DataType.STRING){
                data.put(k,redisTemplate.opsForValue().get(k));
            }
        }
        return data;
    }
}
