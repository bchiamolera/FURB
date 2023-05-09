/*
 Uma grande loja de departamentos paga aos vendedores um salário com base nas vendas efetuadas
 durante o mês, que é igual a 30% de comissão sobre o preço de cada produto vendido. Cada vendedor,
 em um determinado mês, vende n produtos, onde, para cada produto tem-se o preço unitário e a
 quantidade vendida. O departamento de pessoal deseja obter um relatório com: nome, total de vendas
 (em R$) e salário de cada vendedor. Descreva um algoritmo que gere o relatório desejado. Para
 prosseguir com a entrada de dados o algoritmo deve apresentar a seguinte mensagem: “deseja digitar
 os dados de mais um vendedor: s (SIM) / n (NÃO)?”. O número de produtos (n) de cada vendedor deve ser
 informado.
*/

import java.util.Scanner;
import java.text.DecimalFormat;

public class Uni5Exe23 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        DecimalFormat df_02 = new DecimalFormat("0.00");
        int op = 0;
        while (op == 0) {
            char opTxt = 'a';
            String nome = "", salario = "";
            int quantidade = 0;
            double precoUni = 0.0;
            System.out.println("Informe o nome do vendedor:");
            nome = teclado.nextLine();
            System.out.println("\nInforme o preço unitário (R$):");
            precoUni = teclado.nextDouble();
            System.out.println("\nInforme a quantidade vendida:");
            quantidade = teclado.nextInt();
            salario = df_02.format((precoUni * quantidade * 0.3));
            System.out.println("\nNome: " + nome);
            System.out.println("Total de vendas: " + quantidade);
            System.out.println("Salário: R$" + salario);
            System.out.println("\nDeseja digitar os dados de mais um vendedor: s (SIM) / n (NÃO)?");
            opTxt = teclado.next().trim().toLowerCase().charAt(0);
            System.out.println();
            if (opTxt == 'n') {
                op++;
            }
        }
        teclado.close();
    }
}
