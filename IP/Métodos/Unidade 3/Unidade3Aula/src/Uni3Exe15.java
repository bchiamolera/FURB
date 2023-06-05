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
        new Uni3Exe15();
    }

    public Uni3Exe15() {
        Scanner teclado = new Scanner(System.in);

        int numero = 0;
        Calcular(Ler(teclado, numero));

        teclado.close();
    }

    private int Ler(Scanner teclado, int numero) {
        System.out.println("Insira um número inteiro:");
        numero = teclado.nextInt();
        return numero;
    }
    private void Calcular(int numero) {
        int centena = numero / 100;
        int dezena = (numero - 100 * centena) / 10;
        int unidade = (numero - 100 * centena - 10 * dezena);
        System.out.println(centena + " centena(s), " + dezena + " dezena(s), " + unidade + " unidade(s).");
    }
}
