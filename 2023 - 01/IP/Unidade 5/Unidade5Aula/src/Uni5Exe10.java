
/*
 O número 3025 possui a seguinte característica:
30 + 25 = 55; 55² = 3025
Escreva um programa que pesquise e imprima os 10 primeiros números naturais que apresentam
tal propriedade. Outros exemplos:
20 + 25 = 45; 45² = 2025
 */
import java.lang.Math;
public class Uni5Exe10 {
    public static void main(String[] args) {
        int num, div100, resto100, contador;
        num = 0;
        for (contador = 1; contador <= 10;) {
            div100 = num / 100;
            resto100 = num % 100;
            if (Math.pow((div100 + resto100), 2) == num) {
                System.out.println(num);
                contador++;
            }
            num++;
        }
    }
}