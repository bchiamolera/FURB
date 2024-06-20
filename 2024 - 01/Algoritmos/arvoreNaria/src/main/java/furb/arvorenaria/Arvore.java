/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.arvorenaria;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Arvore<T> {
    private NoArvore<T> raiz;

    public Arvore() {
        this.raiz = null;
    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }
    
    @Override
    public String toString() {
        if (raiz == null) {
            return "";
        }
        return obterInformacaoTextual(this.raiz);
    }
    
    private String obterInformacaoTextual(NoArvore<T> no) {
        String s = "<";
        s += no.getInfo();
        
        NoArvore p = no.getPrimeiro();
        while (p != null) {
            s += this.obterInformacaoTextual(p);
            p = p.getProximo();
        }
        s += ">";
        return s;
    }
    
    public boolean pertence(T info) {
        if (this.raiz == null) {
            return false;
        }
        return pertence(this.raiz, info);
    }
    
    private boolean pertence(NoArvore<T> no, T info) {
        if (no.getInfo() == info) {
            return true;
        }
        NoArvore p = no.getPrimeiro();
        while (p != null) {
            if (this.pertence(p, info)) {
                return true;
            }
            p = p.getProximo();
        }
        return false;
    }
    
    public int ContarNos() {
        if (this.raiz == null) {
            return 0;
        }
        return ContarNos(raiz);
    }
    
    private int ContarNos(NoArvore<T> no) {
        int qtd = 1;
        
        NoArvore p = no.getPrimeiro();
        while (p != null) {
            qtd += ContarNos(p);
            p = p.getProximo();
        }
        return qtd;
    }
}
