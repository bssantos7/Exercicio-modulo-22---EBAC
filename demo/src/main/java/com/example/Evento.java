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


    @Override
    public String toString() {
        return "Evento [nome=" + nome + ", dataHora=" + dataHora + ", diaSemana=" + diaSemana + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((dataHora == null) ? 0 : dataHora.hashCode());
        result = prime * result + ((diaSemana == null) ? 0 : diaSemana.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Evento other = (Evento) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (dataHora == null) {
            if (other.dataHora != null)
                return false;
        } else if (!dataHora.equals(other.dataHora))
            return false;
        if (diaSemana != other.diaSemana)
            return false;
        return true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    

}
