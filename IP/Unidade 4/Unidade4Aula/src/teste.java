import java.util.Scanner;

public class teste {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Escolha o horário de chegada (Ex.: 12 50): ");
        String horaChegada = teclado.nextLine();
        System.out.println("Escolha o horário de saída: (Ex: 20 10)");
        String horaSaida = teclado.nextLine();

        String conv1[] = horaChegada.split(" ");
        String conv2[] = horaSaida.split(" ");

        int horasEmMinChegada = Integer.parseInt(conv1[0]) * 60;
        int minutosChegada = Integer.parseInt(conv1[1]);
        int totalChegada = horasEmMinChegada + minutosChegada;
        System.out.println(totalChegada);

        int horasEmMinSaida = Integer.parseInt(conv2[0]) * 60;
        int minutosSaida = Integer.parseInt(conv2[1]);
        int totalSaida = horasEmMinSaida + minutosSaida;
        System.out.println(totalSaida);

        teclado.close();
    }
}
