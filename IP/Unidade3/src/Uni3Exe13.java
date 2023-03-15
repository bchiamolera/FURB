import java.util.Scanner;

public class Uni3Exe13 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira o valor da largura da parede (m):");
        Double largura = teclado.nextDouble();
        System.out.println("Insira o valor do comprimento da parede (m):");
        Double comprimento = teclado.nextDouble();
        Double area = largura * comprimento;
        Double quantAzulejos = area * 9;
        Double valorTotal = quantAzulejos * 12.5;
        System.out.println("Valor total: R$" + valorTotal);

        teclado.close();
    }
}
