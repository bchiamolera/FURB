import java.util.Scanner;

public class Uni3Exe15 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira um número inteiro:");
        int numero = teclado.nextInt();
        int centena = 0;
        int dezena = 0;
        int unidade = 0;

        centena = numero / 100.0;
        dezena = (numero - 100.0 * centena) / 10.0;
        unidade = (numero - 100.0 * centena - 10.0 * dezena);
        System.out.println(centena + " centena(s), " + dezena + " dezena(s), " + unidade + " unidade(s).");

        teclado.close();
    }
}
