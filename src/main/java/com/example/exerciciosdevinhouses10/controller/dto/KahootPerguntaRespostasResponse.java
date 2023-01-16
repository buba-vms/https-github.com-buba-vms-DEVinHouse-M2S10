package com.example.exerciciosdevinhouses10.controller.dto;

import com.example.exerciciosdevinhouses10.dataprovider.entity.PerguntaEntity;
import com.example.exerciciosdevinhouses10.dataprovider.entity.RespostaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KahootPerguntaRespostasResponse {


    private PerguntaEntity perguntaEscolhida;
    private List<RespostaEntity> listaDeRespostas;

}
