/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package furb.arvorebinaria;

/**
 *
 * @author Bernardo Chiamolera
 */
public class ArvoreBinaria<T> {
    private NoArvoreBinaria<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }
    
    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }
    
    public boolean estaVazia() {
        return raiz == null;
    }
    
    public boolean pertence(T info) {
        return pertence(raiz, info);
    }
    
    private boolean pertence(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return false;
        }
        return no.getInfo() == info || pertence(no.getEsquerda(), info) || pertence(no.getDireita(), info);
    }
    
    @Override
    public String toString() {
        return arvorePre(raiz);
    }
    
    private String arvorePre(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        }
        return "<" + no.getInfo().toString() + arvorePre(no.getEsquerda()) + arvorePre(no.getDireita()) + ">";
    }
    
    public int contarNos() {
        return contarNos(raiz);
    }
    
    private int contarNos(NoArvoreBinaria<T> no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNos(no.getEsquerda()) + contarNos(no.getDireita());
    }
}
