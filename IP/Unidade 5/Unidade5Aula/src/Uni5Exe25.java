/*
 Em uma disputa de pingue-pongue os pontos são anotados como D, ponto para o jogador do lado direito, e E, 
 ponto para o jogador do lado esquerdo da mesa. Descreva um algoritmo que leia o código do ponto de cada 
 jogada e determine o vencedor. A partida encerra quando:

 - um dos jogadores chegar a 21 pontos e a diferença de pontos entre os jogadores for maior ou igual a dois;
 - o jogador com mais de 21 pontos conseguir uma diferença de dois pontos sobre o adversário, caso a 
 primeira condição não seja atendida.
 */
import java.util.Scanner;

public class Uni5Exe25 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int D = 0, E = 0;
        char op;
        while(D < 21 && E < 21) {
            System.out.println("Informe o ganhador da rodada (D ou E): ");
            op = teclado.nextLine().trim().toUpperCase().charAt(0);
            if (op == 'D') {
                D++;
            }
            else if (op == 'E') {
                E++;
            }
            else{
                System.out.println("Jogador inválido");
            }
            System.out.println("Placar = D: " + D + " x E: " + E +  "\n");
        }
        while (D - E < 2 && E - D < 2) {
            System.out.println("Informe o ganhador da rodada (D ou E): ");
            op = teclado.nextLine().trim().toUpperCase().charAt(0);
            if (op == 'D') {
                D++;
            }
            else if (op == 'E') {
                E++;
            }
            else {
                System.out.println("Jogador inválido");
            }
            System.out.println("Placar = D: " + D + " x E: " + E + "\n");
        }
        if (D > E) {
            System.out.println("Jogador D ganhou!");
        } else {
            System.out.println("Jogador E ganhou!");
        }
        teclado. close();   
    }
}
