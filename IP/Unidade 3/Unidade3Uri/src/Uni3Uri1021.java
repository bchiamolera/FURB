import java.util.Scanner;
import java.lang.Math;

public class Uni3Uri1021 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        float N;
        int nota100, nota50, nota20, nota10, nota5, nota2;
        int moeda1, moeda50, moeda25, moeda10, moeda05, moeda01;
        int restoNota;
        N = teclado.nextFloat();

        int notas = (int) N;

        nota100 = (int) (N / 100);
        restoNota = (int) (N % 100);
        nota50 = restoNota / 50;
        nota20 = (restoNota % 50) / 20;
        nota10 = ((restoNota % 50) % 20) / 10;
        nota5 = (((restoNota % 50) % 20) % 10) / 5;
        nota2 = ((((restoNota % 50) % 20) % 10) % 5) / 2;
        moeda1 = (((((restoNota % 50) % 20) % 10) % 5) % 2) / 1;

        float restoMoeda = (float) (N - (int)(notas));

        float moeda50Float, moeda25Float, moeda10Float, moeda05Float, moeda01Float;
        moeda50Float = (float) ((restoMoeda % 1) / 0.5);
        moeda50 = (int) moeda50Float;

        moeda25Float = (float) ((restoMoeda % 0.5) / 0.25);
        moeda25 = (int) moeda25Float;

        moeda10Float = (float) (((restoMoeda % 0.5) % 0.25) / 0.1);
        moeda10 = (int) moeda10Float;

        moeda05Float = (float) ((((restoMoeda % 0.5) % 0.25) % 0.1) / 0.05);
        moeda05 = (int) moeda05Float;

        moeda01Float = (float) (((((restoMoeda % 0.5) % 0.25) % 0.1) % 0.05) / 0.01);
        moeda01 = (int) Math.round(moeda01Float);

        System.out.println("NOTAS:");
        System.out.println(nota100 + " nota(s) de R$ 100.00");
        System.out.println(nota50 + " nota(s) de R$ 50.00");
        System.out.println(nota20 + " nota(s) de R$ 20.00");
        System.out.println(nota10 + " nota(s) de R$ 10.00");
        System.out.println(nota5 + " nota(s) de R$ 5.00");
        System.out.println(nota2 + " nota(s) de R$ 2.00");
        System.out.println("MOEDAS:");
        System.out.println(moeda1 + " moeda(s) de R$ 1.00");
        System.out.println((int)moeda50 + " moeda(s) de R$ 0.50");
        System.out.println((int)moeda25 + " moeda(s) de R$ 0.25");
        System.out.println((int)moeda10 + " moeda(s) de R$ 0.10");
        System.out.println((int)moeda05 + " moeda(s) de R$ 0.05");
        System.out.println((int)moeda01 + " moeda(s) de R$ 0.01");

        teclado.close();
    }
}