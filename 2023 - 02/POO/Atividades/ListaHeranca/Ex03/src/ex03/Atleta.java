/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex03;

/**
 *
 * @author Bernardo Chiamolera
 */
public abstract class Atleta {
    protected String nome;
    protected double peso;
    protected int idade;

    public Atleta(String nome, double peso, int idade) {
        setNome(nome);
        setPeso(peso);
        setIdade(idade);
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    // Métodos
    public abstract String definirCategoria();
}
