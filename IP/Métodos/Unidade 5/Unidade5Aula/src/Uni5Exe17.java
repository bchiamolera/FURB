/*
 Descreva um algoritmo que leia o número de inscrição e a altura de um atleta em uma
 competição e informe:
 - o número de inscrição e a altura do atleta mais alto;
 - o número de inscrição e a altura do atleta mais baixo;
 - a altura média do grupo de atletas.
 A leitura deve ser finalizada ao digitar 0 para o número de inscrição.
*/

import java.util.Scanner;

public class Uni5Exe17 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double alturaMaisBaixa = 100,  alturaMaisAlta = 0, alturaTotal = 0;
        int numInscricaoMaisAlto = 0, numInscricaoMaisBaixo = 0, numInscricao = 1, contador = 0;
        while(numInscricao != 0) {
            System.out.println("Informe o número de inscrição do atleta: ");
            numInscricao = teclado.nextInt();
            System.out.println("Informe a altura do atleta: ");
            double altura = teclado.nextDouble();
            contador++;
            alturaTotal += altura;
            if (altura > alturaMaisAlta) {
                alturaMaisAlta = altura;
                numInscricaoMaisAlto = numInscricao;
            }
            if (altura < alturaMaisBaixa) {
                alturaMaisBaixa = altura;
                numInscricaoMaisBaixo = numInscricao;
            }
        }
        System.out.println("Atleta mais alto = " + numInscricaoMaisAlto + ", " + alturaMaisAlta + "m.");
        System.out.println("Atleta mais baixo = " + numInscricaoMaisBaixo + ", " + alturaMaisBaixa + "m.");
        System.out.println("Altura média = " + (alturaTotal / contador));
        teclado.close();
    }
}
