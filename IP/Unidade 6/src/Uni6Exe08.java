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
        Contar(vetor, Unico(vetor));

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
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Informe o " + (i + 1) + "º número: ");
            vetor[i] = teclado.nextDouble();
        }
    }

    private double[] Unico(double[] vetor) {
        double[] vetorUnico = new double[vetor.length];
        int index = 0;
        for (int i = 0; i < vetor.length; i++) {
            boolean existe = false;
            for (int j = 0; j < i; j++) {
                if (vetor[i] == vetor[j]) {
                    existe = true;
                }
            }
            if (!existe) {
                vetorUnico[index] = vetor[i];
                index++;
            }
        }
        return vetorUnico;
    }

    private void Contar(double[] vetor, double[] vetorUnico) {
        System.out.println();
        for (int i = 0; i < vetorUnico.length; i++) {
            System.out.print(vetorUnico[i] + " - ");
            int quantidade = 0;
            for (int j = 0; j < vetorUnico.length; j++) {
                if (vetorUnico[i] == vetor[j])
                quantidade++;
            }
            System.out.println(quantidade);
        }
    }
}
