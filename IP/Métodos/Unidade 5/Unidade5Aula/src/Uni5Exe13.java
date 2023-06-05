/*
 Um motorista acaba de voltar de um feriado prolongado. Antes de sair de viagem e
 imediatamente após retornar, o motorista encheu o tanque do veículo e registrou as
 medidas do odômetro. Em cada parada feita durante a viagem, foi registrado o valor
 do odômetro e a quantidade de combustível comprado para reabastecer o veículo (suponha
 que o tanque foi enchido a cada parada). Descreva um algoritmo que leia o número total
 de reabastecimentos feitos e os dados registrados relativos à compra de combustível.
 Calcule e escreva:
 - a quilometragem obtida por litro de combustível em cada parada;
 - a quilometragem média obtida por litro de combustível em toda a viagem.
 */
import java.util.Scanner;
 public class Uni5Exe13 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int paradas, contador;
        double km, litros, kmTotal, litrosTotal;
        kmTotal = 0.0;
        litrosTotal = 0.0; 
        System.out.println("Digite o número de paradas: ");
        paradas = teclado.nextInt();
        for (contador = 1; contador <= paradas; contador++) {
            System.out.println("Digite a kilometragem feita: ");
            km = teclado.nextDouble();
            System.out.println("Digite a quantidade (L) de reabastecimento: ");
            litros = teclado.nextDouble();
            System.out.println("Quilometragem obtida na parada: " + (km / litros));
            kmTotal += km;
            litrosTotal += litros;
        }
        System.out.println("Quilometragem média por litro: " + (kmTotal / litrosTotal));
        teclado.close();
    }
}
