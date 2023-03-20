import java.util.Scanner;
import java.text.DecimalFormat;

public class Uni3Uri1009 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        DecimalFormat df_2 = new DecimalFormat("0.00");

        String name = teclado.next();
        Double fixedSalary = teclado.nextDouble();
        Double totalSelled = teclado.nextDouble();

        double totalSalary = fixedSalary + (totalSelled * 0.15);
        teclado.close();
        System.out.println("TOTAL = R$ " + df_2.format(totalSalary));
    }
}
