import java.util.Scanner;

public class Uni3Uri1016 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
       
        int distanciaInput = teclado.nextInt();
        int tempo = distanciaInput * 2;

        System.out.println(tempo + " minutos");

        teclado.close();
    }
}