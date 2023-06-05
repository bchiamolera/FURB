/*
Descreva um programa que dado uma temperatura em °C informe o seu valor em °F. Fórmula:
°F = (9/5) °C + 32
 */

import java.util.Scanner;

public class Uni3Exe11 {
    public static void main(String[] args) throws Exception {
        new Uni3Exe11();
    }

    public Uni3Exe11() {
        Scanner teclado = new Scanner(System.in);
        Calcular(Ler(teclado));
        teclado.close();
    }

    private double Ler(Scanner teclado) {
        System.out.println("Insira a temperatura (°C):");
         double tempCelsius = teclado.nextDouble();
        return tempCelsius;
    }

    private void Calcular(double tempCelsius) {
        Double tempFahrenheit = (9.0 * tempCelsius) / 5.0  + 32.0;
        System.out.println("A temperatura é:" + tempFahrenheit + "°F.");
    }
}
