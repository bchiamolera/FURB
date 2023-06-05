/*
O custo do selo de uma carta com até 50 gramas é de R$ 0,45.
As cartas com peso superior pagam um adicional de R$ 0,45 por
cada 20 gramas, ou fração, em que excedem aquele peso. Escreva
um algoritmo que dado o peso da carta, em gramas, determine o custo do selo.
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Uni4Exe07 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        DecimalFormat df_02 = new DecimalFormat("0.00");

        System.out.println("Entre com o peso da carta: ");
        Double pesoCarta = teclado.nextDouble();

        Double valorPagar = 0.0;

        if (pesoCarta <= 50) {
            valorPagar = 45.0 / 100.0;
        } else {
            Double pesoExcedido = pesoCarta - 50.0;
            int valorAdicional = ((int) (pesoExcedido / 20)) + 1;
            valorPagar = (45.0 / 100.0 + (45.0 / 100.0) * valorAdicional);
        }
        System.out.println("Custo do selo: R$" + df_02.format(valorPagar));

        teclado.close();
    }
}
