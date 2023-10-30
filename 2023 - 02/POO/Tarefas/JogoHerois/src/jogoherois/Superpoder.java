/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogoherois;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Superpoder {
    // Atributos
    private String nome;
    private int categoria;

    // Construtor
    public Superpoder(String nome, int categoria) {
        setNome(nome);
        setCategoria(categoria);
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
    
    
}
