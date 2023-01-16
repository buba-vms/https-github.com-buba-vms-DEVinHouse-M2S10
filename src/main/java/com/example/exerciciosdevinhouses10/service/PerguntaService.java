package com.example.exerciciosdevinhouses10.service;


import com.example.exerciciosdevinhouses10.controller.dto.PerguntaRequest;
import com.example.exerciciosdevinhouses10.controller.dto.PerguntaResponse;
import com.example.exerciciosdevinhouses10.dataprovider.entity.PerguntaEntity;
import com.example.exerciciosdevinhouses10.dataprovider.repository.AssuntoRepository;
import com.example.exerciciosdevinhouses10.dataprovider.repository.PerguntaRepository;
import com.example.exerciciosdevinhouses10.exception.NotFoundException;
import com.example.exerciciosdevinhouses10.padroes.DefaultResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@Setter
public class PerguntaService {
    private final AssuntoRepository assuntoRepository;
    private final PerguntaRepository perguntaRepository;


    public PerguntaService(AssuntoRepository assuntoRepository, PerguntaRepository perguntaRepository) {
        perguntaRepository.save(new PerguntaEntity("sera", "Biscoito ou bolacha?", assuntoRepository.findById(1L).get()));
        perguntaRepository.save(new PerguntaEntity("sim", "Com qual celebridade você gostaria de se parecer?", assuntoRepository.findById(2L).get()));
        perguntaRepository.save(new PerguntaEntity("nao", "Com que frequência você mente?", assuntoRepository.findById(3L).get()));
        perguntaRepository.save(new PerguntaEntity("sera", "sera sera sera?", assuntoRepository.findById(1L).get()));
        perguntaRepository.save(new PerguntaEntity("talvez", "Com que personagem de filme ou livro você se identifica?", assuntoRepository.findById(2L).get()));
        perguntaRepository.save(new PerguntaEntity("letras", "Qual animal doméstico você gostaria de ser?", assuntoRepository.findById(3L).get()));

        this.assuntoRepository = assuntoRepository;
        this.perguntaRepository = perguntaRepository;
    }


    public ResponseEntity<List<PerguntaResponse>> encontrarPerguntas() {
        List<PerguntaEntity> entityList = perguntaRepository.findAll();
        List<PerguntaResponse> responseList = new ArrayList<>();

        for (PerguntaEntity entity : entityList) {
            responseList.add(
                    new PerguntaResponse(entity.getTitulo(), entity.getTexto(), entity.getAssuntoEntity().getNome())
            );

        }
        return ResponseEntity.ok(responseList);
    }


    public ResponseEntity<DefaultResponse<PerguntaResponse>> encontrarPerguntaPorId(Long id) {
        PerguntaEntity entity = perguntaRepository.findById(id).orElseThrow(()-> new NotFoundException("Pergunta não encontrada"));



        return new ResponseEntity<DefaultResponse<PerguntaResponse>>(
                new DefaultResponse<PerguntaResponse>(
                        200,
                        new PerguntaResponse(
                        entity.getTitulo(),
                        entity.getTexto(),
                        entity.getAssuntoEntity().getNome())


        ),
                HttpStatus.OK);
    }



    public ResponseEntity<List<PerguntaEntity>> listarPerguntasPorAssunto(String nome) {
        List<PerguntaEntity> entityList = perguntaRepository.findAllByAssuntoNome(nome);

        return ResponseEntity.ok(entityList);
    }



    public ResponseEntity<PerguntaResponse> salvarPergunta(@RequestBody PerguntaRequest perguntaRequest) {
        PerguntaEntity entity = perguntaRepository.save(new PerguntaEntity(perguntaRequest.getTitulo(),
                perguntaRequest.getTexto(),
                assuntoRepository.findById(perguntaRequest.getIdAssunto()).orElseThrow(()-> new NotFoundException("Assunto não encontrado"))));



        return new ResponseEntity<PerguntaResponse>(new PerguntaResponse(entity.getTitulo(), entity.getTexto(), entity.getAssuntoEntity().getNome()),
                HttpStatus.CREATED);
    }



    public ResponseEntity<PerguntaResponse> atualizarPerguntaPorId(Long id,  PerguntaRequest perguntaRequest) {
        PerguntaEntity entity = perguntaRepository.findById(id).get();
        entity.setTitulo(perguntaRequest.getTitulo());
        entity.setTexto(perguntaRequest.getTexto());
        entity.setAssuntoEntity(assuntoRepository.findById(perguntaRequest.getIdAssunto()).get());
        perguntaRepository.save(entity);

        return new ResponseEntity<PerguntaResponse>(
                new PerguntaResponse(entity.getTitulo(), entity.getTexto(), entity.getAssuntoEntity().getNome())
                , HttpStatus.OK);

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletarPerguntaPorId( Long id) {
        PerguntaEntity entity = perguntaRepository.findById(id).get();
        perguntaRepository.delete(entity);

        return ResponseEntity.accepted().build();
    }


}
