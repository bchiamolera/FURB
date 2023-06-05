/*
Dado uma letra, escreva um algoritmo que informe se ela é ou não uma vogal.
 */

import java.util.Scanner;

public class Uni4Exe08 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe a letra: ");
        char letra = teclado.nextLine().charAt(0);

        if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
            System.out.println("É vogal.");
        } else {
            System.out.println("Não é vogal.");
        }

        teclado.close();
    }
}
