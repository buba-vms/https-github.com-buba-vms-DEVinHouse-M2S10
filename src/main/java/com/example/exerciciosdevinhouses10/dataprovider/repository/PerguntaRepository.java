package com.example.exerciciosdevinhouses10.dataprovider.repository;

import com.example.exerciciosdevinhouses10.dataprovider.entity.AssuntoEntity;
import com.example.exerciciosdevinhouses10.dataprovider.entity.PerguntaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PerguntaRepository extends JpaRepository<PerguntaEntity, Long> {


    @Query("SELECT p from PerguntaEntity p where p.assuntoEntity.nome = :nome")
    public List<PerguntaEntity> findAllByAssuntoNome(@Param("nome") String nome);




}
