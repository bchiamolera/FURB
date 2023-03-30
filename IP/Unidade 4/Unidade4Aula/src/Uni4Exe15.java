/*
Elabore um algoritmo para exibir o valor de reajuste que um funcionário
receberá no seu salário. A empresa irá conceder 5% de reajuste para o
funcionário que for admitido há menos de 12 meses. Para funcionário admitido
entre 13 e 48 meses, irá conceder 7% de reajuste. O seu algoritmo deve
solicitar ao usuário que digite a quantidade de meses que o funcionário foi admitido.
 */

import java.util.Scanner;

public class Uni4Exe15 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe há quantos meses o funcionário foi admitido:");
        int meses = teclado.nextInt();

        if (meses < 49) {
            if (meses < 13) {
                System.out.println("Reajuste de 5%");
            } else {
                System.out.println("Reajuste de 7%");
            }
        } else {
            System.out.println("Sem reajuste.");
        }

        teclado.close();
    }
}
