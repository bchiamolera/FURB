/*
 Descreva um algoritmo que leia um número inteiro n e, dados n números inteiros, descreva um algoritmo que:
 - escreva o menor valor negativo;
 - escreva a média dos números positivos.
 */

import java.util.Scanner;
public class Uni5Exe08 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int n, contador;
        double nReal = 0;
        double menorNum = 0;
        int numPositivos = 0;
        double total= 0;
        System.out.println("Insira um número inteiro positivo: ");
        n = teclado.nextInt();
        for (contador = 1; contador <= n; contador++) {
            System.out.println("Insira um número: ");
            nReal = teclado.nextDouble();
            if (nReal < 0 && nReal < menorNum) {
                menorNum = nReal;
            }
            if (nReal > 0) {
                total += nReal;
                numPositivos++;
            }
        }
        double media = total / numPositivos;
        if (menorNum != 0) {
            System.out.println("Menor número negativo = " + menorNum);
        }
        if (media != 0) {
            System.out.println("Média dos positivos = " + media);
        }
        teclado.close();
    }
}
