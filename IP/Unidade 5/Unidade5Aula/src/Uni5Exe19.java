/*
 Uma loja de departamentos oferece para seus clientes um determinado desconto de acordo com o valor da
 compra efetuada. O desconto é de 20% caso o valor da compra seja maior que R$ 500,00 e de 15% caso seja
 menor ou igual. Descreva um algoritmo que leia o valor da compra e escreva o total a pagar a cada compra.
 Informe também o valor total recebido pela loja ao final do dia. A leitura deve ser finalizada com a
 leitura 0 para o valor da compra.
*/

import java.util.Scanner;
import java.text.DecimalFormat;

public class Uni5Exe19 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        DecimalFormat df_02 = new DecimalFormat("0.00");

        double compra = 1, totalDia = 0, totalPagar = 0;
        do {
            System.out.println("Informe o valor da compra (0 para finalizar):");
            compra = teclado.nextDouble();
            if (compra > 500) {
                totalPagar = compra * 0.8;
                totalDia += totalPagar;
                System.out.println("Valor da compra R$" + df_02.format(totalPagar));
            } else if (compra > 0 && compra <= 500) {
                totalPagar = compra * 0.85;
                totalDia += totalPagar;
                System.out.println("Valor da compra R$" + df_02.format(totalPagar));
            } else if (compra < 0) {
                System.out.println("Valor inválido.");
            }
            System.out.println();
        } while (compra != 0);
        System.out.println("Total do dia: R$" + df_02.format(totalDia));

        teclado.close();
    }
}
