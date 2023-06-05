/*
Faça um algoritmo que leia um caractere. Caso seja digitada a letra
'M' escreva “Masculino”. Se for digitada a letra 'F' escreva “Feminino”.
Se for informado 'I' escreva “Não Informado”. Qualquer outra letra
digitada escreva “Entrada Incorreta”. Atenção: antes de testar a letra,
converta-a para maiúscula.
 */

import java.util.Scanner;

public class Uni4Exe06 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Qual seu gênero? (M = masculino; F = feminino; I = não informado)");
        char genero = teclado.nextLine().toUpperCase().charAt(0);

        if (genero == 'M') {
            System.out.println("Masculino");
        } else if (genero == 'F') {
            System.out.println("Feminino");
        } else if (genero == 'I') {
            System.out.println("Não informado");
        } else {
            System.out.println("Entrada incorreta");
        }

        teclado.close();
    }
}
