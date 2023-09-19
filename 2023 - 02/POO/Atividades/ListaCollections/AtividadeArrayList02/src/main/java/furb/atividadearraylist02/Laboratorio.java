/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.atividadearraylist02;

/**
 *
 * @author Bernardo Chiamolera
 */
import java.util.ArrayList;

public class Laboratorio {

    // Atributos
    private ArrayList<Computador> computadores;
    private int numSala;

    // Construtor
    public Laboratorio(int numSala) throws IllegalAccessException {
        setNumSala(numSala);
        this.computadores = new ArrayList<Computador>();
    }

    // Getter e Setter
    public int getNumSala() {
        return numSala;
    }
    public void setNumSala(int numSala) throws IllegalAccessException {
        if (numSala < 0) {
            throw new IllegalAccessException("Número de sala inválido");
        }
        this.numSala = numSala;
    }
    
    // Métodos
    public void adicionarComputador(Computador computador) {
        computadores.add(computador);
    }

    public void imprimir() {
        int totalMemoria = 0;
        for (Computador c : computadores) {
            totalMemoria += c.getQtdMemoria();
        }
        System.out.println("\nTotal de memória na sala " + getNumSala() + ": " + totalMemoria);
        for (Computador c : computadores) {
            System.out.println(c.toString());
        }
    }
}
