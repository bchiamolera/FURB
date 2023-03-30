import java.util.Scanner;
import java.text.DecimalFormat;

public class Uni3Uri1012 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        DecimalFormat df_3 = new DecimalFormat("0.000");

        String inputNumeros = teclado.nextLine();
        String[] numerosSeparados = inputNumeros.split(" ");

        Double a = Double.parseDouble(numerosSeparados[0]);
        Double b = Double.parseDouble(numerosSeparados[1]);
        Double c = Double.parseDouble(numerosSeparados[2]);

        Double areaTriangulo = (a * c) / 2;
        Double areaCirculo = 3.14159 * c * c;
        Double areaTrapezio = ((a + b) * c) / 2;
        Double areaQuadrado = b * b;
        Double areaRetangulo = a * b;

        System.out.println("TRIANGULO: " + df_3.format(areaTriangulo));
        System.out.println("CIRCULO: " + df_3.format(areaCirculo));
        System.out.println("TRAPEZIO: " + df_3.format(areaTrapezio));
        System.out.println("QUADRADO: " + df_3.format(areaQuadrado));
        System.out.println("RETANGULO: " + df_3.format(areaRetangulo));

        teclado.close();
    }
}
