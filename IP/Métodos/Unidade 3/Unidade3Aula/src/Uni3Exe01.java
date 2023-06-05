/*
Uma imobiliária vende apenas terrenos retangulares.
Faça um programa para ler as dimensões de um terreno
e depois exibir a área do terreno.
 */

import java.util.Scanner;

public class Uni3Exe01 {
    public static void main(String[] args) throws Exception {
        new Uni3Exe01();
    }

    public Uni3Exe01() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe a largura do terreno (km): ");
        double largura = teclado.nextDouble();
        System.out.println("Informe o comprimento do terreno (km): ");
        double comprimento = teclado.nextDouble();
        Calcular(largura, comprimento);

        teclado.close();
    }

    private void Calcular(double largura, double comprimento) {
        System.out.println("A área do terreno é de:");
        Double area = largura * comprimento;
        System.out.println(area + "km³");
    }
}
