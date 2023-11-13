/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogoherois;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Vilao extends Personagem {
    // Atributos
    private int tempoDePrisao;
    
    // Construtor
    public Vilao(String nome, String nomeVidaReal, int tempoDePrisao) {
        super(nome, nomeVidaReal);
        setTempoDePrisao(tempoDePrisao);
    }
    
    // Getters e Setters
    public int getTempoDePrisao() {
        return tempoDePrisao;
    }

    public void setTempoDePrisao(int tempoDePrisao) {
        this.tempoDePrisao = tempoDePrisao;
    }
    
}
