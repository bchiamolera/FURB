import java.util.Scanner;

public class Uni4Uri1041 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        Double X = teclado.nextDouble();
        Double Y = teclado.nextDouble();

        if (X == 0 && Y == 0) {
            System.out.println("Origem");
        } else if (X != 0 && Y == 0) {
            System.out.println("Eixo X");
        } else if (X == 0 && Y != 0) {
            System.out.println("Eixo Y");
        } else if (X > 0 && Y > 0) {
            System.out.println("Q1");
        } else if (X < 0 && Y > 0) {
            System.out.println("Q2");
        } else if (X < 0 && Y < 0) {
            System.out.println("Q3");
        } else if (X > 0 && Y < 0) {
            System.out.println("Q4");
        }

        teclado.close();
    }
}