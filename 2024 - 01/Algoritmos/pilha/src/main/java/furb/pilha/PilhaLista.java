/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.pilha;

/**
 *
 * @author Bernardo Chiamolera
 */
public class PilhaLista<T> implements Pilha{
    
    private ListaEncadeada listaPilha;

    public PilhaLista() {
        this.listaPilha = new ListaEncadeada();
    }

    @Override
    public void push(Object info) throws PilhaCheiaException {
        this.listaPilha.inserir(info);
    }

    @Override
    public Object pop() throws PilhaVaziaException {
        if (listaPilha.estaVazia()) {
            throw new PilhaVaziaException();
        }
        
        Object valor = peek();
        this.listaPilha.retirar(valor);
        
        return valor;
    }

    @Override
    public Object peek() throws PilhaVaziaException {
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
    public void liberar() {
        try {
            while (!this.estaVazia()) {
                this.pop();
            }
        } catch (Exception e) {
            
        }
    }
    
}
