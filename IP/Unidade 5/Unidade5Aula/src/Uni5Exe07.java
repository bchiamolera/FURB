
/*
 Descreva um algoritmo que leia um número inteiro n e, dados n números
 reais informe o maior e o menor número.
 */
import java.util.Scanner;

public class Uni5Exe7 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int n, contador;
        double nReal, maiorReal, menorReal;
        maiorReal = 0;
        menorReal = 0;
        System.out.println("Digite um número inteiro: ");
        n = teclado.nextInt();
        for (contador = 1; contador <= n; contador++) {
            System.out.println("Digite um número: ");
            nReal = teclado.nextDouble();
            if (contador == 1) {
                maiorReal = nReal;
                menorReal = nReal;
            } else {
                if (nReal > maiorReal) {
                    maiorReal = nReal;
                }
                if (nReal < menorReal) {
                    menorReal = nReal;
                }
            }
        }
        System.out.println("Maior número = " + maiorReal);
        System.out.println("Menor número = " + menorReal);
    }
}
