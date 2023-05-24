/*
 * Faça um programa que leia um valor N inteiro limitado a 20 posições. Com base neste valor, crie um vetor
 * do tipo real. Faça o usuário informar valores para as posições deste vetor e coloque-as nas posições na
 * sequência informada pelo usuário. Imprima uma tabela contendo cada valor diferente e o número de vezes
 * que o valor aparece no vetor (veja exemplo a seguir).
 */
import java.util.Scanner;

public class Uni6Exe08 {
    public static void main(String[] args) {
        new Uni6Exe08();
    }

    public Uni6Exe08() {
        Scanner teclado = new Scanner(System.in);
        double[] vetor = new double[LerN(teclado)];
        Ler(teclado, vetor);
        Escrever(vetor);
        teclado.close();
    }

    private int LerN(Scanner teclado) {
        int N = 0;
        do {
            System.out.println("Informe o tamanho do vetor (Máx.: 20): ");
            N = teclado.nextInt();
        } while (N <= 0 || N > 20);
        return N;
    }

    private void Ler(Scanner teclado, double[] vetor) {
        System.out.println();
        for (int i = 0; i  < vetor.length; i++) {
            System.out.println("Informe o " + (i + 1) + "º número: ");
            vetor[i] = teclado.nextDouble();
        }
    }

    private void RemoverRepetições(double[] vetor2) {
        int contarNums = 0;
        for (int i = 0; i < vetor2.length; i++) {
            for (int j = i + 1; j < vetor2.length; i++) {
                if (vetor2[i] != vetor2[j]) {
                    contarNums++;
                }
            }
        }
        double[] vetorSemRepetir = new double[contarNums];

    }

    private double[] Organizar(double[] vetor) {
        double[] vetor2 = new double[vetor.length];
        for (int i = 0; i < vetor.length; i++) {
            vetor2[i] = vetor[i];
        }
        double temp = 0;
        for (int i = 0; i < vetor2.length; i++) {
            for (int j = 0; j < vetor2.length - 1; j++) {
                if (vetor2[j] > vetor2[i]) {
                    temp = vetor2[i];
                    vetor2[i] = vetor2[j];
                    vetor2[j] = temp;
                }
            }
        }
        return vetor2;
    }

    private void Escrever(double[] vetor) {
        System.out.println();
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
    }
}
