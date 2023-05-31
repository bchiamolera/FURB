/*
 * Descreva um algoritmo que leia 12 valores reais e os coloque em um vetor de 12 posições do tipo real.
 * Em seguida, modifique o vetor de modo que os valores das posições ímpares sejam aumentados em 5% e os
 * das posições pares sejam aumentados em 2%. Imprima o vetor resultante. Faça um método para ler os valores,
 * outro para ajustar os valores dentro do vetor e outro para escrever os valores atualizados do vetor.
 */
import java.util.Scanner;

public class Uni6Exe03 {
    public static void main(String[] args) {
        new Uni6Exe03();
    }

    public Uni6Exe03() {
        Scanner teclado = new Scanner(System.in);
        double[] numeros = new double[12];
        Ler(teclado, numeros);
        Ajustar(numeros);
        Escrever(numeros);
        teclado.close();
    }
    
    private void Ler(Scanner teclado, double[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
        System.out.println("Informe o " + (i + 1) + "º número: ");
            numeros[i] = teclado.nextDouble();
        }
    }

    private void Ajustar(double[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            if ((i + 1) % 2 != 0) {
                numeros[i] += numeros[i] * 0.05;
            } else {
                numeros[i] += numeros[i] * 0.02;
            }
        }
    }

    private void Escrever(double[] numeros) {
        System.out.println();
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
    }
}
