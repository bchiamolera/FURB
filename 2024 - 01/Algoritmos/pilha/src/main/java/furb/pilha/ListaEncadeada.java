/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.pilha;

/**
 *
 * @author Bernardo Chiamolera
 */
public class ListaEncadeada<T> {
    private NoLista<T> primeiro;

    public ListaEncadeada() {
        primeiro = null;
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T info) {
        NoLista<T> novoNo = new NoLista();
        novoNo.setInfo(info);
        if (primeiro != null) {
            novoNo.setProximo(primeiro);
        }
        this.primeiro = novoNo;
    }
    
    public boolean estaVazia() {
        return primeiro == null;
    }
    
    public NoLista<T> buscar(T info) {
        NoLista<T> currentNo = primeiro;
        
        while (!currentNo.getInfo().equals(info) && currentNo.getProximo() != null) {
            currentNo = currentNo.getProximo();
        }
        if (!currentNo.getInfo().equals(info)) {
            return null;
        }
        return currentNo;
    }
    
    public void retirar(T info) {
        NoLista<T> removedNo = buscar(info);
        if (removedNo != null) {
            if (removedNo == primeiro) {
                primeiro = removedNo.getProximo();
                removedNo.setProximo(null);
            }
            else {
                NoLista<T> currentNo = primeiro;
                while(currentNo.getProximo() != removedNo && currentNo.getProximo() != null) {
                    currentNo = currentNo.getProximo();
                }
                if (currentNo.getProximo() != null) {
                    currentNo.setProximo(removedNo.getProximo());
                    removedNo.setProximo(null);
                }
            }
        }
    }
    
    public int obterComprimento() {
        int comprimento = 0;
        NoLista<T> currentNo = primeiro;
        if (currentNo != null) {
            comprimento++;
            while (currentNo.getProximo() != null) {
                comprimento++;
            }
        }
        
        return comprimento;
    }
    
    public NoLista<T> obterNo(int idx) throws IndexOutOfBoundsException {
        if (idx < 0 || idx >= obterComprimento()) {
            throw new IndexOutOfBoundsException();
        }
        else {
            NoLista<T> targetNo = primeiro;
            for (int i = 0; i != idx; i++) {
                targetNo = targetNo.getProximo();
            }
            return targetNo;
        }
    }
    
    @Override
    public String toString() {
        String r = "";
        if (primeiro != null) {
            NoLista<T> currentNo = primeiro;
            while (currentNo != null) {
                if (currentNo.getProximo() != null) {
                    r += currentNo.getInfo().toString()+ ",";
                }
                else {
                    r += currentNo.getInfo().toString();
                }
                currentNo = currentNo.getProximo();
            }
        }        
        return r;
    }   
}