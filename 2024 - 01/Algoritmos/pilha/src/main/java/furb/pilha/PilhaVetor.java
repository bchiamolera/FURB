/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.pilha;

/**
 *
 * @author Bernardo Chiamolera
 */
public class PilhaVetor<T> implements Pilha {
    
    private Object[] info;
    private int limite;
    private int tamanho;

    public PilhaVetor(int limite) {
        this.limite = limite;
        this.info = new Object[limite];
        this.tamanho = 0;
    }

    @Override
    public void push(Object info) throws PilhaCheiaException {
        if (tamanho >= limite) {
            throw new PilhaCheiaException();
        }

        this.info[tamanho] = (T) info;
        tamanho++;
        
    }

    @Override
    public Object pop() throws PilhaVaziaException {
        if (tamanho == 0) {
            throw new PilhaVaziaException();
        }
        
        T valor = (T) peek();
        this.info[tamanho - 1] = null;
        tamanho--;
        
        return valor;
    }

    @Override
    public Object peek() throws PilhaVaziaException {
        if (tamanho == 0) {
            throw new PilhaVaziaException();
        }
        
        return (T) this.info[tamanho - 1];
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public void liberar() {
        for (int i = 0; i < this.tamanho; i++) {
            this.info[i] = null;
        }
        tamanho = 0;
    }
    
    @Override
    public String toString() {
        String valor = "";
        if (!estaVazia()) {
            
            for (int i = this.tamanho - 1; i >= 0; i--) {
                if (i == 0) {
                    valor += this.info[i];
                }
                else {
                    valor += this.info[i] + ",";
                }
            }
        }
        return valor;
    }
    
    public int getTamanho() {
        return this.tamanho;
    }
    
    public void concatenar(PilhaVetor p) throws PilhaCheiaException, PilhaVaziaException {
        PilhaVetor temp = new PilhaVetor(p.getTamanho());
        while (!p.estaVazia()) {
            temp.push(p.pop());
        }
        while (!temp.estaVazia()) {
            this.push(temp.pop());
        }
    };
    
}
