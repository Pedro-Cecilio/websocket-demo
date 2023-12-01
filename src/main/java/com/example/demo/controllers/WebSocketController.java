package com.example.demo.controllers;


import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.demo.Models.JoinDataDto;

@Controller
public class WebSocketController {

    @MessageMapping("/room/{roomId}")
    @SendTo("/room/{roomId}")
    public JoinDataDto joinRoom(@DestinationVariable("roomId") String roomId, JoinDataDto data) {
        return data;
    }


    // @MessageMapping("/wellcome/{roomId}")
    // @SendTo("/room/{roomId}")
    // public String wellcome(@DestinationVariable("roomId") String roomId, String username) {
    //     System.out.println(username);
    //     return new Hello(username).wellcome();
    // }


    
}
