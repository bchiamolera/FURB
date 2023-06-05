/*
Elabore um algoritmo para exibir o valor de reajuste que um funcionário
receberá no seu salário. A empresa irá conceder 5% de reajuste para o
funcionário que for admitido há menos de 12 meses. Para funcionário admitido
entre 13 e 48 meses, irá conceder 7% de reajuste. O seu algoritmo deve
solicitar ao usuário que digite a quantidade de meses que o funcionário foi admitido.
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Uni4Exe15 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        DecimalFormat df_2 = new DecimalFormat("0.00");

        System.out.println("Informe há quantos meses o funcionário foi admitido:");
        int meses = teclado.nextInt();
        System.out.println("Informe o salário do funcionário:");
        double salario = teclado.nextDouble();
        double reajuste = 0;
        
        if (meses < 49) {
            if (meses < 13) {
                System.out.println("Reajuste de 5%");
                reajuste = salario * 0.05;
            } else {
                System.out.println("Reajuste de 7%");
                reajuste = salario * 0.07;
            }
            salario = salario + reajuste;
            System.out.println("Valor do reajuste = R$" + df_2.format(reajuste));
            System.out.println("Valor do novo salário = R$" + df_2.format(salario));
        } else {
            System.out.println("Sem reajuste.");
        }

        teclado.close();
    }
}
