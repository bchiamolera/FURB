/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aula07.relacionamentos;

/**
 *
 * @author Bernardo Chiamolera
 */
import java.util.HashMap;
import java.util.Scanner;

public class Aula07Relacionamentos {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashMap<String, Artigo> seminco = new HashMap<>();
        
        Artigo a1 = new Artigo("A Arte de Programar", "Henrique");
        a1.adicionarAvaliacao(new Revisor("Aurelio", "Os exemplos estão errados", "Rejeitado")); // Agregação
        a1.adicionarAvaliacao(new Revisor("Maju", "Muito bom!", "Aceito"));
        a1.adicionarAvaliacao(new Revisor("Luciana", "Erros no código", "Rejeitado"));
        
        seminco.put(a1.getTitulo(), a1);
        
        
        Artigo a2 = new Artigo("Desenvolvimento de Jogos como Método de Ensino", "Bernardo");
        a2.adicionarAvaliacao(new Revisor("Aurelio", "Ótimo!", "Aceito"));
        a2.adicionarAvaliacao(new Revisor("Maju", "Faltaram informações", "Rejeitado"));
        a2.adicionarAvaliacao(new Revisor("Luciana", "Muito bom!", "Aceito"));
        
        seminco.put(a2.getTitulo(), a2);
        
        
        String titulo = s.nextLine();
        if (seminco.containsKey(titulo)) {            
            System.out.println(seminco.get(titulo).toString());
        } else {
            System.out.println("Artigo não encontrado");
        }
        
        s.close();
    }
}
