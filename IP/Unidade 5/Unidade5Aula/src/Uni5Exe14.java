/*
 Um comerciante deseja fazer um levantamento do lucro das 20 mercadorias que comercializa.
 Para cada mercadoria ele tem o nome, o preço de compra (PC) e o preço de venda (PV).
 Descreva um algoritmo que:
 - escreva quantas mercadorias proporcionam: (lucro < 10%), (10% <= lucro <= 20%) e (lucro > 20%),
 onde o percentual de lucro é calculado da seguinte forma: % = (PV - PC) / PC * 100;
 - determine e escreva o valor total de compra e de venda de todas as mercadorias, assim como o
 lucro total.
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Uni5Exe14 {
    public static void main(String[] args) {
        DecimalFormat df_02 = new DecimalFormat("0.00");
        Scanner teclado = new Scanner(System.in);
        int contador;
        String nomeProduto;
        double PC, PV;
        double porcentagem = 0;
        int lucro1 = 0, lucro2 = 0, lucro3 = 0;
        double totalCompra = 0;
        double totalVenda = 0;
        double totalLucro = 0;
        for (contador = 1; contador <= 20; contador++) {
            System.out.println("Digite o nome: ");
            nomeProduto = teclado.next();
            System.out.println("Digite o preço de compra: ");
            PC = teclado.nextDouble();
            System.out.println("Digite o preço de venda: ");
            PV = teclado.nextDouble();
            porcentagem = (PV - PC) / PC * 100;
            System.out.println(porcentagem);
            if (porcentagem < 10) {
                lucro1++;
            } else if (10 <= porcentagem && porcentagem <= 20) {
                lucro2++;
            } else {
                lucro3++;
            }
            totalLucro += (PV - PC);
            totalCompra += PC;
            totalVenda += PV;
        }
        System.out.println("Nº de produtos com lucro menor que 10%: " + lucro1);
        System.out.println("Nº de produtos com lucro entre 10% e 20%: " + lucro2);
        System.out.println("Nº de produtos com lucro maior que 20%: " + lucro3);
        System.out.println("Valor total de compra: " + df_02.format(totalCompra));
        System.out.println("Valor total de venda: " + df_02.format(totalVenda));
        System.out.println("Lucro total: " + df_02.format(totalLucro));
        teclado.close();
    }
}