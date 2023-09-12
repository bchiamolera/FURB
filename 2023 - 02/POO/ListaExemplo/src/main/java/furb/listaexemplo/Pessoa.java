/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.listaexemplo;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Pessoa {
    // Atributos
    private String nome;
    private int idade;

    // Construtor
    public Pessoa(String nome, int idade) {
        setNome(nome);
        setIdade(idade);
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) throws IllegalArgumentException {
        if (nome.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) throws IllegalArgumentException {
        if (idade < 0) {
            throw new IllegalArgumentException();
        }
        this.idade = idade;
    }
    
    // Metodos
    public String toString() {
        return "Nome: " + this.getNome() + ", " + this.getIdade() + " anos";
    }
}