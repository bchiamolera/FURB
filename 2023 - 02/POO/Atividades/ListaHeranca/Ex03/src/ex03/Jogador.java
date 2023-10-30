/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex03;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Jogador extends Atleta {

    public Jogador(String nome, double peso, int idade) {
        super(nome, peso, idade);
    }

    @Override
    public String definirCategoria() {
        String categoria = "";
        if (this.getIdade() < 16) {
            categoria = "Infantil";
        } else if (this.getPeso() < 18) {
            categoria = "Juvenil";
        } else {
            categoria = "Adulto";
        }
        return categoria;
    }

}
