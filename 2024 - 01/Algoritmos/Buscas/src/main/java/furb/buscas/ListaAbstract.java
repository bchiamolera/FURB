/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.buscas;

/**
 *
 * @author Bernardo Chiamolera
 */
public abstract class ListaAbstract<T> {
    private T[] info;
    private int tamanho;
    
    public ListaAbstract() {
        this.info = (T[]) new Object[10];
        this.tamanho = 0;
    }
    
    public int getTamanho() {
        return this.tamanho;
    }
    
    protected void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    
    protected void redimensionar() {
       T[] tempLista = (T[]) this.info;
       this.info = (T[]) new Object[this.info.length + 10];
        
        for (int i = 0; i < tempLista.length; i++) {
            this.info[i] = tempLista[i];
        }
    }
    
    protected T[] getInfo() {
        return this.info;
    }
    
    public abstract void inserir(T valor);
    
    public void exibir() {
        String retorno = "";
        for (int i = 0; i < this.tamanho; i++) {
            retorno += this.info[i] + " ";
        }
        System.out.println(retorno);
    }
    
    public abstract int buscar(T valor);
    
    public void retirar (T valor) {
        
        int posicao = buscar(valor);
        
        for (int i = posicao; i < this.tamanho - 1; i++) {
            this.info[i] = this.info[i + 1];
        }
        tamanho--;
    }
    
    public void liberar() {
        this.info = (T[]) new Object[10];
        this.tamanho = 0;
    }
    
    public T obterElemento(int posicao) throws IndexOutOfBoundsException {
        if (posicao > tamanho) {
            throw new IndexOutOfBoundsException();
        }
        
        return (T) this.info[posicao];
        
    }
    
    @Override
    public String toString() {
        String retorno = "";
        for (int i = 0; i < this.tamanho; i++) {
            if (i == tamanho - 1) {
                retorno += this.info[i];
            }
            else {
                retorno += this.info[i] + ",";
            }
        }
        return retorno;
    }
    
    public boolean estaVazia() {
        return tamanho == 0;
    }
    
    public void inverter() {
        T lastItem;
        int lastIndex = tamanho - 1;
        
        for (int i = 0; i < lastIndex; i++) {
            lastItem = obterElemento(lastIndex);
            this.info[lastIndex] = obterElemento(i);
            this.info[i] = lastItem;
            lastIndex--;
        }
    }
}
