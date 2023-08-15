/*
 Dado um número inteiro positivo, determine a sua decomposição em fatores primos.
 A saída do programa deve ser semelhante ao exemplo abaixo:

 número	| decomposição
 180	|      2
 90	    |      2
 45	    |      3
 15	    |      3
 5	    |      5
 1	
 */

import java.util.Scanner;
public class Uni5Exe31 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int num = 0, divisor = 1;
        System.out.println("Informe um número");
        num = teclado.nextInt();;
        System.out.println();
        while (num > 1) {
            divisor++;
            if (num % divisor == 0) {
                System.out.println("Número: " + num + "     Decomposição: " + divisor);
                num /= divisor;
                divisor = 1;
            }
        }
        System.out.println("Número: 1");
        teclado.close();
    }
}
