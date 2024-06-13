/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.pilha;

/**
 *
 * @author Bernardo Chiamolera
 */
public class PilhaLista<T> implements Pilha<T> {
    
    private ListaEncadeada<T> listaPilha;

    public PilhaLista() {
        this.listaPilha = new ListaEncadeada();
    }

    @Override
    public void push(T info) throws PilhaCheiaException {
        this.listaPilha.inserir(info);
    }

    @Override
    public T pop() throws PilhaVaziaException {
        if (listaPilha.estaVazia()) {
            throw new PilhaVaziaException();
        }
        
        T valor = peek();
        this.listaPilha.retirar(valor);
        
        return valor;
    }

    @Override
    public T peek() throws PilhaVaziaException {
        if (listaPilha.estaVazia()) {
            throw new PilhaVaziaException();
        }
        return this.listaPilha.getPrimeiro().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return this.listaPilha.estaVazia();
    }

    @Override
    public void liberar() throws PilhaVaziaException {
        while (!this.estaVazia()) {
            this.pop();
        }
    }
    
    public ListaEncadeada<T> getLista() {
        return this.listaPilha;
    }
    
}
