/*
 Um cinema pretende fazer uma pesquisa para avaliar o grau de satisfação de seus clientes. Trinta deles
 foram ouvidos e para cada um perguntou-se o sexo (1=feminino 2=masculino), uma nota para o cinema (zero
 até dez, valor inteiro) e a idade.

 Baseado nisto faça um programa que informe:
 - qual a nota média recebida pelo cinema;
 - qual a nota média atribuída pelos homens;
 - qual a nota atribuída pela mulher mais jovem;
 - quantas das mulheres com mais de 50 anos deram nota superior a média recebida pelo cinema.
 
 Utilize os conceitos aprendidos sobre vetores (ou mesmo o uso de matriz) e métodos para a resolução deste
 exercício.
 */

import java.util.Scanner;

public class Uni6Exe09 {
    public static void main(String[] args) throws Exception {
        new Uni6Exe09();
    }

    public Uni6Exe09() {
        Scanner teclado = new Scanner(System.in);
        int[] genero = new int[30];
        int[] nota = new int[30];
        int[] idade = new int[30];
        ;
        perguntas(teclado, genero, nota, idade);
        double mediaTotal = mediaTotal(nota);
        mediaHomens(genero, nota);
        notaMulherMaisJovem(genero, nota, idade);
        mulheres50(genero, nota, idade, mediaTotal);
        teclado.close();
    }

    private void perguntas(Scanner teclado, int[] genero, int[] nota, int[] idade) {
        for (int i = 0; i < 30; i++) {
            int generoOK = 0;
            System.out.println("\nPessoa " + (i + 1));
            do {
                System.out.println("Qual o seu gênero? 1 - masculino  2 - feminino");
                genero[i] = teclado.nextInt();
                if (genero[i] == 1 || genero[i] == 2) {
                    generoOK++;
                }
            } while (generoOK == 0);

            int notaOK = 0;
            do {
                System.out.println("\nQual a sua nota para o nosso cinema?");
                nota[i] = teclado.nextInt();
                if (nota[i] >= 0 && nota[i] <= 10) {
                    notaOK++;
                }
            } while (notaOK == 0);

            int idadeOK = 0;
            do {
                System.out.println("\nQual a sua idade?");
                idade[i] = teclado.nextInt();
                if (idade[i] >= 0) {
                    idadeOK++;
                }
            } while (idadeOK == 0);
        }
    }

    private double mediaTotal(int[] nota) {
        double soma = 0;
        for (int i = 0; i < nota.length; i++) {
            soma += nota[i];
        }
        double media = soma / nota.length;
        System.out.println("Noa média total do cinema = " + media);
        return media;
    }

    private void mediaHomens(int[] genero, int[] nota) {
        double notaTotal = 0;
        int cont = 0;
        for (int i = 0; i < genero.length; i++) {
            if (genero[i] == 1) {
                notaTotal += nota[i];
                cont++;
            }
        }
        double media = notaTotal / cont;
        System.out.println("Nota média dos homens = " + media);
    }

    private void notaMulherMaisJovem(int[] genero, int[] nota, int[] idade) {
        int cont = 0;
        int maisNova = 100000;
        for (int i = 0; i < genero.length; i++) {
            if (genero[i] == 2) {
                if (idade[i] < maisNova) {
                    cont = i;
                    maisNova = idade[cont];
                }
            }
        }
        System.out.println("A mulher mais jovem possui " + idade[cont] + " e sua nota foi " + nota[cont]);
    }

    private void mulheres50(int[] genero, int[] nota, int[] idade, double mediaTotal) {
        int cont = 0;
        for (int i = 0; i < genero.length; i++) {
            if (genero[i] == 2) {
                if (idade[i] > 50) {
                    if (nota[i] > mediaTotal) {
                        cont++;
                    }
                }
            }
        }
        System.out.println(cont + " mulhere(s) maiores de 50 anos deram uma nota maior que a média.");
    }
}