/*
 Foi feita uma pesquisa de audiência de canal de TV em n casas de um determinado bairro de uma cidade, em
 um certo dia do mês. Na pesquisa foi utilizado um coletor de dados portátil. Para cada casa visitada, foi
 fornecido o número do canal (4, 5, 9, 12) e o número de pessoas que estavam assistindo a TV naquele
 horário, considerando que em cada casa só existia uma televisão. Em casas onde a televisão estava desligada,
 foi registrado zero para o número do canal e para o número de pessoas. Baseado nisto descreva um algoritmo
 que calcule e escreva, para cada emissora, o percentual de audiência. A leitura deve ser finalizada quando
 for informado canal 0.
*/

import java.util.Scanner;

public class Uni5Exe18 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        int total4 = 0, total5 = 0, total9 = 0, total12 = 0, total = 0, pessoas = 0;
        int canal = 1;
        while (canal != 0) {
            System.out.println("Informe o número do canal (4, 5, 9 ou 12) (0 para finalizar): ");
            canal = teclado.nextInt();
            if (canal == 4 || canal == 5 || canal == 9 || canal == 12) {
                System.out.println("\nInforme o número de pessoas asssistindo a tv: ");
                pessoas = teclado.nextInt();
                System.out.println();
                switch (canal) {
                    case 4:
                        total4 += pessoas;
                        break;
                    case 5:
                        total5 += pessoas;
                        break;
                    case 9:
                        total9 += pessoas;
                        break;
                    case 12:
                        total12 += pessoas;
                        break;
                }
            } else {
                System.out.println("Canal inválido\n");
            }
        }
        total = total4 + total5 + total9 + total12;
        System.out.println("\nPorcentagem de audiência canal 4 = " + ((total4 / (double) total) * 100) + "%");
        System.out.println("Porcentagem de audiência canal 5 = " + ((total5 / (double) total) * 100) + "%");
        System.out.println("Porcentagem de audiência canal 9 = " + ((total9 / (double) total) * 100) + "%");
        System.out.println("Porcentagem de audiência canal 12 = " + ((total12 / (double) total) * 100) + "%");
        teclado.close();
    }
}
