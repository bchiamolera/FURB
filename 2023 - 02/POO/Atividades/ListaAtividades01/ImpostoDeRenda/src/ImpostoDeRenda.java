import java.util.Scanner;
import java.text.DecimalFormat;

public class ImpostoDeRenda {
    public static void main(String[] args) throws Exception {
        DecimalFormat dfMoney = new DecimalFormat("####,##0.00");
        Scanner s = new Scanner(System.in);

        try {
            System.out.println("Questao 1:");
            System.out.print("Nome: ");
            String nomeFunc = s.nextLine();
            System.out.print("Salário: R$");
            Double salarioFunc = Double.parseDouble(s.nextLine());
            Funcionario func1 = new Funcionario(nomeFunc, salarioFunc);

            System.out.println("O imposto pago pelo funcionário " + func1.getNome()
                    + " é de R$" + dfMoney.format(func1.calcularIrpf()));

            System.out.println("\nQuestao 2:");
            Funcionario[] funcionarios = new Funcionario[5];
            for (int i = 0; i < funcionarios.length; i++) {
                System.out.println("Funcionario " + (i + 1) + ": ");
                System.out.print("Nome: ");
                String nomeFunc2 = s.nextLine();
                System.out.print("Salário: R$");
                Double salarioFunc2 = Double.parseDouble(s.nextLine());
                funcionarios[i] = new Funcionario(nomeFunc2, salarioFunc2);
                System.out.println();
            }
            for (Funcionario funcionario : funcionarios) {
                System.out.println("O imposto pago pelo funcionário " + funcionario.getNome()
                        + " é de R$" + dfMoney.format(funcionario.calcularIrpf()));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        s.close();
    }
}