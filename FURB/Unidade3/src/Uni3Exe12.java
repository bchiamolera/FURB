import java.util.Scanner;

public class Uni3Exe12 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira o nome do funcionário:");
        String nomeFuncionário = teclado.nextLine();
        System.out.println("Insira a carga horária:");
        Double numHoras = teclado.nextDouble();
        System.out.println("Insira o número de dependentes:");
        Double numDependentes = teclado.nextDouble();
        Double salarioTrabalho = 10 * numHoras;
        Double salarioFamilia = 60 * numDependentes;
        Double salarioBruto = salarioTrabalho + salarioFamilia;
        Double salarioLiquido = salarioBruto - salarioTrabalho * 0.085 - salarioTrabalho * 0.05;
        System.out.println("Nome do funcionário: " + nomeFuncionário +
        "\nSalário bruto: R$" + salarioBruto + "\nSalário líquido: R$" + salarioLiquido);

        teclado.close();
    }
}
