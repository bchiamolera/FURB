import java.util.Scanner;

public class Uni3Uri1018 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
       
        int N = teclado.nextInt();

        int notasCem = N / 100;
        int notasCinquenta = (N % 100) / 50;
        int notasVinte = ((N % 100) % 50) / 20;
        int notasDez = (((N % 100) % 50) % 20) / 10;
        int notasCinco = ((((N % 100) % 50) % 20) % 10) / 5;
        int notasDois = (((((N % 100) % 50) % 20) % 10) % 5) / 2;
        int notasUm = (((((N % 100) % 50) % 20) % 10) % 5) % 2;

        System.out.println(N);
        System.out.println(notasCem + " nota(s) de R$ 100,00");
        System.out.println(notasCinquenta + " nota(s) de R$ 50,00");
        System.out.println(notasVinte + " nota(s) de R$ 20,00");
        System.out.println(notasDez + " nota(s) de R$ 10,00");
        System.out.println(notasCinco + " nota(s) de R$ 5,00");
        System.out.println(notasDois + " nota(s) de R$ 2,00");
        System.out.println(notasUm + " nota(s) de R$ 1,00");

        teclado.close();
    }
}