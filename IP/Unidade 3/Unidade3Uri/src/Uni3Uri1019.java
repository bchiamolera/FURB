import java.util.Scanner;

public class Uni3Uri1019 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
       
        int N = teclado.nextInt();
        int horas = N / 3600;
        int minutos = (N % 3600) / 60;
        int segundos = (N % 3600) % 60;

        System.out.println(horas + ":" + minutos + ":" + segundos);

        teclado.close();
    }
}