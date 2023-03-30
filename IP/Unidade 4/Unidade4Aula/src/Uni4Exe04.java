/*
Dado um número de ponto flutuante maior do que 0,
informe se foram digitadas ou não casas decimais no número.
 */

import java.util.Scanner;

public class Uni4Exe04 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite um número real:");
        double num = teclado.nextDouble();

        if (num != (int) num) {
            System.out.println("O número possui casas decimais.");
        } else {
            System.out.println("O número não possui casas decimais.");
        }

        teclado.close();
    }
}
