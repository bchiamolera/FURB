/*
O índice de massa corporal (IMC) é uma medida internacional
usada para calcular se uma pessoa está no peso ideal. O IMC
é determinado pela divisão da massa do indivíduo pelo quadrado
de sua altura, onde a massa está em quilogramas e a altura
está em metros, de acordo com a fórmula:

IMC= Massa / Altura^2

Faça um algoritmo para classificar o IMC e dizer o grau de
obesidade do indivíduo, de acordo com a seguinte tabela:
..................................................
|     IMC       |          Classificação         |
|  < 18.5       |  Magreza                       |
|  18.5 - 24.9  |  Saudável                      |
|  25.0 - 29.9  |  Sobrepeso                     |
|  30.0 - 34.9  |  Obesidade Grau I              |
|  35.0 - 39.9  |  Obesidade Grau II (severa)    |
|  >= 40.0      |  Obesidade Grau III (mórbida)  |
..................................................
 */

import java.util.Scanner;

public class Uni4Exe21 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe a sua massa: ");
        Double massa = teclado.nextDouble();
        System.out.println("Informe a sua altura: ");
        Double altura = teclado.nextDouble();

        Double IMC = massa / (altura * altura);

        if (IMC < 18.5) {
            System.out.println("IMC = " + IMC);
            System.out.println("Magreza");
            ;
        } else if (IMC >= 18.5 && IMC < 25) {
            System.out.println("IMC = " + IMC);
            System.out.println("Saudável");
            ;
        } else if (IMC >= 25 && IMC < 30) {
            System.out.println("IMC = " + IMC);
            System.out.println("Sobrepeso");
            ;
        } else if (IMC >= 30 && IMC < 35) {
            System.out.println("IMC = " + IMC);
            System.out.println("Obesidade Grau I");
        } else if (IMC >= 35 && IMC < 40) {
            System.out.println("IMC = " + IMC);
            System.out.println("Obesidade Grau II (severa)");
        } else if (IMC >= 40) {
            System.out.println("IMC = " + IMC);
            System.out.println("Obesidade Grau III (mórbida)");
        }

        teclado.close();
    }
}
