/*
 Descreva um algoritmo que leia a altura de 20 pessoas e calcule a média de altura das mesmas.
 */
import java.util.Scanner;

public class Uni5Exe06 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int contador;
        double altura, soma, media;
        altura = 0;
        soma = 0;
        media = 0;
        for (contador = 1; contador <= 20; contador++) {
            System.out.println("Insira a altura: ");
            altura = teclado.nextDouble();
            soma += altura;
        }
        media = soma / 20;
        System.out.println("Média: " + media + "\n");
        teclado.close();
    }
}
