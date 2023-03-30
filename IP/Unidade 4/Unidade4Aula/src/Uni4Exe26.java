/*
Dado um caractere indicando uma opção, escreva um algoritmo para:

se opção = ‘T’: calcular a área de um triângulo de base b e altura h
se opção = ‘Q’: calcular a área de um quadrado de lado l
se opção = ‘R’: calcular a área de um retângulo de base b e altura h
se opção = ‘C’: calcular a área de um círculo de raio r
 */

import java.util.Scanner;
import java.lang.Math;

public class Uni4Exe26 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Escolha uma opção: ");
        System.out.println("Opção = 'T': calcular a área de um triângulo de base 'b' e altura 'h'");
        System.out.println("Opção = 'Q': calcular a área de um quadrado de lado 'l'");
        System.out.println("Opção = 'R': calcular a área de um retângulo de base 'b' e altura 'h'");
        System.out.println("Opção = 'C': calcular a área de um círculo de raio 'r'");
        char escolha = teclado.nextLine().toUpperCase().charAt(0);

        switch (escolha) {
            case 'T': {
                System.out.println("Escolha o valor da base 'b'");
                Double b = teclado.nextDouble();
                System.out.println("Escolha o valor da altura 'h'");
                Double h = teclado.nextDouble();
                Double area = (b * h) / 2;
                System.out.println("Área = " + area);
                break;
            }
            case 'Q': {
                System.out.println("Escolha o valor do lado 'l'");
                Double l = teclado.nextDouble();
                Double area = Math.pow(l, 2);
                System.out.println("Área = " + area);
                break;
            }
            case 'R': {
                System.out.println("Escolha o valor da base 'b'");
                Double b = teclado.nextDouble();
                System.out.println("Escolha o valor da altura 'h'");
                Double h = teclado.nextDouble();
                Double area = (b * h);
                System.out.println("Área = " + area);
                break;
            }
            case 'C': {
                System.out.println("Escolha o valor do raio 'r'");
                Double r = teclado.nextDouble();
                Double area = Math.PI * Math.pow(r, 2);
                System.out.println("Área = " + area);
                break;
            }
            default: {
                System.out.println("Opção inválida.");
            }
        }

        teclado.close();
    }
}
