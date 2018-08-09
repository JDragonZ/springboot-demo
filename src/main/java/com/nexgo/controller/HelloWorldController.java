package com.nexgo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CRIKEY on 2018/8/9.
 */
@RestController
public class HelloWorldController {

    @Autowired
    private Environment environment;

    @RequestMapping("/info")
    public String info(){
        return "hello world !!! info"+environment.getProperty("url");
    }

    @RequestMapping("/sayHello")
    public Map<String,Object> helloName(){
        Map<String, Object> result = new HashMap<>();
        result.put("name",environment.getProperty("name"));
        result.put("word",environment.getProperty("word"));
        return  result;
    }
}
