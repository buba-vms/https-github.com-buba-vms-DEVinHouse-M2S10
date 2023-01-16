package com.example.exerciciosdevinhouses10.controller;

import com.example.exerciciosdevinhouses10.controller.dto.KahootPerguntaRespostasResponse;
import com.example.exerciciosdevinhouses10.controller.dto.KahootResponse;
import com.example.exerciciosdevinhouses10.controller.dto.RespostaResponse;
import com.example.exerciciosdevinhouses10.dataprovider.entity.PerguntaEntity;
import com.example.exerciciosdevinhouses10.dataprovider.entity.RespostaEntity;
import com.example.exerciciosdevinhouses10.dataprovider.repository.AssuntoRepository;
import com.example.exerciciosdevinhouses10.dataprovider.repository.PerguntaRepository;
import com.example.exerciciosdevinhouses10.dataprovider.repository.RespostaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;


@RestController
@RequestMapping("/kahoot")
public class KahootController {
    private final AssuntoRepository assuntoRepository;
    private final PerguntaRepository perguntaRepository;
    private final RespostaRepository respostaRepository;

    public KahootController(AssuntoRepository assuntoRepository, PerguntaRepository perguntaRepository, RespostaRepository respostaRepository) {
        this.assuntoRepository = assuntoRepository;
        this.perguntaRepository = perguntaRepository;
        this.respostaRepository = respostaRepository;
    }

    @GetMapping
    public ResponseEntity<KahootResponse> encontarRespostas() {


        KahootPerguntaRespostasResponse[] listaKahoot = new KahootPerguntaRespostasResponse[5];
        for (int i = 0; i < listaKahoot.length; i++) {
            List<RespostaEntity> respostas = respostaRepository.findAll();
            List<RespostaEntity> respostasEscolhidas = new ArrayList<>();
            Random r = new Random();
            Long random =  r.nextLong(5 - 1) + 1;
            PerguntaEntity perguntaEscolhida = perguntaRepository.findById(random).get();

            for (RespostaEntity resposta: respostas
                 ) {
                if (Objects.equals(resposta.getPerguntaEntity().getId(), perguntaEscolhida.getId())){
                    respostasEscolhidas.add(resposta);
                }
            }
            KahootPerguntaRespostasResponse perguntaComRespostasEscolhida = new KahootPerguntaRespostasResponse(perguntaEscolhida, respostasEscolhidas);
            listaKahoot[i] = perguntaComRespostasEscolhida;
        }
        KahootResponse teste = new KahootResponse(listaKahoot);





        return ResponseEntity.ok(teste);
    }




}
