import java.util.Scanner;

public class Uni3Exe02 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira o valor do produto:");
        Double precoCheio = teclado.nextDouble();
        Double valorDesconto = precoCheio * 0.12;
        Double precoDesconto = precoCheio - valorDesconto;
        System.out.println("O valor do desconto é de R$" + valorDesconto);
        System.out.println("O preço do par de sapatos com desconto é de R$" + precoDesconto);
        
        teclado.close();
    }
}
