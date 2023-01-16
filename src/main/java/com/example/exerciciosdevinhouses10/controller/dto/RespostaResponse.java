package com.example.exerciciosdevinhouses10.controller.dto;


import com.example.exerciciosdevinhouses10.dataprovider.entity.PerguntaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespostaResponse {

    private Long id;

    private String texto;

    private String pergunta;




}
