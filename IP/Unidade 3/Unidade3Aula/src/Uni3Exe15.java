/*
Construa um programa para ler um número inteiro (assuma até 3 dígitos)
e imprima a saída da seguinte forma:

X centena(s)  Y dezena(s) K unidade(s)

Exemplo, se for submetido o número 384, o programa deverá exibir:

3 centena(s)  8 dezena(s) 4 unidade(s)
 */

import java.util.Scanner;

public class Uni3Exe15 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira um número inteiro:");
        int numero = teclado.nextInt();
        int centena = 0;
        int dezena = 0;
        int unidade = 0;

        centena = numero / 100;
        dezena = (numero - 100 * centena) / 10;
        unidade = (numero - 100 * centena - 10 * dezena);
        System.out.println(centena + " centena(s), " + dezena + " dezena(s), " + unidade + " unidade(s).");

        teclado.close();
    }
}
