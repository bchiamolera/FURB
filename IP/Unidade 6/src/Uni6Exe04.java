
/*
 * Faça um programa para ler os valores de dois vetores de inteiros, cada um contendo 10 elementos.
 * Crie um terceiro vetor em que cada elemento é a soma dos valores contidos nas posições respectivas
 * dos vetores originais. Por exemplo, vetor1 = [1,2,3] vetor2 = [1,5,6] vetor3 = [2,7,9]. Exiba, ao
 * final, os três vetores na tela. Faça três métodos: um método para ler valores dos vetores, outro
 * para somar e outro para escrever os vetores.
 */
import java.util.Scanner;

public class Uni6Exe04 {
    public static void main(String[] args) {
        new Uni6Exe04();
    }

    public Uni6Exe04() {
        Scanner teclado = new Scanner(System.in);
        int[] num1 = new int[10];
        int[] num2 = new int[10];
        int[] soma = new int[10];
        Ler(teclado, num1, num2);
        Somar(num1, num2, soma);
        Escrever(num1, num2, soma);
        teclado.close();
    }

    private void Ler(Scanner teclado, int[] num1, int[] num2) {
        for (int i = 0; i < num1.length; i++) {
            System.out.println("Informe o " + (i + 1) + "º número do vetor 1: ");
            num1[i] = teclado.nextInt();
        }
        System.out.println();
        for (int i = 0; i < num2.length; i++) {
            System.out.println("Informe o " + (i + 1) + "º número do vetor 2: ");
            num2[i] = teclado.nextInt();
        }
    }

    private void Somar(int[] num1, int[] num2, int[] soma) {
        for (int i = 0; i < soma.length; i++) {
            soma[i] = num1[i] + num2[i];
        }
    }

    private void Escrever(int[] num1, int[] num2, int[] soma) {
        System.out.println();
        System.out.print("Vetor 1: ");
        for (int i = 0; i < num1.length; i++) {
            System.out.print(num1[i] + " ");
        }
        System.out.println();
        System.out.print("Vetor 2: ");
        for (int i = 0; i < num2.length; i++) {
            System.out.print(num2[i] + " ");
        }
        System.out.println();
        System.out.print("Vetor 3: ");
        for (int i = 0; i < soma.length; i++) {
            System.out.print(soma[i] + " ");
        }
    }
}
