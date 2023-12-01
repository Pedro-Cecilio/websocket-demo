package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.JoinData;
import com.example.demo.Models.JoinDataDto;

@RestController
@RequestMapping(value = "/login")
public class TokenController {
    @PostMapping
    public JoinData login(@RequestBody JoinDataDto data){
        JoinData joinData = new JoinData(data);
        return joinData;
    }
}
