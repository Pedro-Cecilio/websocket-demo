package com.example.demo.Models;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JoinData {
    private String user;
    private UUID token;
    private boolean host;

    public JoinData(JoinDataDto dto){
        this.user = dto.getUsername();
        this.host = dto.isHost();
        this.token = UUID.randomUUID();
    }
}
