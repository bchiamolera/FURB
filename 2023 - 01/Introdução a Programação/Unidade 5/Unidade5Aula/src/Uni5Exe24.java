/*
 Os regulamentos de uma competição de pesca impõem um limite no peso total de pesca de um dia. Descreva um
 algoritmo que leia o limite diário (em quilogramas) e então leia o peso (em gramas) de cada peixe e escreva 
 o peso total da pesca obtido até aquele ponto. Quando o limite diário for excedido escreva uma mensagem e 
 encerre a execução do algoritmo. Para prosseguir com a entrada de dados de pesos de cada peixe o algoritmo 
 deve apresentar a seguinte mensagem: “deseja informar o peso de mais um peixe: s (SIM) / n (NÃO)?”.
 */

import java.util.Scanner;

public class Uni5Exe24 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double limiteDiário = 0, peso = 0, pesoTotal = 0;
        char op;
        System.out.println("Informe o limite diário (Kg): ");
        limiteDiário = teclado.nextDouble();
        while ((pesoTotal / 1000) <= limiteDiário) {
            System.out.println("\nInforme o peso do peixe (g): ");
            peso = teclado.nextDouble();
            pesoTotal += peso;
            if ((pesoTotal / 1000) <= limiteDiário) {
                System.out.println("\nDeseja informar o peso de mais um peixe: s (SIM) / n (NÃO)?");
                op = teclado.next().trim().toLowerCase().charAt(0);
                if (op == 'n' || (pesoTotal / 1000) >= limiteDiário) {
                    break;
                }
            } else {
                break;
            }
        }
        if ((pesoTotal / 1000) >= limiteDiário) {
            System.out.println("\nLimite diário alcançado.");
            System.out.println("Total: " + pesoTotal/1000 + "Kg");
        }
        teclado.close();
    }
}
