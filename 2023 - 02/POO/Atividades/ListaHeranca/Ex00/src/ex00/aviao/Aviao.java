/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex00.aviao;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Aviao {
    private String cor;
    
    public Aviao(String cor) {
        setCor(cor);
        System.out.println("Avião " + cor);
    }

    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
}
