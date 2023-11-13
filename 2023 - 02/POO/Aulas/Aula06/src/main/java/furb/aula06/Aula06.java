/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package furb.aula06;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Aula06 {
    public Aula06() {
        Turma t = new Turma();
        
        t.addPessoa(new Pessoa(123, "Bernardo"));
        t.addPessoa(new Pessoa(456, "Maria"));
        t.addPessoa(new Pessoa(789, "Joao"));
        
        System.out.println("Listando: ");
        System.out.println(t.toString());
        
        System.out.println("Removendo: ");
        System.out.println(t.removePessoa(456));
        System.out.println(t.removePessoa(0000));
        System.out.println(t.toString());
        
        System.out.println("Atualizando: ");
        System.out.println(t.updatePessoa(789, "Hermes"));
        System.out.println(t.toString());
        
        System.out.println("Buscando: ");
        System.out.println(t.getAluno(123));
        System.out.println(t.getAluno(456));
    }
    
    public static void main(String[] args) {
        new Aula06();
    }
}
