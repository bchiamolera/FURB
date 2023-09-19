/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.atividadearraylist02;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Computador {
    // Atributos
    private int numSerial;
    private int capacidadeHd;
    private int qtdMemoria;

    // Construtor
    public Computador(int numSerial, int capacidadeHd, int qtdMemoria) throws IllegalAccessException {
        setNumSerial(numSerial);
        setCapacidadeHd(capacidadeHd);
        setQtdMemoria(qtdMemoria);
    }
    
    // Getters e Setters
    public int getNumSerial() {
        return numSerial;
    }
    public void setNumSerial(int numSerial) throws IllegalAccessException {
        if (numSerial < 0) {
            throw new IllegalAccessException("Número de serial inválido");
        }
        this.numSerial = numSerial;
    }

    public int getCapacidadeHd() {
        return capacidadeHd;
    }
    public void setCapacidadeHd(int capacidadeHd) throws IllegalAccessException {
        if (capacidadeHd < 0) {
            throw new IllegalAccessException("Capacidade de HD inválida");
        }
        this.capacidadeHd = capacidadeHd;
    }

    public int getQtdMemoria() {
        return qtdMemoria;
    }
    public void setQtdMemoria(int qtdMemoria) throws IllegalAccessException {
        if (qtdMemoria < 0) {
            throw new IllegalAccessException("Quantidade de memória inválida");
        }
        this.qtdMemoria = qtdMemoria;
    }
    
    // Métodos
    
    public String toString() {
        return "- Número serial: " + this.getNumSerial()
                + ", capacidade HD: " + this.getCapacidadeHd()
                + ", quantidade de memória: " + this.getQtdMemoria() + ";";
    }
}
