/*
Uma pessoa foi até uma casa de câmbio trocar dólares por reais.
Para isto ela entregou um valor em dólares para o atendente.
Considerando que o atendente tem a cotação do dólar, descreva um
programa para calcular quantos reais o atendente deve devolver para a pessoa.
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Uni3Exe08 {
    public static void main(String[] args) throws Exception {
        new Uni3Exe08();
    }

    public Uni3Exe08() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Cotação do dia: U$1.00 -> R$5.00");
        Double cotacaoReal = 5.0;
        System.out.println("Insira o valor que deseja trocar (U$):");
        Double valorDolar = teclado.nextDouble();
        Calcular(valorDolar, cotacaoReal);

        teclado.close();
    }

    private void Calcular(double valorDolar, double cotacaoReal) {
        DecimalFormat df_02 = new DecimalFormat("0.00");
        Double valorReal = valorDolar * cotacaoReal;
        System.out.println("Valor recebido: R$" + df_02.format(valorReal));
    }
}
