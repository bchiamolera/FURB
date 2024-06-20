/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.arvorebinaria;

/**
 *
 * @author Bernardo Chiamolera
 */
public class NoArvoreBinaria<T> {
    private T info;
    private NoArvoreBinaria esquerda;
    private NoArvoreBinaria direita;

    public NoArvoreBinaria(T info) {
        this.info = info;
        this.esquerda = null;
        this.direita = null;
    }

    public NoArvoreBinaria(T info, NoArvoreBinaria esquerda, NoArvoreBinaria direita) {
        this.info = info;
        this.esquerda = esquerda;
        this.direita = direita;
    }
    
    public void setInfo(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public NoArvoreBinaria<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoArvoreBinaria<T> esquerda) {
        this.esquerda = esquerda;
    }

    public NoArvoreBinaria<T> getDireita() {
        return direita;
    }

    public void setDireita(NoArvoreBinaria<T> direita) {
        this.direita = direita;
    }
    
    
}
