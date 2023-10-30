/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex08;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Ex08 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pedido p1 = new Pedido(1, "Bernardo");
        Produto coca = new Produto (1, "Coca-Cola", 3.5);
        Produto hamburger = new Produto (2, "X-Salada", 20);
        
        p1.adicionarItemAoPedido(coca);
        p1.adicionarItemAoPedido(hamburger);
        
        System.out.println(p1.imprimirPedido());
    }
}
