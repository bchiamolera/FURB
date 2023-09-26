/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex01;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Prova {
    // Atributos
    private Concorrente concorrente;
    private double nota;

    // Construtor
    public Prova(Concorrente concorrente, double nota) {
        setConcorrente(concorrente);
        setNota(nota);
    }

    // Getters e Setters
    public Concorrente getConcorrente() {
        return concorrente;
    }

    public void setConcorrente(Concorrente concorrente) throws IllegalArgumentException {
        if (concorrente == null) {
            throw new IllegalArgumentException();
        }
        this.concorrente = concorrente;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) throws IllegalArgumentException {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException();
        }
        this.nota = nota;
    }

    // Métodos
    @Override
    public String toString() {
        return concorrente.toString() + " -- " + getNota();
    }
}
