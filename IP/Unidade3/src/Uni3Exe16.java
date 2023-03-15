import java.util.Scanner;

public class Uni3Exe16 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira um valor para troco:");
        int valorTroco = teclado.nextInt();
        int notasCem = 0;
        int notasDez = 0;
        int moedasUm = 0;
        int numeroNotas = 0;

        notasCem = valorTroco / 100.0;
        notasDez = (valorTroco - 100.0 * notasCem) / 10.0;
        moedasUm = valorTroco - 100.0 * notasCem - 10.0 * notasDez;
        numeroNotas = notasCem + notasDez + moedasUm;

        System.out.println("\n" + numeroNotas + " notas serão devolvidas.");
        System.out.println(notasCem + " nota(s) de R$100.");
        System.out.println(notasDez + " nota(s) de R$10.");
        System.out.println(moedasUm + " moeda(s) de R$1.");

        teclado.close();
    }
}
