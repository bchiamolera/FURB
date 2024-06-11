/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.pilha;

/**
 *
 * @author Bernardo Chiamolera
 */
public class PilhaVaziaException extends Exception {

    public PilhaVaziaException() {
        super("A pilha está vazia");
    }
    
}
