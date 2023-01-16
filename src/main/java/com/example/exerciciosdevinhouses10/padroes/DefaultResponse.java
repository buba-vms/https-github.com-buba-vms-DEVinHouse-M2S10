package com.example.exerciciosdevinhouses10.padroes;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DefaultResponse<T> {
    private int status;
    private T data;


}
