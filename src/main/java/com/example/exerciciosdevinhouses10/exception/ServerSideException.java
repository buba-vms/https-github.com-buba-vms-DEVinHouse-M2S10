package com.example.exerciciosdevinhouses10.exception;

public class ServerSideException extends RuntimeException{


    ServerSideException(String message){
        super(message);

    }

    ServerSideException(){
        super();
    }
}
