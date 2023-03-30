/*
Uma loja que trabalha com crediário funciona da seguinte maneira:
se o pagamento ocorre até o dia do vencimento, o cliente ganha 10%
de desconto e é avisado que o pagamento está em dia. Se o pagamento
é realizado até cinco dias após o vencimento o cliente perde o desconto,
e se o pagamento atrasa mais de cinco dias, é cobrada uma multa de 2%
por cada dia de atraso. Faça um algoritmo que leia o dia do vencimento,
o dia do pagamento e o valor da prestação e calcule o valor a ser pago
pelo cliente, exibindo as devidas mensagens. Suponha que todo vencimento
ocorre até o dia dez de cada mês e os clientes nunca deixam para pagar no
mês seguinte.
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Uni4Exe18 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        DecimalFormat df_02 = new DecimalFormat("0.00");

        System.out.println("Insira o dia do vencimento: ");
        int diaVencimento = teclado.nextInt();
        System.out.println("Insira o dia do pagamento: ");
        int diaPagamento = teclado.nextInt();
        System.out.println("Insira o valor da prestação: ");
        Double valorPrestacao = teclado.nextDouble();
        Double desconto = valorPrestacao * (10.0 / 100.0);
        int atraso = diaPagamento - diaVencimento;
        Double multa = valorPrestacao * atraso * (2.0 / 100.0);
        Double total = 0.0;

        if (atraso <= 0) {
            total = valorPrestacao - desconto;
            System.out.println("A prestação está em dia.");
            System.out.println("Valor da prestação = R$" + df_02.format(valorPrestacao));
            System.out.println("Valor do desconto = R$" + df_02.format(desconto));
            System.out.println("Valor total = R$" + df_02.format(total));
        } else if (atraso > 0 && atraso <= 5) {
            System.out.println("A prestação está " + atraso + " dias atrasada.");
            System.out.println("Valor da prestação = R$" + df_02.format(valorPrestacao));
        } else {
            total = valorPrestacao + multa;
            System.out.println("A prestação está " + atraso + " dias atrasada.");
            System.out.println("Valor da prestação = R$" + df_02.format(valorPrestacao));
            System.out.println("Valor da multa = R$" + df_02.format(multa));
            System.out.println("Valor total = R$" + df_02.format(total));
        }

        teclado.close();
    }
}
