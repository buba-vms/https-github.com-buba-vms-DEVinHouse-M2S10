package com.example.exerciciosdevinhouses10.controller;


import com.example.exerciciosdevinhouses10.controller.dto.AssuntoResponse;
import com.example.exerciciosdevinhouses10.controller.dto.PerguntaRequest;
import com.example.exerciciosdevinhouses10.controller.dto.PerguntaResponse;
import com.example.exerciciosdevinhouses10.dataprovider.entity.PerguntaEntity;
import com.example.exerciciosdevinhouses10.dataprovider.repository.AssuntoRepository;
import com.example.exerciciosdevinhouses10.dataprovider.repository.PerguntaRepository;
import com.example.exerciciosdevinhouses10.padroes.DefaultResponse;
import com.example.exerciciosdevinhouses10.service.PerguntaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/perguntas")
public class PerguntaController {


    private final PerguntaService perguntaService;

    public PerguntaController( PerguntaService perguntaService) {

        this.perguntaService = perguntaService;
    }

    @GetMapping
    public ResponseEntity<List<PerguntaResponse>> encontrarPerguntas() {

        return perguntaService.encontrarPerguntas();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DefaultResponse<PerguntaResponse>> encontrarPerguntaPorId(@PathVariable Long id) {
       return perguntaService.encontrarPerguntaPorId(id);
    }


    @GetMapping(path = "/pesquisa")//não utilizar verbos
    public ResponseEntity<List<PerguntaEntity>> listarPerguntasPorAssunto(@RequestParam("nomeAssunto") String nome) {
        return perguntaService.listarPerguntasPorAssunto(nome);
    }


    @PostMapping
    public ResponseEntity<PerguntaResponse> salvarPergunta(@RequestBody PerguntaRequest perguntaRequest) {
        return perguntaService.salvarPergunta(perguntaRequest);
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<PerguntaResponse> atualizarPerguntaPorId(@PathVariable Long id, @RequestBody PerguntaRequest perguntaRequest) {
        return perguntaService.atualizarPerguntaPorId(id, perguntaRequest);

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletarPerguntaPorId(@PathVariable Long id) {
        return perguntaService.deletarPerguntaPorId(id);
    }


}
