/*
Descreva um programa que leia o comprimento dos catetos de um
    triângulo retângulo e calcule o comprimento da hipotenusa.
Fórmula:
hipotenusa² = cateto1² + cateto2²
 */

import java.util.Scanner;

public class Uni3Exe10 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira o comprimento do primeiro cateto (cm):");
        Double catetoUm = teclado.nextDouble();
        System.out.println("Insira o comprimento do segundo cateto (cm):");
        Double catetoDois = teclado.nextDouble();
        Double hipotenusa  = Math.sqrt(catetoUm * catetoUm + catetoDois * catetoDois);
        System.out.println("O comprimento da hipotenusa é de " + hipotenusa + "cm");

        teclado.close();
    }
}
