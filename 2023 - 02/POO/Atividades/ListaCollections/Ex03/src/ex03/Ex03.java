/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex03;

/**
 *
 * @author Bernardo Chiamolera
 */
import java.util.HashMap;

public class Ex03 {

    public static String inserir(String cpf, Pessoa p, HashMap<String, Pessoa> pessoas) {
        pessoas.put(cpf, p);
        return "Pessoa adicionada!";
    }
    
    public static String imprimir(HashMap<String, Pessoa> pessoas) {
        String s = "";
        for(Pessoa p : pessoas.values()) {
            s += "\nCPF: " + p.getCpf() + "\nNome: " + p.getNome() + "\n";
        }
        return s;
    }
    
    public Ex03() {
        Pessoa p01 = new Pessoa("Bernardo", "001");
        Pessoa p02 = new Pessoa("Maria", "005");
        Pessoa p03 = new Pessoa("Vinicius", "102");
        Pessoa p04 = new Pessoa("Joaquim", "929");
        Pessoa p05 = new Pessoa("Joao", "602");
        
        HashMap<String, Pessoa> pessoas = new HashMap<String, Pessoa>();
        
        inserir(p01.getCpf(), p01, pessoas);
        inserir(p02.getCpf(), p02, pessoas);
        inserir(p03.getCpf(), p03, pessoas);
        inserir(p04.getCpf(), p04, pessoas);
        inserir(p05.getCpf(), p05, pessoas);
        
        System.out.println(imprimir(pessoas));
        
    }
    
    public static void main(String[] args) {
        new Ex03();
    }
    
}
