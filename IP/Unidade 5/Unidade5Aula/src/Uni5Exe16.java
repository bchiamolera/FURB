/*
 Dado um determinado grupo de pessoas, descreva um algoritmo que a partir da
 altura e do sexo (sexo = 'M' ou sexo = 'm' para masculino e sexo = 'F' e
 sexo = 'f' para feminino) de cada pessoa informe a média da altura das mulheres 
 e a média de altura do grupo. A leitura deve ser finalizada ao digitar 0 para a altura.
 */

import java.util.Scanner;

public class Uni5Exe16 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double altura;
        char sexo;
        double mediaMulheres = 0, mediaGrupo = 0,
                somaAltMulheres = 0, somaAltGrupo = 0,
                contadorMulheres = 0, contadorGrupo = 0;
        System.out.println("Digite a altura (metros): ");
        altura = teclado.nextDouble();
        while (altura != 0) {
            System.out.println("Digite o gênero da pessoa (M = masculino, F = feminino): ");
            sexo = teclado.next().trim().toUpperCase().charAt(0);
            if (sexo == 'F') {
                somaAltMulheres += altura;
                contadorMulheres++;
            }
            somaAltGrupo += altura;
            contadorGrupo++;
            System.out.println("Digite a próxima altura (metros): ");
            altura = teclado.nextDouble();
        }
        mediaMulheres = somaAltMulheres / contadorMulheres;
        System.out.println("Média da altura das mulheres = " + mediaMulheres + " metros.");
        mediaGrupo = somaAltGrupo / contadorGrupo;
        System.out.println("Média da altura do grupo = " + mediaGrupo + " metros.");
        teclado.close();
    }
}
