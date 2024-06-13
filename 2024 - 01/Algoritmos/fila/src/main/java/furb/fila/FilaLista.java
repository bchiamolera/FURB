/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.fila;

/**
 *
 * @author Bernardo Chiamolera
 */
public class FilaLista<T> implements Fila<T> {
    private ListaEncadeada<T> lista;

    public FilaLista() {
        this.lista = new ListaEncadeada<>();
    }

    @Override
    public void inserir(T valor) {
        this.lista.inserirNoFinal(valor);
    }

    @Override
    public boolean estaVazia() {
        return this.lista.estaVazia();
    }

    @Override
    public T peek() {
        if (this.estaVazia()) {
            
        }
        return (T) this.lista.getPrimeiro().getInfo();
    }

    @Override
    public T retirar() {
        if (this.estaVazia()) {
            
        }
        T valor = peek();
        this.lista.retirar(valor);
        return valor;
    }

    @Override
    public void liberar() {
        this.lista = new ListaEncadeada<>();
    }
    
    @Override
    public String toString() {
        return this.lista.toString();
    }
}
