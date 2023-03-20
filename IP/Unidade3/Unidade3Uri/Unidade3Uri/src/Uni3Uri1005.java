import java.util.Scanner;
import java.text.DecimalFormat;

public class Uni3Uri1005 {
    public static void main(String[] args) throws Exception {
        DecimalFormat df_5 = new DecimalFormat("0.00000");
        Scanner teclado = new Scanner(System.in);

        double A = teclado.nextDouble();
        double B = teclado.nextDouble();

        double MEDIA = (A * 3.5 + B * 7.5) / 11.0;
        teclado.close();
        
        System.out.println("MEDIA = " + df_5.format(MEDIA));
    }
}
