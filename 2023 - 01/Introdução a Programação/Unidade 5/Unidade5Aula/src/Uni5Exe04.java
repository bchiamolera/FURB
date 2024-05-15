/*
 Descreva um algoritmo para calcular o valor de S dado por:
 3/2 + 5/6 + 7/12 + 9/20 + 11/30 + ...
 Considere os 20 primeiros termos da série.
 */
public class Uni5Exe04 {
    public static void main(String[] args) {
        int contador;
        double num1, num2, somaPar, total;
        num1 = 3.0;
        num2 = 2.0;
        somaPar = 4.0;
        total = 0.0;

        for (contador = 1; contador <= 20; contador++) {
            total += (num1 / num2);
            num1 += 2;
            num2 += somaPar;
            somaPar += 2;
        }
        System.out.println(total);
    }
}
