package com.example.exerciciosdevinhouses10.dataprovider.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "assunto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssuntoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String nome;

    public AssuntoEntity(String nome) {
        this.nome = nome;
    }
}
