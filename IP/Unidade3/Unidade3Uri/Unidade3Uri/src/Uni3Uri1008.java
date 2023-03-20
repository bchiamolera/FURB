import java.util.Scanner;
import java.text.DecimalFormat;

public class Uni3Uri1008 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        DecimalFormat df_2 = new DecimalFormat("0.00");

        int number = teclado.nextInt();
        int workedHours = teclado.nextInt();
        Double hourSalary = teclado.nextDouble();

        double totalSalary = workedHours * hourSalary;
        teclado.close();
        System.out.println("NUMBER = " + number);
        System.out.println("SALARY = U$ " + df_2.format(totalSalary));
    }
}