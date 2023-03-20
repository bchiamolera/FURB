import java.util.Scanner;

public class Uni3Uri1007 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        int A = teclado.nextInt();
        int B = teclado.nextInt();
        int C = teclado.nextInt();
        int D = teclado.nextInt();

        int DIFERENCA = (A * B - C * D);
        teclado.close();
        System.out.println("DIFERENCA = " + DIFERENCA);
    }
}
