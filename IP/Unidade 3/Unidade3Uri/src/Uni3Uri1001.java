import java.util.Scanner;

public class Uni3Uri1001 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        int A = teclado.nextInt();
        int B = teclado.nextInt();

        int X = A + B;
        teclado.close();
        System.out.println("X = " + X);
    }
}
