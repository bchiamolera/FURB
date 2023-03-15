import java.util.Scanner;

public class Uni3Exe06 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira o peso da refeição (kg):");
        Double pesoRefeicao = teclado.nextDouble();
        Double totalPagar = (pesoRefeicao - 0.75) * 25;
        System.out.print("O total a pagar será de R$" + totalPagar);

        teclado.close();
    }
}
