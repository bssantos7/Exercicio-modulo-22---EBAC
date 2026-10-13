package com.example;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App {
    
    
    public static void exibirEvento(HashSet<Evento> agenda){
        for(Evento evento:agenda){
            System.out.println(evento.toString());
        }
    }

    public static Evento criarEvento(Scanner scanner){
        LocalDateTime dataHora;

        System.out.println("Digite o nome do evento: ");
        String nome=scanner.nextLine();
        System.out.println("informe a data do evento no modelo dd/mm/aaaa: ");
        String data = scanner.nextLine();
        System.out.println("Informe a hora no formato HH:mm: ");
        String hora=scanner.nextLine();
        String informação = data+" "+hora;
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        dataHora=LocalDateTime.parse(informação,formatador);
        System.out.println(dataHora);
        int dia = dataHora.getDayOfWeek().getValue()%7+1;

        //System.out.println("dia:"+dia);
        //System.out.println("datahora:"+dataHora);
        Evento novoEvento=new Evento(nome, dataHora, dia);
        return novoEvento;
        //dataHora.of(0, null, 0, 0, 0);
    }

    public static void adicionarDias(Scanner scanner, HashSet<Evento> agenda){
        System.out.println("Digite o nome do evento que deseja alterar");
        String nome=scanner.nextLine();
        for(Evento evento:agenda){
            if(evento.getNome().equals(nome)){
                System.out.println("Digite o número de dias que deseja aumentar:");
                int dias =Integer.parseInt(scanner.nextLine());
                LocalDateTime novadata = evento.getDataHora().plusDays(dias);
                System.out.println(novadata);
                evento.setDataHora(novadata);
            }else{
                System.out.println("Evento não encontrado");
            }
        }
    }

    public static void converterFusoHorario(Scanner scanner, HashSet<Evento> agenda){
        ZoneId sp = ZoneId.of("America/Sao_Paulo");
        ZoneId GMT = ZoneId.of("UTC");

        System.out.println("Digite o nome do evento que deseja conveter o fuso horário: ");
        String nome = scanner.nextLine();
        for(Evento e: agenda){
            if(e.getNome().equals(nome)){
                ZonedDateTime horaEvento=ZonedDateTime.of(e.getDataHora(), sp);
                ZonedDateTime horaGmt = horaEvento.withZoneSameInstant(ZoneId.of("UTC"));
                ZonedDateTime horaSp = horaEvento.withZoneSameInstant(ZoneId.of("America/Sao_Paulo"));

                System.out.println("Horário original: "+e.getDataHora());
                System.out.println("Horário fuso GMT: "+horaGmt);
                System.out.println("Horário fuso São Paulo: "+horaSp);
            }
        }
    }
    

    public static void main( String[] args ){
        Scanner scanner = new Scanner(System.in);
        HashSet<Evento> agenda = new HashSet<>();
        int continuar = 1;

        do{
            System.out.println("Digite a opção:");
            System.out.println("1 - Cadastrar novo evento");
            System.out.println("2 - Exibir agenda de eventos");
            System.out.println("3 - Adicionar dias à data do evento");
            System.out.println("4 - Converter fuso horário de evento");
            System.out.println("0 - Sair do programa");
            continuar=Integer.parseInt(scanner.nextLine());
            switch (continuar) {
                case 1:
                    agenda.add(criarEvento(scanner));
                    break;
                case 2:
                    exibirEvento(agenda);
                    break;
                case 3:
                    adicionarDias(scanner, agenda);
                    break;
                case 4:
                    converterFusoHorario(scanner, agenda);
                    break;
                case 0:
                    System.out.println("Finalizado pelo usuário");
                    break;
                default:
                    System.out.println("Numero invalido. tente novamente");
                    break;
            }
        }while(continuar!=0);        
    }
}
