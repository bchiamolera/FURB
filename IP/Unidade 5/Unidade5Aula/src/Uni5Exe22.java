/*
 Um funcionário recebe aumento anual. Em 1995 foi contratado por 2000 reais. Em 1996 recebeu aumento
 de 1.5%. A partir de 1997, os aumentos sempre correspondem ao dobro do ano anterior. Faça programa
 que determine o salário atual do funcionário.
*/

import java.text.DecimalFormat;

public class Uni5Exe22 {
    public static void main(String[] args) {
        DecimalFormat df_02 = new DecimalFormat("0.00");
        double salario = 2000;
        double aumento = 1.5 / 100;
        int tempo = 0;
        while (tempo < (2023 - 1995)) {
            tempo++;
            salario += salario * (aumento * tempo);
        }
        System.out.println("Salário atual = R$" + df_02.format(salario));
    }
}
