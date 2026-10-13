package com.example;

public enum DiaSemana {

    Domingo (1,"Dom"),
    Segunda (2,"SEG"),
    Terca(3,"TER"),
    Quarta(4,"QUA"),
    Quinta(5,"QUI"),
    Sexta(6,"SEX"),
    Sábado(7,"SAB");

    private int valor;
    private String abreviacao;

    private DiaSemana(int valor, String abrevicacao){
        this.valor=valor;
        this.abreviacao=abrevicacao;
    }

    public int getValor() {
        return valor;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public static DiaSemana converteDia(int dia){
        for(DiaSemana novoDia:DiaSemana.values()){
            if(novoDia.getValor()==dia){
                return novoDia;
            }
        }
        throw new IllegalArgumentException("Numero invalido"+dia);
    }
}
