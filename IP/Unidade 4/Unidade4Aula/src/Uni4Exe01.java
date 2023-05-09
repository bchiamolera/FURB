/*
A jornada de trabalho semanal de um funcionário é de 40 horas.
O funcionário que trabalhar mais de 40 horas receberá hora extra,
cujo cálculo é o valor da hora regular com um acréscimo de 50%.
Escreva um algoritmo que leia o número de horas trabalhadas em um
mês, o valor por hora e escreva o salário total do funcionário, que
deverá ser acrescido das horas extras, caso tenham sido trabalhadas
(considere que o mês possua 4 semanas exatas).
 */

import java.util.Scanner;

public class Uni4Exe01 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Entre com as horas trabalhadas no mês: ");
        double horasMes = teclado.nextDouble();

        System.out.println("Entre com o valor pago por hora: ");
        double horasValor = teclado.nextDouble();

        double salarioTotal = horasMes * horasValor;

        if (horasMes > 160) {
            double salarioExtra = (horasMes - 160) * (horasValor / 2);
            salarioTotal = salarioTotal + salarioExtra;
        }

        System.out.println("O salário total é: " + salarioTotal);

        teclado.close();
    }
}
