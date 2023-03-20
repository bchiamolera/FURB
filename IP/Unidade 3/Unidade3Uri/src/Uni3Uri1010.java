import java.util.Scanner;
import java.text.DecimalFormat;

public class Uni3Uri1010 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        DecimalFormat df_2 = new DecimalFormat("0.00");

        String produtoUm = teclado.nextLine();
        String produtoDois = teclado.nextLine();
        String[] produtoUmSeparado = produtoUm.split(" ");
        String[] produtoDoisSeparado = produtoDois.split(" ");

        int codigoUm = Integer.parseInt(produtoUmSeparado[0]);
        double quantidadeUm = Double.parseDouble(produtoUmSeparado[1]);
        double precoUm = Double.parseDouble(produtoUmSeparado[2]);

        int codigoDois = Integer.parseInt(produtoDoisSeparado[0]);
        double quantidadeDois = Double.parseDouble(produtoDoisSeparado[1]);
        double precoDois = Double.parseDouble(produtoDoisSeparado[2]);

        double valorPagar = (quantidadeUm * precoUm) + (quantidadeDois * precoDois);

        System.out.println("VALOR A PAGAR: R$ " + df_2.format(valorPagar));
        teclado.close();
    }
}
