/*
Uma fábrica de refrigerantes vende seu produto em três formatos:
lata de 350 ml, garrafa de 600 ml e garrafa de 2 litros.
Se um comerciante compra uma determinada quantidade de cada formato,
faça um programa para calcular quantos litros de refrigerante ele comprou.
 */

import java.util.Scanner;

public class Uni3Exe07 {
    public static void main(String[] args) throws Exception {
        new Uni3Exe07();
    }

    public Uni3Exe07() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira a quantidade de latas (350ml):");
        int latas = teclado.nextInt();
        System.out.println("Insira a quantidade de garrafas (600ml):");
        int garrafinhas = teclado.nextInt();
        System.out.println("Insira a quantidade de garrafas(2L):");
        int garrafasDoisLitros = teclado.nextInt();
        Calcular(latas, garrafinhas, garrafasDoisLitros);

        teclado.close();
    }

    private void Calcular(int quantLatas, int quantGarrafinhas, int quantGarrafasDoisLitros) {
        Double totalLitros = 0.35 * quantLatas + 0.6 * quantGarrafinhas + 2 * quantGarrafasDoisLitros;
        System.out.println("Total de litros: " + totalLitros + "L.");
    }
}
