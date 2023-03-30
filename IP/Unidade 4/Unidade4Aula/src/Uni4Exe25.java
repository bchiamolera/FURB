/*
Faça um algoritmo que escreva o menu abaixo, leia uma opção do
usuário e execute a operação correspondente. O algoritmo deve
exibir uma mensagem de erro se a opção for inválida. O menu tem as seguintes opções:

Escolha uma opção:
1 - Soma de dois números.
2 - Diferença entre dois números.
3 - Produto entre dois números.
4 - Divisão entre dois números (o denominador não pode ser zero).
 */

import java.util.Scanner;

public class Uni4Exe25 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Escolha o primeiro valor: ");
        Double num1 = teclado.nextDouble();
        System.out.println("Escolha o segundo valor: ");
        Double num2 = teclado.nextDouble();

        System.out.println("Escolha uma opção: ");
        System.out.println("1 - Soma de dois números.");
        System.out.println("2 - Diferença entre dois números.");
        System.out.println("3 - Produto entre dois números.");
        System.out.println("4 - Divisão entre dois números (o denominador não pode ser zero).");
        int escolha = teclado.nextInt();

        switch (escolha) {
            case 1: {
                Double soma = num1 + num2;
                System.out.println("Soma = " + soma);
                break;
            }
            case 2: {
                Double diferenca = num1 - num2;
                System.out.println("Diferença = " + diferenca);
                break;
            }
            case 3: {
                Double produto = num1 * num2;
                System.out.println("Produto = " + produto);
                break;
            }
            case 4: {
                if (num2 != 0) {
                    Double divisao = num1 / num2;
                    System.out.println("Quociente = " + divisao);
                } else {
                    System.out.println("Erro! Divisão por 0");
                }
                break;
            }
            default: {
                System.out.println("Opção inválida.");
            }
        }

        teclado.close();
    }
}
