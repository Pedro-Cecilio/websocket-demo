package com.example.demo.controllers;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.demo.Models.Hello;
import com.example.demo.Models.Message;

@Controller
public class WebSocketController {

    @MessageMapping("/chatMessage/{roomId}")
    @SendTo("/room/{roomId}")
    public Message sendMessage(@DestinationVariable("roomId") String roomId, Message message) {
        System.out.println(message.getUser());
        return message;
    }

    @MessageMapping("/wellcome/{roomId}")
    @SendTo("/room/{roomId}")
    public String wellcome(@DestinationVariable("roomId") String roomId, String username) {
        System.out.println(username);
        return new Hello(username).wellcome();
    }
}
