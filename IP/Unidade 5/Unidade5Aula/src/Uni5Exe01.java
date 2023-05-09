/*
 Descreva um algoritmo que leia 20 números inteiros e escreva, para
 cada número lido, se o mesmo é par ou ímpar.
 */
import java.util.Scanner;
public class Uni5Exe01 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        int num;
        for (num = 1; num <= 20; num++) {
            System.out.println("Digite um número: ");
            int numLido = teclado.nextInt();
            if (numLido % 2 == 0) {
                System.out.println("Par.");
            } else {
                System.out.println("Ímpar.");
            }
        }
        teclado.close();
    }
}
