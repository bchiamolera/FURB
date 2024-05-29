/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.listaduplamenteencadeada;

/**
 *
 * @author Bernardo Chiamolera
 */
public class NoListaDupla<T> {
    
    private T info;
    private NoListaDupla<T> proximo;
    private NoListaDupla<T> anterior;

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoListaDupla<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoListaDupla<T> proximo) {
        this.proximo = proximo;
    }

    public NoListaDupla<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NoListaDupla<T> anterior) {
        this.anterior = anterior;
    }
    
    @Override
    public String toString() {
        return getInfo().toString();
    }
    
}
