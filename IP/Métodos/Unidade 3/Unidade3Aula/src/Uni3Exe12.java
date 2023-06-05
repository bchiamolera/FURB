/*
Uma empresa tem para um funcionário os seguintes dados: o nome,
o número de horas trabalhadas mensais e o número de dependentes.
A empresa paga R$ 10,00 por hora (valor para cálculo do salário
trabalho) e R$ 60,00 por dependente (valor para cálculo do salário
família) e são feitos descontos de 8,5% sobre o salário trabalho
para o INSS e de 5% sobre o salário trabalho para o imposto de renda.
Descreva um programa que informe o nome, o salário bruto e o salário
líquido do funcionário.
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Uni3Exe12 {
    public static void main(String[] args) throws Exception {
        new Uni3Exe12();
    }

    public Uni3Exe12() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira o nome do funcionário:");
        String nomeFuncionário = teclado.nextLine();
        System.out.println("Insira a carga horária mensal:");
        Double numHoras = teclado.nextDouble();
        System.out.println("Insira o número de dependentes:");
        Double numDependentes = teclado.nextDouble();
        Calcular(nomeFuncionário, numHoras, numDependentes);

        teclado.close();
    }

    private void Calcular(String nome, double horas, double dependentes) {
        DecimalFormat df_02 =  new DecimalFormat("0.00");
        Double salarioTrabalho = 10 * horas;
        Double salarioFamilia = 60 * dependentes;
        Double salarioBruto = salarioTrabalho + salarioFamilia;
        Double salarioLiquido = salarioBruto - salarioTrabalho * 0.085 - salarioTrabalho * 0.05;
        System.out.println("\nNome do funcionário: " + nome +
        "\nSalário bruto: R$" + df_02.format(salarioBruto) + "\nSalário líquido: R$" +
        df_02.format(salarioLiquido));
    }
}
