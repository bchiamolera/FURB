/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula07.relacionamentos;

/**
 *
 * @author Bernardo Chiamolera
 */
import java.util.ArrayList;

public class Artigo {

    // Atributos
    private String titulo;
    private String autor;
    private ArrayList<Revisor> avaliadores;

    // Construtor
    public Artigo(String titulo, String autor) {
        setTitulo(titulo);
        setAutor(autor);
        this.avaliadores = new ArrayList<>();
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public ArrayList<Revisor> getAvaliadores() {
        return avaliadores;
    }

    public void setAvaliadores(ArrayList<Revisor> avaliadores) {
        this.avaliadores = avaliadores;
    }

    // Métodos
    public void adicionarAvaliacao(Revisor revisor) {
        this.avaliadores.add(revisor);
    }
    
    @Override
    public String toString() {
        String avaliacoes = "";
        for (Revisor revisor : avaliadores) {
            avaliacoes += "\nParecer do revisor #" + (avaliadores.indexOf(revisor) + 1) + revisor.toString();
        }
        return "Título: " + this.getTitulo() + "\nAutor: " + this.getAutor() + "\nAvaliações: " + avaliacoes;
    }

}
