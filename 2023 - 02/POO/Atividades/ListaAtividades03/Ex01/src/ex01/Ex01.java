/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex01;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Ex01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Prova p1 = new Prova(new Concorrente("Joao", "Dev Junior", 101, "999018934", "Rua XV de Novembro"), 7.5);
        Prova p2 = new Prova(new Concorrente("Fábio", "Suporte", 208, "999909234", "Rua Antonio da Veiga"), 8.5);        
        Prova p3 = new Prova(new Concorrente("Lucas", "Dev Senior", 900, "998234564", "Rua VII de Setembro"), 4.0);
        Prova p4 = new Prova(new Concorrente("Amanda", "DevOps", 547, "999981234", "Rua Bahia"), 0.5);
        Prova p5 = new Prova(new Concorrente("Maria", "Analista", 302, "990923423", "Rua São Paulo"), 9.9);
        
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
        System.out.println(p4.toString());
        System.out.println(p5.toString());
    }
    
}
