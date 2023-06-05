/*
Descreva um programa que leia o comprimento dos catetos de um
    triângulo retângulo e calcule o comprimento da hipotenusa.
Fórmula:
hipotenusa² = cateto1² + cateto2²
 */

import java.util.Scanner;

public class Uni3Exe10 {
    public static void main(String[] args) throws Exception {
        new Uni3Exe10();
    }

    public Uni3Exe10() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira o comprimento do primeiro cateto (cm):");
        Double catetoUm = teclado.nextDouble();
        System.out.println("Insira o comprimento do segundo cateto (cm):");
        Double catetoDois = teclado.nextDouble();
        Calcular(catetoUm, catetoDois);

        teclado.close();
    }
    private void Calcular(double catetoUm, double catetoDois) {
        Double hipotenusa  = Math.sqrt(catetoUm * catetoUm + catetoDois * catetoDois);
        System.out.println("O comprimento da hipotenusa é de " + hipotenusa + "cm");
    }
}
