/*
Leia uma data e determine se ela é válida. Ou seja, verifique
se o mês está entre 1 e 12, e se o dia existe naquele mês.
Note que fevereiro tem 29 dias em anos bissextos, e 28 dias em
anos não bissextos.
 */

import java.util.Scanner;

public class Uni4Exe14 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite o dia:");
        int dia = teclado.nextInt();
        System.out.println("Digite o mês:");
        int mes = teclado.nextInt();
        System.out.println("Digite o ano:");
        int ano = teclado.nextInt();
        if (dia >= 0 && dia <= 31 && mes >= 0 && mes <= 12 && ano > 0) {
            if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                System.out.println("É válida.");
            } else if (mes != 2 && dia <= 30) {
                System.out.println("É válida.");
            } else if (mes == 2 && dia <= 28) {
                System.out.println("É válida.");
            } else if (dia == 29 && ano % 4 == 0 && !(ano % 100 == 0 && ano % 400 != 0)) {
                System.out.println("É válida.");
            } else {
                System.out.println("É inválida.");
            }
        } else {
            System.out.println("É inválida.");
        }

        teclado.close();
    }
}
