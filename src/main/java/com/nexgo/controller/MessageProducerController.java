package com.nexgo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CRIKEY on 2018/8/9.
 */
@RestController
public class MessageProducerController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Environment environment;

    @RequestMapping("/send")
    public void send(String text){
        jmsMessagingTemplate.convertAndSend("itcast",text);
    }

    @RequestMapping("/sendmap")
    public void sendmap(){
        Map<String, Object> map = new HashMap<>();
        map.put("name",environment.getProperty("name"));
        map.put("word",environment.getProperty("word"));
        jmsMessagingTemplate.convertAndSend("itcast_map",map);
    }
}
