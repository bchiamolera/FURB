/*
Uma granja possui um controle automatizado de cada frango da sua produção.
No pé direito do frango há um anel com um chip de identificação; no pé esquerdo
são dois anéis para indicar o tipo de alimento que ele deve consumir. Sabendo
que o anel com chip custa R$ 4,00 e o anel de alimento custa R$ 3,50, faça um
programa para calcular o gasto total da granja para marcar todos os seus frangos.
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Uni3Exe05 {
    public static void main(String[] args) throws Exception {
        new Uni3Exe05();
    }

    public Uni3Exe05() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira o número de frangos:");
        int numFrangos = teclado.nextInt();
        Calcular(numFrangos);

        teclado.close();
    }

    private void Calcular(int numFrangos) {
        DecimalFormat df_02 = new DecimalFormat("0.00");
        Double custoFrango = numFrangos * 11.0;
        System.out.println("O custo total será de R$" + df_02.format(custoFrango));
    }
}
