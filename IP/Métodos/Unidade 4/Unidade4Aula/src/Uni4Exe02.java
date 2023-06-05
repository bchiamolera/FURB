/*
Dado um valor inteiro maior do que 0 informe se o valor é par ou ímpar.
Para resolver este problema pode se utilizar do algoritmo descrito no fluxograma:
 */

import java.util.Scanner;

public class Uni4Exe02 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Entre com um valor inteiro maior do que 0:");
        int num = teclado.nextInt();
        if (num % 2 == 0) {
            System.out.println("O número é par.");
        } else {
            System.out.println("O número é ímpar.");
        }

        teclado.close();
    }
}
