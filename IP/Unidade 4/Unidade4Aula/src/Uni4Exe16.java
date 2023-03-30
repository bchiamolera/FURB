/*
Escreva um algoritmo que leia a idade de 2 homens e 2 mulheres
(considere que a idade entre homens e mulheres sempre serão diferentes).
Calcule e escreva a soma das idades do homem mais velho com a mulher mais
nova, e o produto das idades do homem mais novo com a mulher mais velha.
 */

import java.util.Scanner;

public class Uni4Exe16 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe a idade do primeiro homem:");
        int homem1 = teclado.nextInt();
        System.out.println("Informe a idade do segundo homem:");
        int homem2 = teclado.nextInt();
        System.out.println("Informe a idade da primeira mulher:");
        int mulher1 = teclado.nextInt();
        System.out.println("Informe a idade da segunda mulher:");
        int mulher2 = teclado.nextInt();

        int soma = 0;
        int produto = 0;

        if (homem1 > homem2 && mulher1 > mulher2) {
            soma = homem1 + mulher2;
            produto = homem2 * mulher1;
            System.out.println("Soma do homem mais velho com a mulher mais nova: " + soma);
            System.out.println("Produto do homem mais novo com a mulher mais velha: " + produto);
        } else if (homem2 > homem1 && mulher1 >  mulher2) {
            soma = homem2 + mulher2;
            produto = homem1 * mulher1;
            System.out.println("Soma do homem mais velho com a mulher mais nova: " + soma);
            System.out.println("Produto do homem mais novo com a mulher mais velha: " + produto);
        } else if (homem1 > homem2 && mulher2 > mulher1) {
            soma = homem1 + mulher1;
            produto = homem2 * mulher2;
            System.out.println("Soma do homem mais velho com a mulher mais nova: " + soma);
            System.out.println("Produto do homem mais novo com a mulher mais velha: " + produto);
        } else {
            soma = homem2 + mulher2;
            produto = homem1 * mulher1;
            System.out.println("Soma do homem mais velho com a mulher mais nova: " + soma);
            System.out.println("Produto do homem mais novo com a mulher mais velha: " + produto);
        }

        teclado.close();
    }
}
