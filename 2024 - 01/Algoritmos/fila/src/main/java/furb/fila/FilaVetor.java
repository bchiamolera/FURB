/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.fila;

/**
 *
 * @author Bernardo Chiamolera
 */
public class FilaVetor<T> implements Fila<T> {
    private T[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaVetor(int limite) {
        this.info = (T[]) new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
        this.inicio = 0;
    }

    @Override
    public void inserir(T valor) throws FilaCheiaException {
        if (this.tamanho == this.limite) {
            throw new FilaCheiaException();
        }
        int posicao = (this.inicio + this.tamanho) % this.limite;
        this.info[posicao] = valor;
        this.tamanho = this.tamanho + 1;
    }

    @Override
    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    @Override
    public T peek() throws FilaVaziaException {
        if (this.estaVazia()) {
            throw new FilaVaziaException();
        }
        return this.info[inicio];
    }

    @Override
    public T retirar() throws FilaVaziaException {
        if (this.estaVazia()) {
            throw new FilaVaziaException();
        }
        
        T valor = peek();
        
        this.info[inicio] = null;

        this.inicio = (this.inicio + 1) % this.limite;
        this.tamanho--;
        return valor;
    }

    @Override
    public void liberar() {
        this.info = (T[]) new Object[this.limite];
        this.tamanho = 0;
        this.inicio = 0;
    }
    
    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) throws FilaCheiaException, FilaVaziaException {
        FilaVetor<T> f3 = new FilaVetor<>(this.getLimite() + f2.getLimite());
        
        for (int i = 0; i < this.tamanho; i++) {
            T f1Valor = this.info[i];
            f3.inserir(f1Valor);
        }
        for (int i = 0; i < f2.getTamanho(); i++) {
            T f2Valor = f2.info[i];
            f3.inserir(f2Valor);
        }
        
        return f3;
    }
    
    @Override
    public String toString() {
        String ret = "";
        for (int i = 0; i < this.tamanho; i++) {
            if (i + 1 == this.tamanho) {
                ret += this.info[i];
            }
            else {
                ret += this.info[i] + ",";
            }
        }
        return ret;
    }
    
    public int getLimite() {
        return this.limite;
    }
    
    public int getTamanho() {
        return this.tamanho;
    }
}
