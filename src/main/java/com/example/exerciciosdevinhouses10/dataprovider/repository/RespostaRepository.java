package com.example.exerciciosdevinhouses10.dataprovider.repository;

import com.example.exerciciosdevinhouses10.dataprovider.entity.PerguntaEntity;
import com.example.exerciciosdevinhouses10.dataprovider.entity.RespostaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RespostaRepository extends JpaRepository<RespostaEntity, Long> {


    @Query("select r from RespostaEntity r where r.perguntaEntity.titulo = :pergunta")
    public List<RespostaEntity> findAllByPergunta(String pergunta);
}
