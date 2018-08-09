package com.nexgo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by CRIKEY on 2018/8/9.
 */
@Component
public class MessageConsumer {

    @JmsListener(destination = "itcast")
    public void readMessage(String text){
        // 内置的activemq
        System.out.println("接收到的消息是："+text);
    }

    @JmsListener(destination = "itcast_map")
    public void readMap(Map<String,Object> map) throws JsonProcessingException {
        // 内置的activemq
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("接收到的消息是："+ objectMapper.writeValueAsString(map));
    }
}
