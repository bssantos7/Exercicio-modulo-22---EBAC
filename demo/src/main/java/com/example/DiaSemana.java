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
        boolean continua=true;
        DiaSemana novoDia=DiaSemana.Domingo;
        do{
            switch (dia) {
                case 1:
                    novoDia=DiaSemana.Domingo;
                    continua=false;
                    break;
                case 2:
                    novoDia=DiaSemana.Segunda;
                    continua=false;
                    break;
                case 3:
                    novoDia=DiaSemana.Terca;
                    continua=false;
                    break;
                case 4:
                    novoDia=DiaSemana.Quarta;
                    continua=false;
                    break;
                case 5:
                    novoDia=DiaSemana.Quinta;
                    continua=false;
                    break;
                case 6:
                    novoDia=DiaSemana.Sexta;
                    continua=false;
                    break;
                case 7:
                    novoDia=DiaSemana.Sábado;
                    continua=false;
                    break;
                default:
                    System.out.println("Numero invalido. Tente Novamente");
                    continua=true;
                    break;
            }
        }while(continua==true);
        return novoDia;
    }
}
