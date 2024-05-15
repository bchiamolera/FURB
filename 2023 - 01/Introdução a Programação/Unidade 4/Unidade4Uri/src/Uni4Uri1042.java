import java.util.Scanner;

public class Uni4Uri1042 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        int num1 = teclado.nextInt();
        int num2 = teclado.nextInt();
        int num3 = teclado.nextInt();

        if (num1 == num2 && num2 == num3) {
            System.out.println(num3);
            System.out.println(num2);
            System.out.println(num1);
            System.out.println();
            System.out.println(num1);
            System.out.println(num2);
            System.out.println(num3);
        } else if (num1 > num2 && num2 > num3) {
            System.out.println(num3);
            System.out.println(num2);
            System.out.println(num1);
            System.out.println();
            System.out.println(num1);
            System.out.println(num2);
            System.out.println(num3);
        } else if (num1 > num3 && num3 > num2) {
            System.out.println(num2);
            System.out.println(num3);
            System.out.println(num1);
            System.out.println();
            System.out.println(num1);
            System.out.println(num2);
            System.out.println(num3);
        } else if (num2 > num1 && num1 > num3) {
            System.out.println(num3);
            System.out.println(num1);
            System.out.println(num2);
            System.out.println();
            System.out.println(num1);
            System.out.println(num2);
            System.out.println(num3);
        } else if (num2 > num3 && num3 > num1) {
            System.out.println(num1);
            System.out.println(num3);
            System.out.println(num2);
            System.out.println();
            System.out.println(num1);
            System.out.println(num2);
            System.out.println(num3);
        } else if (num3 > num1 && num1 > num2) {
            System.out.println(num2);
            System.out.println(num1);
            System.out.println(num3);
            System.out.println();
            System.out.println(num1);
            System.out.println(num2);
            System.out.println(num3);
        } else if (num3 > num2 && num2 > num1) {
            System.out.println(num1);
            System.out.println(num2);
            System.out.println(num3);
            System.out.println();
            System.out.println(num1);
            System.out.println(num2);
            System.out.println(num3);
        }
        
        teclado.close();
    }
}
