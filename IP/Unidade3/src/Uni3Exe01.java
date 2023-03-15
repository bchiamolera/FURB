/* Uma imobiliária vende apenas terrenos retangulares.
 * Faça um programa para ler as dimensões de um terreno
 * e depois exibir a área do terreno.
 */

import java.util.Scanner;

public class Uni3Exe01 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira o valor da largura (km):");
        Double largura = teclado.nextDouble();
        System.out.println("Insira o valor do comprimento (km):");
        Double comprimento = teclado.nextDouble();
        System.out.println("A área do terreno é de:");
        Double area = largura*comprimento;
        System.out.println(area + "km³");
        System.out.println("\nFim do processo.");

        teclado.close();
    }
}
