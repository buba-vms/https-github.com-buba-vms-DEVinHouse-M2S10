package com.example.exerciciosdevinhouses10.service;


import com.example.exerciciosdevinhouses10.controller.dto.AssuntoRequest;
import com.example.exerciciosdevinhouses10.controller.dto.AssuntoResponse;
import com.example.exerciciosdevinhouses10.dataprovider.entity.AssuntoEntity;
import com.example.exerciciosdevinhouses10.dataprovider.repository.AssuntoRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@Setter
public class AssuntoService {
    private final AssuntoRepository assuntoRepository;


    public AssuntoService(AssuntoRepository assuntoRepository) {
        assuntoRepository.save(new AssuntoEntity("Geografica"));
        assuntoRepository.save(new AssuntoEntity("Matematica"));
        assuntoRepository.save(new AssuntoEntity("Programação"));
        assuntoRepository.save(new AssuntoEntity("Português"));
        assuntoRepository.save(new AssuntoEntity("Historia"));
        assuntoRepository.save(new AssuntoEntity("Biologia"));

        this.assuntoRepository = assuntoRepository;
    }

    public ResponseEntity<List<AssuntoResponse>> listarAssuntos(){
        List<AssuntoEntity> entityList = assuntoRepository.findAll();
        List<AssuntoResponse> responseList = new ArrayList<>();

        for (AssuntoEntity entity: entityList){
            responseList.add(
                    new AssuntoResponse(entity.getId(), entity.getNome())
            );
        }
        return ResponseEntity.ok(responseList);
    }

    public ResponseEntity<AssuntoResponse> encontrarAssuntoPorId(Long id){
        AssuntoEntity entity = assuntoRepository.findById(id).get();

        return new ResponseEntity<AssuntoResponse>(new AssuntoResponse(entity.getId(), entity.getNome()), HttpStatus.OK);
    }

    public ResponseEntity<AssuntoResponse> salvarAssunto(AssuntoRequest assuntoRequest){
        AssuntoEntity entity = assuntoRepository.save(new AssuntoEntity(assuntoRequest.getNome()));

        return new ResponseEntity<AssuntoResponse>(new AssuntoResponse(entity.getId(),entity.getNome()), HttpStatus.CREATED);

    }


    public ResponseEntity<AssuntoResponse> atualizarAssuntoPorId(Long id, AssuntoRequest assuntoRequest){
        AssuntoEntity entity = assuntoRepository.findById(id).get();
        entity.setNome(assuntoRequest.getNome());
        assuntoRepository.save(entity);

        return new ResponseEntity<AssuntoResponse>(new AssuntoResponse(entity.getId(), entity.getNome()), HttpStatus.OK);
    }

    public ResponseEntity<Void> deletarAssuntoPorId(Long id){
        assuntoRepository.deleteById(id);

        return ResponseEntity.accepted().build();
    }

}
