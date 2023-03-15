import java.util.Scanner;

public class Uni3Exe14 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Insira a distância percorrida (km):");
        Double distancia = teclado.nextDouble();
        System.out.println("Insira o tempo do trajeto (h)):");
        Double tempo = teclado.nextDouble();
        Double velocidadeMedia = distancia * tempo;
        Double combustivelGasto = distancia / 12.0;
        System.out.println("A velocidade média da viagem foi de " + velocidadeMedia + " km/h.");
        System.out.println("A quantidade de combustível gasto foi de " + combustivelGasto + " L.");
        teclado.close();
    }
}
