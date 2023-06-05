/*
Faça um programa para ler três notas de um aluno em uma disciplina
e imprimira sua média ponderada (as notas tem pesos respectivos de 5, 3 e 2).
 */

import java.util.Scanner;

public class Uni3Exe04 {
    public static void main(String[] args) throws Exception {
        new Uni3Exe04();
    }

    public Uni3Exe04() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira a primeira nota (peso 5):");
        Double notaUm = teclado.nextDouble();
        System.out.println("Insira a segunda nota (peso 3):");
        Double notaDois = teclado.nextDouble();
        System.out.println("Insira a terceira nota (peso 2):");
        Double notaTres = teclado.nextDouble();
        Calcular(notaUm, notaDois, notaTres);
        
        teclado.close();
    }

    private void Calcular(double notaUm, double notaDois, double notaTres) {
        Double media = 0.5 * notaUm + 0.3 * notaDois + 0.2 * notaTres;
        System.out.println("Média final: " + media);
    }
}
