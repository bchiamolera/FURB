/*
 Uma emissora de rádio decidiu promover uma eleição para determinar o melhor conjunto do ano segundo a
 opinião dos ouvintes. Entraram na disputa apenas os quatro conjuntos mais solicitados durante o ano. Os
 votos são informados através de códigos:

 código	|   conjunto
   1	| Nenhum de Nós
   2	|    CPM22
   3	|    Skank
   4	|  Jota Quest

 Descreva um algoritmo que:
 - informe o total de votos para cada grupo;
 - informe o percentual dos votos para cada grupo;
 - informe o grupo vencedor.

 O algoritmo deve apresentar ao usuário a seguinte mensagem: mais um voto: s (SIM) / n (NÃO)? antes de
 prosseguir com a entrada de dados.
 */

import java.util.Scanner;

public class Uni5Exe28 {
    public static void main(String[] args) {
        new Uni5Exe28();
    }
    
    public Uni5Exe28() {
        Scanner teclado = new Scanner(System.in);
        int totalVotos = 0, total1 = 0, total2 = 0, total3 = 0, total4 = 0;
        int voto;
        do {
            Escrever();
            voto = teclado.nextInt();
            switch (voto) {
                case 1:
                    total1++;
                    totalVotos++;
                    break;
                case 2:
                    total2++;
                    totalVotos++;
                    break;
                case 3:
                    total3++;
                    totalVotos++;
                    break;
                case 4:
                    total4++;
                    totalVotos++;
                    break;
                default:
                    System.out.println("CÓDIGO INVÁLIDO.");
            }
        } while (Finalizar(teclado));
        CalcularResult(total1, total2, total3, total4, totalVotos);
        
        teclado.close();
    }

    private void Escrever() {
        System.out.println("VOTAÇÃO:: MELHOR BANDA DO ANO");
        System.out.println("1 - Nenhum de Nós");
        System.out.println("2 - CPM22");
        System.out.println("3 - Skank");
        System.out.println("4 - Jota Quest");
    }
    
    private boolean Finalizar(Scanner teclado) {
        boolean temp = false;
        char op;
        do {
            System.out.println("\nDeseja adicionar mais um voto? s (Sim) / n (Não)");
            op = teclado.next().trim().toLowerCase().charAt(0);
            if (op == 's' || op == 'n') {
                temp = true;
            }
        } while (!temp);
        System.out.println();
        if (op == 'n') {
            return false;
        } else {
            return true;
        }
    }

    private void CalcularResult(int total1, int total2, int total3, int total4, int totalVotos) {
        System.out.println("Total de votos: ");
        System.out.println("Nenhum de nós: " + total1 + "; " + (total1 / (double) totalVotos) * 100 + "%");
        System.out.println("CPM22: " + total2 + "; " + (total2 / (double) totalVotos) * 100 + "%");
        System.out.println("Skank: " + total3 + "; " + (total3 / (double) totalVotos) * 100 + "%");
        System.out.println("Jota Quest: " + total4 + "; " + (total4 / (double) totalVotos) * 100 + "%");
    }
}
