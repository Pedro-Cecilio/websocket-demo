package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.demo.Models.JoinDataDto;

@Controller
public class WebSocketController {

    private HashMap<String, ArrayList<JoinDataDto>> participants = new HashMap<>();
    @MessageMapping("/room/{roomId}")
    @SendTo("/room/{roomId}")
    public ArrayList<JoinDataDto> joinRoom(@DestinationVariable("roomId") String roomId, JoinDataDto data) {
        participants.computeIfAbsent(roomId, k -> new ArrayList<>()).add(data);
        return participants.get(roomId);
    }  
}
