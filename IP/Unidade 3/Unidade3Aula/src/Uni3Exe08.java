/*
Uma pessoa foi até uma casa de câmbio trocar dólares por reais.
Para isto ela entregou um valor em dólares para o atendente.
Considerando que o atendente tem a cotação do dólar, descreva um
programa para calcular quantos reais o atendente deve devolver para a pessoa.
 */

import java.util.Scanner;

public class Uni3Exe08 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Cotação do dia: U$1.00 -> R$5.00");
        Double cotacaoReal = 5.0;
        System.out.println("Insira o valor que deseja trocar (U$):");
        Double valorDolar = teclado.nextDouble();
        Double valorReal = valorDolar * cotacaoReal;
        System.out.println("Valor recebido: R$" + valorReal);

        teclado.close();
    }
}
