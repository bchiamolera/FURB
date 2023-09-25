/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex05;

/**
 *
 * @author Bernardo Chiamolera
 */
import java.util.HashMap;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Ex05 {

    /**
     * @param args the command line arguments
     */
    DecimalFormat dfMoney = new DecimalFormat("#,###.00");
    
    public static int cadastrar(Scanner s, HashMap<String, Pessoa> h) {
        System.out.println("Nome: ");
        String nome = s.next();
        System.out.println("CPF: ");
        String cpf = s.next();
        System.out.println("Renda Anual (R$): ");
        double renda = Double.parseDouble(s.next());
        
        Pessoa p = new Pessoa(nome, cpf, renda);
        h.put(cpf, p);
        determinarImposto(p);
        
        int d = 0;
        do {
        System.out.println("Deseja cadastrar mais um contribuinte? 1. Sim || 2. Não");
        d = Integer.parseInt(s.next());
        } while (d < 1 && d > 2);
        return d;
    }
    
    public static void determinarImposto(Pessoa p) {
        double renda = p.getRendaAnual();
        double imposto = 0;
        if (renda <= 4000) {
            imposto = renda;
        } else if (renda <= 9000) {
            imposto = renda * 0.058;
        } else if (renda <= 25000) {
            imposto = renda * 0.15;
        } else if (renda <= 35000) {
            imposto = renda * 0.275;
        } else imposto = renda * 0.3;
        p.setImposto(imposto);
    }
    
    public static String imprimir(String cpf, HashMap<String, Pessoa> h) {
        if (h.containsKey(cpf)) {
            return h.get(cpf).toString() + "\nImposto: R$" + h.get(cpf).getImposto();
        }
        return "Pessoa nao encontrada";
    }
    
    public static String imprimirMaiorImposto(HashMap<String, Pessoa> h) {
        String ret = "";
        double maiorImposto = 0;
        for (Pessoa p : h.values()) {
            if (p.getImposto() > maiorImposto) {
                maiorImposto = p.getImposto();
                ret = p.toString() + "\nImposto: R$" + p.getImposto() + "\n";
            } else if (p.getImposto() == maiorImposto) {
                ret += p.toString() + "\nImposto: R$" + p.getImposto() + "\n";
            }
        }
        if (maiorImposto == 0) {
            ret = "Nenhum contribuinte pagrá imposto.";
        }
        return ret;
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        HashMap<String, Pessoa> h = new HashMap<String, Pessoa>();
        
        boolean b1 = true;
        do {
            int d = cadastrar(s, h);
            if (d == 2) b1 = false;
        } while (b1);
        
        System.out.println("\nDigite o CPF de um contribuinte para ver seus dados e imposto: ");
        String cpf = s.next();
        System.out.println(imprimir(cpf, h));
        
        System.out.println("\nMaior imposto:");
        System.out.println(imprimirMaiorImposto(h));
    }
    
}
