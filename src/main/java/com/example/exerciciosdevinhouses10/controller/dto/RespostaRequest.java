package com.example.exerciciosdevinhouses10.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespostaRequest {
    private Long id_pergunta;
    private String texto;
}
