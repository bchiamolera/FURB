/*
Dados 3 valores, escreva um algoritmo que os informe em uma determinada
ordem a partir de um menu de opções:

se opção = 1, escreva os 3 valores em ordem crescente
se opção = 2, escreva os 3 valores em ordem decrescente
se opção = 3, escreva os 3 valores de forma que o maior valor fique no meio
 */

import java.util.Scanner;

public class Uni4Exe24 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Escolha o número de um valor: ");
        int num1 = teclado.nextInt();
        System.out.println("Escolha o número de outro valor: ");
        int num2 = teclado.nextInt();
        System.out.println("Escolha o número de mais um valor: ");
        int num3 = teclado.nextInt();
        System.out.println("Escolha uma opção: ");
        System.out.println(
                "se opção = 1, escreva os 3 valores em ordem crescente \nse opção = 2, escreva os 3 valores em ordem decrescente \nse opção = 3, escreva os 3 valores de forma que o maior valor fique no meio");
        int escolha = teclado.nextInt();

        switch (escolha) {
            case 1: {
                if (num1 >= num2 && num2 >= num3) {
                    System.out.println(num3 + ", " + num2 + " e " + num1);
                } else if (num1 >= num3 && num3 >= num2) {
                    System.out.println(num2 + ", " + num3 + " e " + num1);
                } else if (num2 >= num1 && num1 >= num3) {
                    System.out.println(num3 + ", " + num1 + " e " + num2);
                } else if (num2 >= num3 && num3 >= num1) {
                    System.out.println(num1 + ", " + num3 + " e " + num2);
                } else if (num3 >= num1 && num1 >= num2) {
                    System.out.println(num2 + ", " + num1 + " e " + num3);
                } else if (num3 >= num2 && num2 >= num1) {
                    System.out.println(num1 + ", " + num2 + " e " + num3);
                } else {
                    System.out.println("Valor inválido");
                }
                break;

            }
            case 2: {
                if (num1 >= num2 && num2 >= num3) {
                    System.out.println(num1 + ", " + num2 + " e " + num3);
                } else if (num1 >= num3 && num3 >= num2) {
                    System.out.println(num1 + ", " + num3 + " e " + num2);
                } else if (num2 >= num1 && num1 >= num3) {
                    System.out.println(num2 + ", " + num1 + " e " + num3);
                } else if (num2 >= num3 && num3 >= num1) {
                    System.out.println(num2 + ", " + num3 + " e " + num1);
                } else if (num3 >= num1 && num1 >= num2) {
                    System.out.println(num3 + ", " + num1 + " e " + num2);
                } else if (num3 >= num2 && num2 >= num1) {
                    System.out.println(num3 + ", " + num2 + " e " + num1);
                } else {
                    System.out.println("Valor inválido");
                }
                break;
            }
            case 3: {
                if (num1 >= num2 && num2 >= num3) {
                    System.out.println(num2 + ", " + num1 + " e " + num3);
                } else if (num1 >= num3 && num3 >= num2) {
                    System.out.println(num3 + ", " + num1 + " e " + num2);
                } else if (num2 >= num1 && num1 >= num3) {
                    System.out.println(num1 + ", " + num2 + " e " + num3);
                } else if (num2 >= num3 && num3 >= num1) {
                    System.out.println(num3 + ", " + num2 + " e " + num1);
                } else if (num3 >= num1 && num1 >= num2) {
                    System.out.println(num1 + ", " + num3 + " e " + num2);
                } else if (num3 >= num2 && num2 >= num1) {
                    System.out.println(num2 + ", " + num3 + " e " + num1);
                } else {
                    System.out.println("Valor inválido");
                }
                break;
            }
            default: {
                System.out.println("Valor inválido.");
            }
        }

        teclado.close();
    }
}
