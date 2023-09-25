/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex01modelagem;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Ex01Modelagem {

    /**
     * @param args the command line arguments
     */
    public static String menorConsumo(ArrayList<ContaLuz> cts) {
        if (cts.size() == 0)
            return "Não há contas cadastradas";
        String ret = "";
        int menorConsumo = Integer.MAX_VALUE;
        ContaLuz ctResult = cts.get(0);
        for (ContaLuz ct : cts) {
            if (ct.getKwGasto() < menorConsumo) {
                ctResult = ct;
                menorConsumo = ct.getKwGasto();
            }
        }
        return ctResult.toString();
    }

    public static String maiorConsumo(ArrayList<ContaLuz> cts) {
        if (cts.size() == 0)
            return "Não há contas cadastradas";
        String ret = "";
        int maiorConsumo = Integer.MIN_VALUE;
        ContaLuz ctResult = cts.get(0);
        for (ContaLuz ct : cts) {
            if (ct.getKwGasto() > maiorConsumo) {
                ctResult = ct;
                maiorConsumo = ct.getKwGasto();
            }
        }
        return ctResult.toString();
    }

    public static void cadastrarConta(Scanner s, ContaLuz conta, ArrayList<ContaLuz> cts) {
        cts.add(conta);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<ContaLuz> contas = new ArrayList<ContaLuz>();

        System.out.println("Data da Leitura (Digite 'fim' para encerrar): ");
        String dtLeitura = s.next();

        while(!dtLeitura.trim().toLowerCase().equals("fim")) {
            try {
                System.out.println("Número de Leitura: ");
                int numLeitura = s.nextInt();

                System.out.println("Quantidade gasta (Kw): ");
                int qtdKw = s.nextInt();

                System.out.println("Valor a pagar (R$): ");
                double vlrPagar = s.nextDouble();

                System.out.println("Data de Pagamento: ");
                String dtPagamento = s.next();

                System.out.println("Média de Consumo (R$): ");
                double mdConsumo = s.nextDouble();

                ContaLuz conta = new ContaLuz(dtLeitura, numLeitura, qtdKw, vlrPagar, dtPagamento, mdConsumo);
                cadastrarConta(s, conta, contas);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Data da Leitura (Digite 'fim' para encerrar): ");
            dtLeitura = s.next();
        }
        
        System.out.println("Menor consumo: ");
        System.out.println(menorConsumo(contas));
        
        System.out.println("Maior consumo: ");
        System.out.println(maiorConsumo(contas));
        
    }

}
