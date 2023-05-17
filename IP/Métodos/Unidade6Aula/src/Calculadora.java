import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) throws Exception {
        new Calculadora();
    }

    public Calculadora() {
        Scanner teclado = new Scanner(System.in);
        double num1 = 0, num2 = 0, total = 0;
        int op = 0, encerrar = 0;
        num1 = pedirNumero("1", teclado);
        num2 = pedirNumero("2", teclado);
        do {
            System.out.println("\nOperação a ser realizada: \n1. Soma \n2. Subtração \n3. Multiplicação \n4. Divisão");
            op = teclado.nextInt();
            switch (op) {
                case 1:
                    total = somar(num1, num2);
                    encerrar = 1;
                    break;
                case 2:
                    total = subtrair(num1, num2);
                    encerrar = 1;
                    break;
                case 3:
                    total = multiplicar(num1, num2);
                    encerrar = 1;
                    break;
                case 4:
                    total = dividir(num1, num2);
                    if (num2 == 0) {
                        System.out.println("\nErro!");
                    }
                    encerrar = 1;
                    break;
                default:
                    System.out.println("\nOpção inválida\n");
            }
        } while (encerrar == 0);
        if (total != Double.MIN_VALUE) {
            System.out.println("\nTotal = " + total);
        }
        teclado.close();
    }

    private double pedirNumero(String valor, Scanner teclado) {
        System.out.print("Digite o " + valor + "º número: ");
        return teclado.nextDouble();
    }

    private double somar(double num1, double num2) {
        double resultado = num1 + num2;
        return resultado;
    }

    private double subtrair(double num1, double num2) {
        double resultado = num1 - num2;
        return resultado;
    }

    private double multiplicar(double num1, double num2) {
        double resultado = num1 * num2;
        return resultado;
    }

    private double dividir(double num1, double num2) {
        if (num2 != 0) {
            double resultado = num1 / num2;
            return resultado;
        } else {
            return Double.MIN_VALUE;
        }
    }
}