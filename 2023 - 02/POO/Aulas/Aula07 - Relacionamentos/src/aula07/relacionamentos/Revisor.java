/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula07.relacionamentos;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Revisor {
    // Atributos
    private String nome;
    private String conteudo;
    private String parecer;

    // Construtor
    public Revisor(String nome, String conteudo, String parecer) {
        setNome(nome);
        setConteudo(conteudo);
        setParecer(parecer);
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getParecer() {
        return parecer;
    }

    public void setParecer(String parecer) {
        this.parecer = parecer;
    }
    
    // Métodos
    
    @Override
    public String toString() {
        return "\nConteúdo: " + this.getConteudo() + "\nParecer: " + this.getParecer()+ "\n";
    }
}
