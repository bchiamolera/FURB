/*
Suponha que um caixa disponha apenas de notas de 100, 10 e 1 reais.
Considerando que alguém está pagando uma compra, faça um programa
que determine e escreva o número mínimo de notas que o caixa deve
fornecer como troco. Escreva também o número de cada tipo de nota
a ser fornecido como troco. Suponha que o sistema monetário não
utilize centavos.
 */

import java.util.Scanner;

public class Uni3Exe16 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira um valor para troco:");
        int valorTroco = teclado.nextInt();
        int notasCem = 0;
        int notasDez = 0;
        int moedasUm = 0;
        int numeroNotas = 0;

        notasCem = valorTroco / 100.0;
        notasDez = (valorTroco - 100.0 * notasCem) / 10.0;
        moedasUm = valorTroco - 100.0 * notasCem - 10.0 * notasDez;
        numeroNotas = notasCem + notasDez + moedasUm;

        System.out.println("\n" + numeroNotas + " notas serão devolvidas.");
        System.out.println(notasCem + " nota(s) de R$100.");
        System.out.println(notasDez + " nota(s) de R$10.");
        System.out.println(moedasUm + " moeda(s) de R$1.");

        teclado.close();
    }
}
