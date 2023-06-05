/*
 Um hotel cobra R$ 50,00 de diária por hóspede e mais uma taxa de serviços. A taxa de serviços é de:
 - R$ 7,50 por diária, caso o número de diárias seja menor que 15;
 - R$ 6,50 por diária, caso o número de diárias seja igual a 15;
 - R$ 5,00 por diária, caso o número de diárias seja maior que 15.

 Descreva um algoritmo que apresente as seguintes opções ao recepcionista:
 (1) encerrar a conta de um hóspede;
 (2) verificar número de contas encerradas;
 (3) sair.

 Caso a opção escolhida seja a primeira, leia o nome e o número de diárias do hóspede e escreva o nome
 e total a ser pago. Caso a opção escolhida seja a segunda, informe o número de hóspedes que deixaram
 o hotel (número de contas encerradas). Caso a opção escolhida seja a terceira finalize a execução do
 algoritmo.
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Uni5Exe34 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        DecimalFormat df_02 = new DecimalFormat("0.00");
        int numDiarias = 0, totalContas = 0;
        int op = 1;
        int encerrar = 0;

        do {
            System.out.println("Informe o número de diárias do hóspede");
            numDiarias = teclado.nextInt();
            totalContas++;
            if (numDiarias < 15) {
                System.out.println("\nTotal: R$ " + df_02.format((double) numDiarias * 7.5));
            } else if (numDiarias == 15) {
                System.out.println("\nTotal: R$ " + df_02.format((double) numDiarias * 6.5));
            } else {
                System.out.println("\nTotal: R$ " + df_02.format((double) numDiarias * 5));
            }
            do {
                System.out.println(
                        "\n(1) encerrar a conta de um hóspede; \n(2) verificar número de contas encerradas; \n(3) sair.");
                op = teclado.nextInt();
                switch (op) {
                    case 1:
                        encerrar++;
                        break;
                    case 2:
                        System.out.println("\n" + totalContas + " contas encerradas");
                        break;
                    case 3:
                        encerrar++;
                        break;
                }
            } while (encerrar != 1);
            System.out.println();
            encerrar = 0;
        } while (op != 3);

        teclado.close();
    }
}
