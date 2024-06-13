/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package furb.fila;

/**
 *
 * @author Bernardo Chiamolera
 */
public interface Fila<T> {
    public void inserir(T valor) throws FilaCheiaException;
    public boolean estaVazia();
    public T peek() throws FilaVaziaException;
    public T retirar() throws FilaVaziaException;
    public void liberar();
}
