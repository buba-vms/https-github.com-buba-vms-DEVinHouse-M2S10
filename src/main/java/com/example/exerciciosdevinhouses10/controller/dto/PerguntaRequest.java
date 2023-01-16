package com.example.exerciciosdevinhouses10.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerguntaRequest {

    private String titulo;
    private String texto;
    private Long idAssunto;


}
