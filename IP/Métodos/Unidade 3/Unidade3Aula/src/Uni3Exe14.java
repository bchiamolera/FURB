/*
Descreva um programa que a partir da distância percorrida e o
do tempo gasto por um motorista durante uma viagem de final de
semana, calcule a velocidade média e a quantidade de combustível
gasto na viagem, sabendo que o automóvel faz 12 km por litro.
 */

import java.util.Scanner;

public class Uni3Exe14 {
    public static void main(String[] args) throws Exception {
        new Uni3Exe14();
    }

    public Uni3Exe14() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira a distância percorrida (km):");
        Double distancia = teclado.nextDouble();
        System.out.println("Insira o tempo do trajeto (h)):");
        Double tempo = teclado.nextDouble();
        Calcular(distancia, tempo);

        teclado.close();
    }

    private void Calcular(double distancia, double tempo) {
        Double velocidadeMedia = distancia * tempo;
        Double combustivelGasto = distancia / 12.0;
        System.out.println("A velocidade média da viagem foi de " + velocidadeMedia + " km/h.");
        System.out.println("A quantidade de combustível gasto foi de " + combustivelGasto + " L.");
    }
}
