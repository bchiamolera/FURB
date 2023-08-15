/*
 Em uma eleição para presidência, existem 4 candidatos. Os votos são informados através de código.
 Os dados utilizados para votação obedecem a seguinte codificação:
 - 1, 2, 3, 4 = voto para o respectivo candidato;
 - 5 = voto nulo;
 - 6 = voto em branco.

 Elabore um programa que calcule e escreva:
 - total de votos para cada candidato;
 - total de votos nulos;
 - total de votos em branco;
 - percentual dos votos em branco e nulos sobre o total.

 Se o usuário informar um número de operação incorreto, emitir a mensagem “Opção incorreta” e persistir
 solicitando um número de opção correto. Para interromper a operação, o usuário poderá fornecer o número 0.
*/

import java.util.Scanner;

public class Uni5Exe33 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int voto = 0;
        int cand1 = 0, cand2 = 0, cand3 = 0, cand4 = 0, branco = 0, nulo = 0, total = 0;
        do {
            System.out.println(
                    "\nEleição: \n1 - Candidato 1 \n2 - Candidato 2 \n3 - Candidato 3 \n4 - Candidato 4 \n5 - Nulo \n6 - Branco \n0 - Encerrar");
            voto = teclado.nextInt();
            switch (voto) {
                case 1:
                    cand1++;
                    total++;
                    System.out.println("\nVoto computado\n");
                    break;
                case 2:
                    cand2++;
                    total++;
                    System.out.println("\nVoto computado\n");
                    break;
                case 3:
                    cand3++;
                    total++;
                    System.out.println("\nVoto computado\n");
                    break;
                case 4:
                    cand4++;
                    total++;
                    System.out.println("\nVoto computado\n");
                    break;
                case 5:
                    nulo++;
                    total++;
                    System.out.println("\nVoto computado\n");
                    break;
                case 6:
                    branco++;
                    total++;
                    System.out.println("\nVoto computado\n");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nOpção incorreta\n");
            }
        } while (voto != 0);
        System.out.println("\nCandidato 1: " + cand1 + " voto(s)");
        System.out.println("Candidato 2: " + cand2 + " voto(s)");
        System.out.println("Candidato 3: " + cand3 + " voto(s)");
        System.out.println("Candidato 4: " + cand4 + " voto(s)");
        System.out.println("Nulo: " + nulo + " voto(s)");
        System.out.println("Branco: " + branco + " voto(s)");
        System.out.println("Porcentual de votos nulos e brancos: " + ((nulo + branco) / (double) total) * 100 + "%");

        teclado.close();
    }
}
