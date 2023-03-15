/*
Uma fábrica de refrigerantes vende seu produto em três formatos:
lata de 350 ml, garrafa de 600 ml e garrafa de 2 litros.
Se um comerciante compra uma determinada quantidade de cada formato,
faça um programa para calcular quantos litros de refrigerante ele comprou.
 */

import java.util.Scanner;

public class Uni3Exe07 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira a quantidade de latas (350ml):");
        Double quantLatas = teclado.nextDouble();
        System.out.println("Insira a quantidade de garrafas (600ml):");
        Double quantGarrafinhas = teclado.nextDouble();
        System.out.println("Insira a quantidade de garrafas(2L):");
        Double quantGarrafasDoisLitros = teclado.nextDouble();
        Double totalLitros = 0.35 * quantLatas + 0.6 * quantGarrafinhas + 2 * quantGarrafasDoisLitros;
        System.out.println("Total de litros: " + totalLitros + "L.");
        teclado.close();
    }
}
