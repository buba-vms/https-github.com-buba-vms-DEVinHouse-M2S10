package com.example.exerciciosdevinhouses10.dataprovider.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "resposta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RespostaEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String texto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pergunta")
    private PerguntaEntity perguntaEntity;


    public RespostaEntity(String texto, PerguntaEntity perguntaEntity) {
        this.texto = texto;
        this.perguntaEntity = perguntaEntity;
    }


}
