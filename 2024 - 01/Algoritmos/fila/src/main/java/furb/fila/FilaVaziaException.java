/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.fila;

/**
 *
 * @author Bernardo Chiamolera
 */
public class FilaVaziaException extends Exception {

    public FilaVaziaException() {
        super("A fila está vazia");
    }
    
}
