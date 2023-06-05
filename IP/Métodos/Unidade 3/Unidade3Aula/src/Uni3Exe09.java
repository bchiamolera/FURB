/*
Descreva um programa que calcule o volume de uma lata de óleo. Fórmula:
volume = pi * raio² * altura
 */

import java.util.Scanner;

public class Uni3Exe09 {
    public static void main(String[] args) throws Exception {
        new Uni3Exe09();
    }

    public Uni3Exe09() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira o raio da lata (m):");
        double raio = teclado.nextDouble();
        System.out.println("Insira a altura da lata (m):");
        double altura = teclado.nextDouble();
        Calcular(raio, altura);

        teclado.close();
    }

    private void Calcular(double raio, double altura) {
        double volume = 3.14 * raio * raio * altura * 1000;
        System.out.println("O volume da lata é: " + volume + "L");
    }
}
