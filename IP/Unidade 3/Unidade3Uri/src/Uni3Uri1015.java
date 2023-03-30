import java.util.Scanner;
import java.text.DecimalFormat;
import java.lang.Math;

public class Uni3Uri1015 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        DecimalFormat df_4 = new DecimalFormat("0.0000");

        String p1 = teclado.nextLine();
        String p2 = teclado.nextLine();
        String[] p1Separado = p1.split(" ");
        String[] p2Separado = p2.split(" ");
        Double xp1 = Double.parseDouble(p1Separado[0]);
        Double yp1 = Double.parseDouble(p1Separado[1]);
        Double xp2 = Double.parseDouble(p2Separado[0]);
        Double yp2 = Double.parseDouble(p2Separado[1]);

        Double distanciaPontos = Math.sqrt(Math.pow((xp2 - xp1), 2) + Math.pow((yp2 - yp1), 2));
        System.out.println(df_4.format(distanciaPontos));
        teclado.close();
    }
}