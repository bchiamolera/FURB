import java.util.Scanner;

public class Uni3Uri1004 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        int A = teclado.nextInt();
        int B = teclado.nextInt();

        int PROD = A * B;
        teclado.close();
        System.out.println("PROD = " + PROD);
    }
}
