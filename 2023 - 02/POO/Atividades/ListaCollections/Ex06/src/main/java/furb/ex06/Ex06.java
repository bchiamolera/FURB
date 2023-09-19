/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package furb.ex06;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Ex06 {
    public static void TestePessoa() {
        Pessoa p01 = new Pessoa("Bernardo");
        p01.addEndereco("R. Heinrich Hosang", "B. Viktor Konder, Apt. 608", 605);
        p01.addEndereco("R. Gotlieb Geissler", "B. Padre Eduardo", 111);
        p01.addEndereco("R. Joao Januario Ayrosos", "B. Jaragua Esquerdo", 630);
        
        System.out.println(p01.imprimirEnderecos());
    }
    
    public static void main(String[] args) {
        TestePessoa();
    }
}
