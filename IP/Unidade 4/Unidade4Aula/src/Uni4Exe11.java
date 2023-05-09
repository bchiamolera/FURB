/*
Escreva um algoritmo para ler o ano de nascimento de 3 irmãos,
escrever uma mensagem que indique se eles são TRIGÊMEOS,
GÊMEOS, APENAS IRMÃOS. Considere que eles são GÊMEOS se dois
deles possuem a mesma idade e o outro diferente dos demais, e
apenas irmãos se todas as idades forem diferentes.
 */

import java.util.Scanner;

public class Uni4Exe11 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe o ano de nascimento do primeiro irmão: ");
        int anoPrimeiro = teclado.nextInt();
        System.out.println("Informe o ano de nascimento do segundo irmão: ");
        int anoSegundo = teclado.nextInt();
        System.out.println("Informe o ano de nascimento do terceiro irmão: ");
        int anoTerceiro = teclado.nextInt();

        if (anoPrimeiro == anoSegundo && anoPrimeiro == anoTerceiro) {
            System.out.println("São trigêmeos.");
        } else if (anoPrimeiro == anoSegundo || anoPrimeiro == anoTerceiro || anoSegundo == anoTerceiro) {
            System.out.println("Dois são gêmeos.");
        } else {
            System.out.println("São apenas irmãos.");
        }

        teclado.close();
    }
}
