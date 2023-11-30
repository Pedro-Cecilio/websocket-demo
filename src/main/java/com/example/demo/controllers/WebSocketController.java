package com.example.demo.controllers;

import java.util.UUID;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.demo.Models.JoinData;
import com.example.demo.Models.JoinDataDto;

@Controller
public class WebSocketController {

    @MessageMapping("/room/{roomId}")
    @SendTo("/room/{roomId}")
    public JoinData joinRoom(@DestinationVariable("roomId") String roomId, JoinDataDto data) {
        return new JoinData(data.getUsername(), UUID.randomUUID(), data.isHost());
    }


    // @MessageMapping("/wellcome/{roomId}")
    // @SendTo("/room/{roomId}")
    // public String wellcome(@DestinationVariable("roomId") String roomId, String username) {
    //     System.out.println(username);
    //     return new Hello(username).wellcome();
    // }


    
}
