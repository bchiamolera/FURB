/*
Dados dois números inteiros descreva um algoritmo para informar o maior valor entre eles.
 */

import java.util.Scanner;

public class Uni4Exe03 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Entre com dois valores:");
        System.out.println("Valor 1:");
        int numUm = teclado.nextInt();
        System.out.println("Valor 2:");
        int numDois = teclado.nextInt();

        if (numUm > numDois) {
            System.out.println(numUm + " é maior que " + numDois);
        } else {
            System.out.println(numDois + " é maior que " + numUm);
        }

        teclado.close();
    }
}
