import java.util.Scanner;

public class Uni3Exe07 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira a quantidade de latas (350ml):");
        Double quantLatas = teclado.nextDouble();
        System.out.println("Insira a quantidade de garrafas (600ml):");
        Double quantGarrafinhas = teclado.nextDouble();
        System.out.println("Insira a quantidade de garrafas(2L):");
        Double quantGarrafasDoisLitros = teclado.nextDouble();
        Double totalLitros = 0.35 * quantLatas + 0.6 * quantGarrafinhas + 2 * quantGarrafasDoisLitros;
        System.out.println("Total de litros: " + totalLitros + "L.");
        teclado.close();
    }
}
