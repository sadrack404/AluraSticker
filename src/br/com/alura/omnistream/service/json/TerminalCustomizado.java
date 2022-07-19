package br.com.alura.omnistream.service.json;

public class TerminalCustomizado {

    public String negrito = "\u001b[1m";
    public String reset =  "\u001b[0m";

    public void rent ( double imDbRatin) {
        if (imDbRatin == 10 ) {
            System.out.println("\uD83D \uD83D \uD83D \uD83D \uD83D");
        }
        else if ( imDbRatin < 10 && imDbRatin > 8){
            System.out.println("\uD83D \uD83D \uD83D \uD83D");
        }
        else if ( imDbRatin < 10 && imDbRatin > 7){
            System.out.println("\uD83D \uD83D \uD83D");
        }
        else if ( imDbRatin < 10 && imDbRatin > 6){
            System.out.println("\uD83D \uD83D ");
        }
        else if (imDbRatin > 5 && imDbRatin < 1){
            System.out.println("\uD83D");
        }
        System.out.println("\uD83D");
    }
}
