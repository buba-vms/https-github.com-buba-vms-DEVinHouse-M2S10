package com.example.exerciciosdevinhouses10.controller;


import com.example.exerciciosdevinhouses10.controller.dto.RespostaRequest;
import com.example.exerciciosdevinhouses10.controller.dto.RespostaResponse;
import com.example.exerciciosdevinhouses10.dataprovider.entity.RespostaEntity;
import com.example.exerciciosdevinhouses10.dataprovider.repository.PerguntaRepository;
import com.example.exerciciosdevinhouses10.dataprovider.repository.RespostaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/respostas")
public class RespostaController {
    private final PerguntaRepository perguntaRepository;

    private final RespostaRepository respostaRepository;

    public RespostaController(PerguntaRepository perguntaRepository, RespostaRepository respostaRepository) {

        respostaRepository.save(new RespostaEntity("ddddddd", perguntaRepository.findById(1L).get()));
        respostaRepository.save(new RespostaEntity("sssss", perguntaRepository.findById(1L).get()));
        respostaRepository.save(new RespostaEntity("aaaaa", perguntaRepository.findById(1L).get()));
        respostaRepository.save(new RespostaEntity("ddddddd", perguntaRepository.findById(4L).get()));
        respostaRepository.save(new RespostaEntity("sssss", perguntaRepository.findById(1L).get()));
        respostaRepository.save(new RespostaEntity("aaaaa", perguntaRepository.findById(1L).get()));
        respostaRepository.save(new RespostaEntity("ddddddd", perguntaRepository.findById(4L).get()));
        respostaRepository.save(new RespostaEntity("sssss", perguntaRepository.findById(2L).get()));
        respostaRepository.save(new RespostaEntity("aaaaa", perguntaRepository.findById(2L).get()));
        respostaRepository.save(new RespostaEntity("ddddddd", perguntaRepository.findById(4L).get()));
        respostaRepository.save(new RespostaEntity("sssss", perguntaRepository.findById(2L).get()));
        respostaRepository.save(new RespostaEntity("aaaaa", perguntaRepository.findById(2L).get()));
        respostaRepository.save(new RespostaEntity("ddddddd", perguntaRepository.findById(4L).get()));
        respostaRepository.save(new RespostaEntity("sssss", perguntaRepository.findById(2L).get()));
        respostaRepository.save(new RespostaEntity("aaaaa", perguntaRepository.findById(3L).get()));
        respostaRepository.save(new RespostaEntity("ddddddd", perguntaRepository.findById(4L).get()));
        respostaRepository.save(new RespostaEntity("sssss", perguntaRepository.findById(3L).get()));
        respostaRepository.save(new RespostaEntity("aaaaa", perguntaRepository.findById(3L).get()));
        respostaRepository.save(new RespostaEntity("ddddddd", perguntaRepository.findById(4L).get()));
        respostaRepository.save(new RespostaEntity("sssss", perguntaRepository.findById(3L).get()));
        respostaRepository.save(new RespostaEntity("aaaaa", perguntaRepository.findById(3L).get()));
        respostaRepository.save(new RespostaEntity("aaaaa", perguntaRepository.findById(5L).get()));
        respostaRepository.save(new RespostaEntity("aaaaa", perguntaRepository.findById(5L).get()));
        respostaRepository.save(new RespostaEntity("aaaaa", perguntaRepository.findById(5L).get()));
        respostaRepository.save(new RespostaEntity("aaaaa", perguntaRepository.findById(5L).get()));
        respostaRepository.save(new RespostaEntity("aaaaa", perguntaRepository.findById(5L).get()));
        respostaRepository.save(new RespostaEntity("aaaaa", perguntaRepository.findById(6L).get()));
        respostaRepository.save(new RespostaEntity("aaaaa", perguntaRepository.findById(6L).get()));
        respostaRepository.save(new RespostaEntity("aaaaa", perguntaRepository.findById(6L).get()));
        respostaRepository.save(new RespostaEntity("aaaaa", perguntaRepository.findById(6L).get()));
        respostaRepository.save(new RespostaEntity("aaaaa", perguntaRepository.findById(6L).get()));

        this.perguntaRepository = perguntaRepository;
        this.respostaRepository = respostaRepository;
    }

    @GetMapping
    public ResponseEntity<List<RespostaResponse>> encontarRespostas() {
        List<RespostaEntity> entityList = respostaRepository.findAll();
        List<RespostaResponse> responseList = new ArrayList<>();

        for (RespostaEntity entity : entityList) {
            responseList.add(
                    new RespostaResponse(entity.getId(), entity.getTexto(), entity.getPerguntaEntity().getTexto())
            );
        }

        return ResponseEntity.ok(responseList);
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<RespostaResponse> encontrarRespostaPorId(@PathVariable Long id) {
        RespostaEntity entity = respostaRepository.findById(id).get();
        return new ResponseEntity<RespostaResponse>(new RespostaResponse(entity.getId(),
                entity.getTexto(),
                entity.getPerguntaEntity().getTexto()), HttpStatus.OK);
    }

    @GetMapping(path = "/pesquisa")
    public ResponseEntity<List<RespostaEntity>> listarPerguntasPorResposta(@RequestParam("pergunta") String pergunta) {
        List<RespostaEntity> entityList = respostaRepository.findAllByPergunta(pergunta);


        return ResponseEntity.ok(entityList);
    }

    @PostMapping
    public ResponseEntity<RespostaResponse> salvarResposta(@RequestBody RespostaRequest respostaRequest) {
        RespostaEntity entity = respostaRepository.save(new RespostaEntity(respostaRequest.getTexto(),
                perguntaRepository.findById(respostaRequest.getId_pergunta()).get()));

        return new ResponseEntity<RespostaResponse>(new RespostaResponse(entity.getId(), entity.getTexto(), entity.getPerguntaEntity().getTexto()),
                HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<RespostaResponse> atualizarResposta(@PathVariable Long id, @RequestBody RespostaRequest respostaRequest) {
        RespostaEntity entity = respostaRepository.findById(id).get();
        entity.setTexto(respostaRequest.getTexto());
        entity.setPerguntaEntity(perguntaRepository.findById(respostaRequest.getId_pergunta()).get());
        respostaRepository.save(entity);

        return new ResponseEntity<RespostaResponse>(new RespostaResponse(entity.getId(), entity.getTexto(), entity.getPerguntaEntity().getTexto()),
                HttpStatus.ACCEPTED);

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletarRespostaPorId(@PathVariable Long id) {
        respostaRepository.deleteById(id);

        return ResponseEntity.accepted().build();

    }


}
