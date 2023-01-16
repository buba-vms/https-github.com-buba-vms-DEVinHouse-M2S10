package com.example.exerciciosdevinhouses10.controller.dto;


import com.example.exerciciosdevinhouses10.dataprovider.entity.AssuntoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerguntaResponse {

    private String titulo;
    private String texto;
    private String assunto;



}
