package com.example.demo.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hello {
    private String user;

    public String wellcome(){
        return "%s entrou na sala!".formatted(this.user);
    }
}
