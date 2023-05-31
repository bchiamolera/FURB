/*
 * Descreva um algoritmo que leia 10 números inteiros e os coloque em um vetor de 10 posições do tipo
 * inteiro. Escreva na ordem inversa em que foram lidos. Faça um método para ler e outro para escrever.
 */

import java.util.Scanner;

public class Uni6Exe01 {
    public static void main(String[] args) throws Exception {
        new Uni6Exe01();
    }

    public Uni6Exe01() {
        Scanner teclado = new Scanner(System.in);
        int[] numeros = new int[10];
        Ler(teclado, numeros);
        Escrever(numeros);
        teclado.close();
    }

    private void Ler(Scanner teclado, int[] numeros) {
        for (int i = 0; i  < numeros.length; i++) {
            System.out.println("Informe o " + (i + 1) + "º número: ");
            numeros[i] = teclado.nextInt();
        }
    }

    private void Escrever(int[] numeros) {
        System.out.println();
        for (int i = numeros.length - 1; i >= 0; i --) {
            System.out.print(numeros[i] + " ");
        }
    }
}
