/*
Um restaurante cobra R$ 25,00 por cada quilo de refeição.
Escreva um programa que leia o peso do prato montado pelo cliente
(em quilos) e imprima o valor a pagar. O peso do prato é de 750 gramas.
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Uni3Exe06 {
    public static void main(String[] args) throws Exception {
        new Uni3Exe06();
    }

    public Uni3Exe06() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira o peso da refeição (kg):");
        Double pesoRefeicao = teclado.nextDouble();
        Calcular(pesoRefeicao);

        teclado.close();
    }

    private void Calcular(double peso) {
        DecimalFormat df_02 = new DecimalFormat("0.00");
        Double totalPagar = (peso - 0.75) * 25;
        System.out.print("O total a pagar será de R$" + df_02.format(totalPagar));
    }
}
