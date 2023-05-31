
/*
 Faça um programa que leia um valor N inteiro. Com base neste valor, crie um vetor do tipo real. Em
 seguida, solicite ao usuário informar essa quantidade N de valores reais para popular o vetor. Após ter
 preenchido o vetor, solicite que o usuário informe um outro valor real. Informe para o usuário se este
 valor informado se encontra cadastrado no vetor. Faça um método para ler o vetor e outro, que retorne
 verdadeiro ou falso, para encontrar o valor.
*/
import java.util.Scanner;

public class Uni6Exe06 {
    public static void main(String[] args) {
        new Uni6Exe06();
    }

    public Uni6Exe06() {
        Scanner teclado = new Scanner(System.in);
        double[] vetor = new double[LerN(teclado)];
        Ler(teclado, vetor);
        Escrever(Procurar(vetor, LerR(teclado)));
    }

    private int LerN(Scanner teclado) {
        int N = 0;
        System.out.println("Informe o tamanho do vetor: ");
        N = teclado.nextInt();
        return N;
    }

    private void Ler(Scanner teclado, double[] vetor) {
        System.out.println();
        for (int i = 0; i  < vetor.length; i++) {
            System.out.println("Informe o " + (i + 1) + "º número: ");
            vetor[i] = teclado.nextDouble();
        }
    }

    private double LerR(Scanner teclado) {
        double R = 0;
        System.out.println();
        System.out.println("Informe o número que deseja procurar: ");
        R = teclado.nextInt();
        return R;
    }

    private boolean Procurar(double[] vetor, double R) {
        int validacao = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == R) {
                validacao++;
            }
        }
        if (validacao > 0) {
            return true;
        } else {
            return false;
        }
    }

    private void Escrever(boolean procurar) {
        System.out.println();
        if (procurar) {
            System.out.println("O valor está cadastrado.");
        } else {
            System.out.println("O valor NÃO está cadastrado.");
        }
    }
}
