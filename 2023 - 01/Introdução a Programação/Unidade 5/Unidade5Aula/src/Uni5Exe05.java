/*
Descreva um algoritmo que escreva os n primeiros termos da seguinte sequência de números:
8, 10, 16, 18, 32, 34, 64, ...
O valor n deve ser lido e deve ser maior do que 2.
*/
import java.util.Scanner;
public class Uni5Exe05 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int contador, numInput, num1, num2;
        num1 = 8;
        num2 = 10;
        System.out.println("Digite um número maior que 2: ");
        numInput = teclado.nextInt();
        if (numInput > 2) {
            System.out.print(num1 + ", " + num2);
            for (contador = 3; contador <= numInput; contador++) {
                if (contador % 2 != 0) {
                    num1 *= 2;
                    System.out.print(", " + num1);
                } else {
                    num2 = num1 + 2;
                    System.out.print(", " + num2);
                }
            }
        }
        teclado.close();
    }
}
