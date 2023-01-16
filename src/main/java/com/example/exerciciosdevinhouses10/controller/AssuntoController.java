package com.example.exerciciosdevinhouses10.controller;

import com.example.exerciciosdevinhouses10.controller.dto.AssuntoRequest;
import com.example.exerciciosdevinhouses10.controller.dto.AssuntoResponse;
import com.example.exerciciosdevinhouses10.dataprovider.entity.AssuntoEntity;
import com.example.exerciciosdevinhouses10.dataprovider.repository.AssuntoRepository;
import com.example.exerciciosdevinhouses10.service.AssuntoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/assuntos")

public class AssuntoController {



    private final AssuntoService assuntoService;

    public AssuntoController( AssuntoService assuntoService) {
        this.assuntoService = assuntoService;
    }

    @GetMapping
    public ResponseEntity<List<AssuntoResponse>> encontrarAssuntos(){
        return assuntoService.listarAssuntos();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AssuntoResponse> encontrarAssuntoPorId(@PathVariable Long id){
        return assuntoService.encontrarAssuntoPorId(id);
    }


    @PostMapping
    public ResponseEntity<AssuntoResponse> salvarAssunto(@RequestBody AssuntoRequest assuntoRequest){
        return assuntoService.salvarAssunto(assuntoRequest);
    }




    @PutMapping(path = "/{id}")
    public ResponseEntity<AssuntoResponse> atualizarAssuntoPorId(@PathVariable Long id, @RequestBody AssuntoRequest assuntoRequest){
        return assuntoService.atualizarAssuntoPorId(id,assuntoRequest);
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletarAssuntoPorId(@PathVariable Long id){
        return assuntoService.deletarAssuntoPorId(id);
    }

}
