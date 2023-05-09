/*
 Um determinado material radioativo perde metade de sua massa a cada 50 segundos. Dada a sua massa
 inicial em Kg, descreva um algoritmo que determine o tempo necessário para que essa massa se torne
 menor que 0,5 gramas. Escreva a massa inicial, a massa final e o tempo.
*/

import java.util.Scanner;

public class Uni5Exe20 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double massaInicial = 0;
        int contador = 0;
        do {
            System.out.println("Informe a massa (Kg): ");
            massaInicial = teclado.nextDouble();
            System.out.println();
        } while (massaInicial <= 0.0005);
        double massaFinal = massaInicial;
        while (massaFinal > 0.0005) {
            massaFinal /= 2.0;
            contador++;
        }
        massaFinal *= 1000;
        int tempoSegundos = 50 * contador;
        int tempoHoras = 0, tempoMinutos = 0;
        while (tempoSegundos >= 60) {
            tempoSegundos -= 60;
            tempoMinutos++;
            if (tempoMinutos >= 60)
                tempoMinutos -= 60;
            tempoHoras++;
        }

        System.out.println("Massa Inicial = " + massaInicial + " Kg.");
        System.out.println("Massa final = " + massaFinal + " g.");
        System.out.println("Tempo necessário = " + tempoHoras + " horas, " + tempoMinutos + " minutos e "
                + tempoSegundos + " segundos.");

        teclado.close();
    }
}
