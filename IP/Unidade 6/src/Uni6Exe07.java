
/*
 * Faça um programa que leia um valor N inteiro limitado a 20 posições. Com base neste valor, crie um vetor
 * do tipo inteiro. Em seguida, solicite ao usuário para digitar um número inteiro várias vezes, até
 * preencher o vetor. Esse número deverá ser armazenado no vetor caso ainda não exista, e se o valor já
 * existir deve ser pedido um novo valor. Isto é, se o usuário informar o número 2 e já existir o número 2
 * em alguma posição do vetor, o número não deve ser adicionado. Após ter adicionado todos os números dentro
 * do vetor, o mesmo deve ser ordenado. Para isso reordene os elementos internos do vetor de modo que este
 * fique em ordem crescente, conforme no exemplo:
 * 
 * - Vetor origem: [0][4][2][6][3]
 * - Vetor ordenado: [0][2][3][4][6]
 * 
 * Crie um método para inserir os valores no vetor, outro para ordenar o vetor e outro para informar o vetor
 * resultante. Para "método ordenar" se pode usar o "método bolha" explicado neste vídeo.
 */
import java.util.Scanner;

public class Uni6Exe07 {
    public static void main(String[] args) {
        new Uni6Exe07();
    }

    public Uni6Exe07() {
        Scanner teclado = new Scanner(System.in);
        int[] vetor = new int[LerN(teclado)];
        Ler(teclado, vetor);
        Organizar(vetor);
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

    private void Ler(Scanner teclado, int[] vetor) {
        int temp;
        int verify;
        System.out.println();
        for (int i = 0; i < vetor.length; i++) {
            verify = 0;
            do {
                System.out.println("Informe o " + (i + 1) + "º número: ");
                temp = teclado.nextInt();
                if (Verificar(vetor, i, temp)) {
                    System.out.println("Número já existe!");
                    System.out.println();
                } else {
                    vetor[i] = temp;
                    verify++;
                }
            } while (verify == 0);
        }
    }

    private boolean Verificar(int[] vetor, int i, int num) {
        boolean v = false;
        for (int j = 0; j <= i; j++) {
            if (num == vetor[j]) {
                v = true;
                break;
            }
        }
        return v;
    }

    private void Organizar(int[] vetor) {
        int temp;
        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j < vetor.length - 1; j++) {
                if (vetor[j] > vetor[i]) {
                    temp = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = temp;
                }
            }
        }
    }

    private void Escrever(int[] vetor) {
        System.out.println();
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
    }
}
