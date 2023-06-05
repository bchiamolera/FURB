/*
Uma loja de calçados está concedendo 12% de desconto nos produtos.
Escreva um programa para calcular e exibir o valor de desconto a ser
dado num par de sapatos e quanto deve custar o produto com o desconto.
O preço do par de sapatos deve ser informado pelo usuário. Como resultado,
o programa deverá exibir as seguintes mensagens:

O valor do desconto é de R$ xxx
O preço do par de sapatos com desconto é R$ xxx
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Uni3Exe02 {
    public static void main(String[] args) throws Exception {
        new Uni3Exe02();
    }

    public Uni3Exe02() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira o valor do produto:");
        Double preco = teclado.nextDouble();
        Desconto(preco);

        teclado.close();
    }

    private void Desconto(double preco) {
        DecimalFormat dc_02 = new DecimalFormat("0.00");
        Double valorDesconto = preco * 0.12;
        Double precoDesconto = preco - valorDesconto;
        System.out.println("O valor do desconto é de R$" + dc_02.format(valorDesconto));
        System.out.println("O preço do par de sapatos com desconto é R$" + dc_02.format(precoDesconto));
    }
}
