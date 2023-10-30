/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogoherois;

import java.util.ArrayList;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Personagem {

    // Atributos
    private String nome;
    private String nomeVidaReal;
    protected ArrayList<Superpoder> poderes;

    // Construtor
    public Personagem(String nome, String nomeVidaReal) {
        this.nome = nome;
        this.nomeVidaReal = nomeVidaReal;
        this.poderes = new ArrayList();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeVidaReal() {
        return nomeVidaReal;
    }

    public void setNomeVidaReal(String nomeVidaReal) {
        this.nomeVidaReal = nomeVidaReal;
    }

    public ArrayList<Superpoder> getPoderes() {
        return poderes;
    }

    public void setPoderes(ArrayList<Superpoder> poderes) {
        this.poderes = poderes;
    }

    // Métodos
    public void adicionaSuperpoder(Superpoder sp) {
        this.poderes.add(sp);
    }

    public double getPoderTotal() {
        double total = 0.0;
        for (Superpoder poder : poderes) {
            total += poder.getCategoria();
        }
        return total;
    }

}
