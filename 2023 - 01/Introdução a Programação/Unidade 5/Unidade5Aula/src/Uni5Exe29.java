/*
 Um caixa automático possui cédulas de 1, 2, 5, 10 e 20. Faça um programa que leia um valor e informe
 a quantidade mínima de cédulas que ele precisará combinar para entregar o valor solicitado. Por exemplo:
 se o valor for 6, então ele fornecerá uma cédula de 5 e outra de 1. Se o número for 47, então ele
 fornecerá duas cédulas de 20, uma de 5 e outras de 2.
 */

 import java.util.Scanner;
public class Uni5Exe29 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int valor = 0;
        int notas100 = 0, notas50 = 0, notas20 = 0, notas10 = 0, notas5 = 0, notas2 = 0, moedas1 = 0;
        System.out.println("Informe um valor inteiro (R$)");
        valor = teclado.nextInt();
        while (valor > 0) {
            if (valor >= 100) {
                valor -= 100;
                notas10++;
            } else if (valor >= 50) {
                valor -= 50;
                notas50++;
            } else if (valor >= 20) {
                valor -= 20;
                notas20++;
            } else if (valor >= 10) {
                valor -= 10;
                notas10++;
            } else if (valor >= 5) {
                valor -= 5;
                notas5++;
            } else if (valor >= 2) {
                valor -= 2;
                notas2++;
            } else {
                valor -= 1;
                moedas1++;
            }
        }
        System.out.println("Nota(s) de 100: " + notas100);
        System.out.println("Nota(s) de 50: " + notas50);
        System.out.println("Nota(s) de 20: " + notas20);
        System.out.println("Nota(s) de 10: " + notas10);
        System.out.println("Nota(s) de 5: " + notas5);
        System.out.println("Nota(s) de 2: " + notas2);
        System.out.println("Moeda(s) de 1: " + moedas1);
        teclado.close();
    }
}
