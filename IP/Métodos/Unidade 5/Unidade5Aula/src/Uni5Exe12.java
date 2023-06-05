
/*
 Escreva um programa que leia um número inteiro positivo n e em seguida imprima
 n linhas do chamado Triangulo de Floyd:

 1
 2  3
 4  5  6
 7  8  9  10
 11 12 13 14 15
 16 17 18 19 20 21
 ...
 */
import java.util.Scanner;

public class Uni5Exe12 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int linhas, colunas, num = 1;
        System.out.println("Digite um número: ");
        int n = teclado.nextInt();
        System.out.println();
        for (linhas = 1; linhas <= n; linhas++) {
            for (colunas = 1; colunas <= linhas; colunas++) {
                if (num <= 10) {
                    System.out.print(num + "  ");
                } else {
                    System.out.print(num + " ");
                }
                num++;
            }
            System.out.println();
        }
        teclado.close();
    }
}
