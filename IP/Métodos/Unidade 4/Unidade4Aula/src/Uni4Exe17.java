/*
Para realizar o cálculo do Imposto de Renda a ser pago, é
solicitado a renda anual e o número de dependentes do contribuinte.
A renda líquida é calculada sobre a renda anual com um desconto de
2% para cada dependente do contribuinte. O contribuinte com uma renda
líquida de até R$ 2.000,00 não paga imposto. Para aqueles que possuem
renda líquida entre R$ 2.000,00 e R$ 5.000,00 o imposto é de 5% sobre
o valor da renda líquida; para rendas líquidas de R$ 5.000,00 até
R$ 10.000,00 é de 10%. Rendas superiores a R$ 10.000,00 pagam 15% de imposto.
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Uni4Exe17 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        DecimalFormat df_02 = new DecimalFormat("0.00");

        System.out.println("Informe a sua renda anual: ");
        Double rendaAnual = teclado.nextDouble();
        System.out.println("Informe o seu número de dependentes: ");
        int numeroDependentes = teclado.nextInt();
        Double desconto = rendaAnual * (2.0 / 100.0) * numeroDependentes;
        Double rendaLiquida = rendaAnual - desconto;
        Double impostoDeRenda = 0.0;

        if (rendaLiquida > 10000) {
            impostoDeRenda = rendaLiquida * (15.0 / 100.0);
            System.out.println("Imposto de renda: R$" + df_02.format(impostoDeRenda));
        } else if (rendaLiquida <= 10000 && rendaLiquida > 5000) {
            impostoDeRenda = rendaLiquida * (10.0 / 100.0);
            System.out.println("Imposto de renda: R$" + df_02.format(impostoDeRenda));
        } else if (rendaLiquida <= 5000 && rendaLiquida > 2000) {
            impostoDeRenda = rendaLiquida * (5.0 / 100.0);
            System.out.println("Imposto de renda: R$" + df_02.format(impostoDeRenda));
        } else if (rendaLiquida <= 2000) {
            System.out.println("Não paga imposto.");
        }
 
        teclado.close();
    }
}
