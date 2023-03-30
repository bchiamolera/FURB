/*
Dados dois valores inteiros, escreva um algoritmo que informe se eles são múltiplos ou não.
 */

import java.util.Scanner;

public class Uni4Exe09 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe o primeiro valor: ");
        int numUm = teclado.nextInt();
        System.out.println("Informe o segundo valor: ");
        int numDois = teclado.nextInt();

        if ((numUm % numDois) == 0 || (numDois % numUm) == 0) {
            System.out.println("São múltiplos.");
        } else {
            System.out.println("Não são múltiplos.");
        }

        teclado.close();
    }
}
