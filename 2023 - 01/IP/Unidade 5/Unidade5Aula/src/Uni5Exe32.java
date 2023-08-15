/*
 Escreva um programa que imprime um calendário para um determinado mês. O calendário deve conter cada 
 dia do mês e o dia da semana correspondente. A entrada consiste de um inteiro especificando em que dia 
 da semana cai o primeiro dia do mês (1=Domingo, 2=Segunda,...,7=Sábado) e um inteiro especificando o número 
 de dias que o mês possui.

 Exemplo: p = 3 n = 31 */

import java.util.Scanner;
public class Uni5Exe32 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int p = 0, n = 0, i, cont = 0;
        System.out.println("Em que dia da semana o mês começa? (1=Domingo, 2=Segunda,..., 7=Sábado)");
        p = teclado.nextInt();
        System.out.println("Quantos dias o mês possui?");
        n = teclado.nextInt();
        System.out.println("D  S  T  Q  Q  S  S");
        for (i = 1; i < p; i++) {
            System.out.print("   ");
            cont++;
        }
        for (i = 1; i <= n; i++) {
            if (i < 10) {
            System.out.print("0" + i + " ");
            } else {
                System.out.print(i + " ");
            }
            cont++;
            if (cont % 7 == 0) {
                System.out.println();
            }
        }
    }
}
