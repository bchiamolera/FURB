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
        new Uni3Exe16();

    }
    
    public Uni3Exe16() {
        Scanner teclado = new Scanner(System.in);

        Calcular(Ler(teclado));

        teclado.close();
    }

    private int Ler(Scanner teclado) {
        System.out.println("Insira um valor para troco:");
        int valorTroco = teclado.nextInt();
        return valorTroco;
    }

    private void Calcular(int valorTroco) {
        int notasCem = valorTroco / 100;
        int notasDez = (valorTroco - 100 * notasCem) / 10;
        int moedasUm = valorTroco - 100 * notasCem - 10 * notasDez;
        int numeroNotas = notasCem + notasDez + moedasUm;

        System.out.println("\n" + numeroNotas + " notas serão devolvidas.");
        System.out.println(notasCem + " nota(s) de R$100.");
        System.out.println(notasDez + " nota(s) de R$10.");
        System.out.println(moedasUm + " moeda(s) de R$1.");
    }
}
