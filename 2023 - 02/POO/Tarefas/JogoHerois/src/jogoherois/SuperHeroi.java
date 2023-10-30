/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogoherois;

/**
 *
 * @author Bernardo Chiamolera
 */
public class SuperHeroi extends Personagem {
    // Construtor
    public SuperHeroi(String nome, String nomeVidaReal) {
        super(nome, nomeVidaReal);
    }
    
    // Métodos
    @Override
    public double getPoderTotal() {
        double total = 0.0;
        for (Superpoder poder : poderes) {
            total += poder.getCategoria();
        }
        return total + (total / 100) * 10;
    }
}
