/*
Dada uma pergunta, “a cor é azul?”, faça um programa que leia
uma variável lógica com a resposta e responda “Sim”, caso a
resposta seja true, ou “Não”, caso seja false.
 */

import java.util.Scanner;

public class Uni4Exe05 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("A cor é azul?");
        boolean resposta = teclado.nextBoolean();

        if (resposta == true) {
            System.out.println("Sim.");
        } else {
            System.out.println("Não.");
        }

        teclado.close();
    }
}
