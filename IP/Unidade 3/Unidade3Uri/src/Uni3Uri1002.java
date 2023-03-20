import java.util.Scanner;
import java.text.DecimalFormat;

public class Uni3Uri1002 {
    public static void main(String[] args) throws Exception {

        DecimalFormat df_4 = new DecimalFormat("0.0000");

        Scanner teclado = new Scanner(System.in);
        double pi = 3.14159;
        double R = teclado.nextDouble();

        double A = pi * R * R;
        teclado.close();
        System.out.println("A=" + df_4.format(A));
    }
}
