/*
 Implemente o problema da mochila. Tendo-se uma sequência decrescente de números inteiros positivos que
 inicia em N, com decremento inteiro positivo K, deseja-se empacotá-los em uma mochila com tamanho M, de
 forma que se coloque dentro dela preferencialmente os maiores valores, até que ela esteja cheia. N e K
 são inteiros e devem ser definidos pelo usuário. Faça um algoritmo que imprima:
 - os elementos a serem colocados na mochila;
 - os elementos que entraram na mochila;
 - os que ficaram fora da mochila;
 - qual é a soma dos elementos que entraram na mochila;
 - qual a soma dos elementos que não entraram na mochila.
 */

import java.util.Scanner;

public class Uni5Exe30 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int N = 0, K = 0, M = 0, somaDentro = 0, somaFora = 0;
        String elementosTodos = "", elementosMochila = "", elementosFora = "";

        do {
            System.out.println("Informe N: ");
            N = teclado.nextInt();
        } while (N <= 0);

        do {
            System.out.println("Informe K: ");
            K = teclado.nextInt();
        } while (K <= 0 || K > N);

        do {
            System.out.println("Informe M: ");
            M = teclado.nextInt();
        } while (M <= 0);

        while (N > 0) {
            if (M > 0) {
                elementosMochila += N + " ";
                somaDentro += N;
            } else {
                elementosFora += N + " ";
                somaFora += N;
            }
            elementosTodos += N + " ";
            N -= K;
            M--;
        }
        System.out.println();
        System.out.println("Elementos a serem colocados: " + elementosTodos);
        System.out.println("Elementos que foram colocados: " + elementosMochila);
        System.out.println("Elementos que ficaram fora: " + elementosFora);
        System.out.println("Soma dos elementos que foram colocados: " + somaDentro);
        System.out.println("Soma dos elementos que ficaram fora: " + somaFora);

        teclado.close();
    }
}
