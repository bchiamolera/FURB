/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex03;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Lutador extends Atleta {

    public Lutador(String nome, double peso, int idade) {
        super(nome, peso, idade);
    }

    @Override
    public String definirCategoria() {
        String categoria;
        if (this.getPeso() <= 54) {
            categoria = "Pluma";
        } else if (this.getPeso() <= 60) {
            categoria = "Leve";
        } else if (this.getPeso() <= 75) {
            categoria = "Meio-leve";
        } else categoria = "Pesado";
        return categoria;
    }
    
}
