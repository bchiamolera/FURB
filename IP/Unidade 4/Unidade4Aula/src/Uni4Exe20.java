/*
Dadas 3 notas obtidas por um aluno em 3 provas e a média dos exercícios,
descreva um algoritmo que calcule a média de aproveitamento e o conceito do aluno,
usando a fórmula:

media = (notaProva1 + notaProva2 * 2 + notaProva3 * 3 + notaExercicios) / 7

A atribuição dos conceitos obedece à tabela abaixo:
..................................
|       Media	    |  Conceito  |
| >= 9.0	        |     A      |
| >= 7.5 e < 9.0	|     B      |
| >= 6.0 e < 7.5	|     C      |
| >= 4.0 e < 6.0	|     D      |
| < 4.0             |     E      |
..................................

O algoritmo deve escrever a média de aproveitamento, o conceito correspondente e
a mensagem "aprovado" caso o conceito seja A, B ou C, e "reprovado" caso o conceito seja D ou E.
 */

import java.util.Scanner;

public class Uni4Exe20 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe a nota da prova 1: ");
        Double notaProva1 = teclado.nextDouble();
        System.out.println("Informe a nota da prova 2: ");
        Double notaProva2 = teclado.nextDouble();
        System.out.println("Informe a nota da prova 3: ");
        Double notaProva3 = teclado.nextDouble();
        System.out.println("Informe a nota dos exercícios: ");
        Double notaExercicios = teclado.nextDouble();

        Double media = (notaProva1 + notaProva2 * 2.0 + notaProva3 * 3.0 + notaExercicios) / 7.0;

        if (media >= 9) {
            System.out.println("Média de aproveitamento = " + media);
            System.out.println("Conceito = A");
            System.out.println("Aprovado");
        } else if (media >= 7.5 && media < 9.0) {
            System.out.println("Média de aproveitamento = " + media);
            System.out.println("Conceito = B");
            System.out.println("Aprovado");
        } else if (media >= 6.0 && media < 7.5) {
            System.out.println("Média de aproveitamento = " + media);
            System.out.println("Conceito = C");
            System.out.println("Aprovado");
        } else if (media >= 4.0 && media < 6.0) {
            System.out.println("Média de aproveitamento = " + media);
            System.out.println("Conceito = D");
            System.out.println("Reprovado");
        } else if (media < 4.0) {
            System.out.println("Média de aproveitamento = " + media);
            System.out.println("Conceito = E");
            System.out.println("Reprovado");
        }

        teclado.close();
    }
}
