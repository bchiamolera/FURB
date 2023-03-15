/*
Um motorista deseja abastecer seu tanque de combustível. Escreva um programa
para ler o preço do litro da gasolina e o valor do pagamento e exibir quantos
litros ele conseguiu colocar no tanque.
 */

import java.util.Scanner;

public class Uni3Exe03 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira o preço do litro da gasolina:");
        Double precoGasolina = teclado.nextDouble();
        System.out.println("Insira o valor do pagamento");
        Double valorPagamento = teclado.nextDouble();
        Double litrosColocados = valorPagamento / precoGasolina;
        System.out.println("Você encheu " + litrosColocados + " litros.");

        teclado.close();
    }
}
