/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.testeaula01;

/**
 *
 * @author Bernardo Chiamolera
 */
public class ListaEstatica {
    
    private int[] info;
    private int tamanho;
    
    public ListaEstatica() {
        info = new int[10];
        tamanho = 0;
    }
    
    private void redimensionar() {
       int[] tempLista = this.info;
        
       this.info = new int[this.info.length + 10];
        
        for (int i = 0; i < tempLista.length; i++) {
            this.info[i] = tempLista[i];
        }
    }
    
    public void inserir(int valor) {
        this.tamanho++;
        if (this.tamanho > this.info.length) {
            redimensionar();
        }
        this.info[tamanho - 1] = valor;
    }
    
    public void exibir() {
        String retorno = "";
        for (int i = 0; i < this.tamanho; i++) {
            retorno += this.info[i] + "\n";
        }
        System.out.println(retorno);
    }
    
    public int buscar(int valor) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.info[i] == valor) {
                return i;
            }
        }
        return -1;
    }
    
    public void retirar (int valor) {
        
        int posicao = buscar(valor);
        
        for (int i = posicao; i < this.tamanho - 1; i++) {
            this.info[i] = this.info[i + 1];
        }
        tamanho--;
    }
    
    public void liberar() {
        this.info = new int[10];
        this.tamanho = 0;
    }
    
    public int obterElemento(int posicao) throws IndexOutOfBoundsException {
        if (posicao > tamanho) {
            throw new IndexOutOfBoundsException();
        }
        
        return this.info[posicao];
        
    }
    
    public boolean estaVazia() {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.info[i] != 0) {
                return false;
            }
        }
        return true;
    }
    
    public int getTamanho() {
        return this.tamanho;
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
    
}
