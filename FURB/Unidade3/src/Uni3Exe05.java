import java.util.Scanner;

public class Uni3Exe05 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira o número de frangos:");
        Double numFrangos = teclado.nextDouble();
        Double custoFrango = 4 * numFrangos + 7 * numFrangos;
        System.out.println("O custo total será de R$" + custoFrango);

        teclado.close();
    }
}
