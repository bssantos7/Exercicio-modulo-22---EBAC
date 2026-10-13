package com.example;

import java.time.LocalDateTime;

public class Evento {
    private String nome;
    private LocalDateTime dataHora;
    private DiaSemana diaSemana;

    public Evento(String nome, LocalDateTime dataHora, DiaSemana diaSemana){
        this.nome=nome;
        this.dataHora=dataHora;
        this.diaSemana=diaSemana;
    }

    public Evento(String nome, LocalDateTime dataHora, int diaSemana){
        this.nome=nome;
        this.dataHora=dataHora;
        this.diaSemana=DiaSemana.converteDia(diaSemana);

    }

}
