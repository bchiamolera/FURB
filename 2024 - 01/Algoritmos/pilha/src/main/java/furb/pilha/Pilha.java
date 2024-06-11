/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package furb.pilha;

/**
 *
 * @author Bernardo Chiamolera
 */
public interface Pilha<T> {
    public void push(T info) throws PilhaCheiaException ;
    public T pop() throws PilhaVaziaException ;
    public T peek() throws PilhaVaziaException;
    public boolean estaVazia();
    public void liberar();
}
