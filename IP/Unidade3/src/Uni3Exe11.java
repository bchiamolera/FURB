/*
Descreva um programa que dado uma temperatura em °C informe o seu valor em °F. Fórmula:
°F = (9/5) °C + 32
 */

import java.util.Scanner;

public class Uni3Exe11 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira a temperatura (°C):");
        Double tempCelsius = teclado.nextDouble();
        Double tempFahrenheit = (9.0 * tempCelsius) / 5.0  + 32.0;
        System.out.println("A temperatura é:" + tempFahrenheit + "°F.");

        teclado.close();
    }
}
