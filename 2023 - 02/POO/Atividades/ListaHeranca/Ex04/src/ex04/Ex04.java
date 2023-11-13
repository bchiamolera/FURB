package ex04;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Ex04 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashMap<Integer, Navio> frota = new HashMap<>();
        
        Navio n1 = new Navio(768, 1490, "Redenção XIII");
        n1.adicionarBote(new BotesSalvaVidas(5452, 498, false));
        n1.adicionarBote(new BotesSalvaVidas(2346, 328, true));
        n1.adicionarBote(new BotesSalvaVidas(438, 157, true));
        
        Navio n2 = new Navio(123, 567, "Glória");
        n2.adicionarBote(new BotesSalvaVidas(678, 34, true));
        n2.adicionarBote(new BotesSalvaVidas(471, 853, false));
        
        frota.put(n1.getRegistroCapitania(), n1);
        frota.put(n2.getRegistroCapitania(), n2);
        
        System.out.println("Qual navio deseja visualizar?");
        int op = s.nextInt();
        if (frota.containsKey(op)) System.out.println(frota.get(op).mostrar());
        else System.out.println("Navio não encontrado");
    }
}
