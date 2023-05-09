/*
 Dada uma turma de alunos, contendo seu nome e nota de duas provas descreva um algoritmo
 para informar a média de cada aluno. Considere que a leitura dos dados deve ser finalizada
 quando o nome do aluno for “fim”.
 */

import java.util.Scanner;

public class Uni5Exe15 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nome;
        Double nota1, nota2, media = 0.0;
        System.out.println("Digite o nome do(a) aluno(a): ");
        nome = teclado.next();
        while (!nome.trim().equalsIgnoreCase("fim")) {
            System.out.println("Digite a nota da prova 1: ");
            nota1 = teclado.nextDouble();
            System.out.println("Digite a nota da prova 2: ");
            nota2 = teclado.nextDouble();
            media = (nota1 + nota2) / 2;
            System.out.println("Média de " + nome + ": " + media);
            System.out.println("\nDigite o nome do(a) próximo(a) aluno(a): ");
            nome = teclado.next();
        }
        teclado.close();
    }
}
