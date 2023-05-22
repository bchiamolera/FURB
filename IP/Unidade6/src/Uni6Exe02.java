/*
 * Descreva um algoritmo que leia 12 valores reais e os coloque em um vetor de 12 posições do tipo real.
 * Imprima quais valores desses informados são maiores que a média dos valores. Faça um método para ler os
 * valores, outro para calcular a média e outro para informar os valores maiores que a média.
 */

import java.util.Scanner;

public class Uni6Exe02 {
    public static void main(String[] args) {
        new Uni6Exe02();
    }

    public Uni6Exe02() {
        Scanner teclado = new Scanner(System.in);
        double[] numeros = new double[12];
        Ler(teclado, numeros);
        double media = Media(numeros);
        Escrever(numeros, media);
        teclado.close();
    }

    private void Ler(Scanner teclado, double[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Informe o " + (i + 1) + "º número: ");
            numeros[i] = teclado.nextDouble();
        }
    }

    private double Media(double[] numeros) {
        double soma = 0;
        for (int i = 0; i < numeros.length; i++) {
            soma += numeros[i];
        }
        return soma / numeros.length;
    }

    private void Escrever(double[] numeros, double media) {
        System.out.println();
        System.out.println("Média = " + media);
        System.out.println("Números acima da média: ");
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] > media) {
                System.out.print(numeros[i] + " ");
            }
        }
    }
}