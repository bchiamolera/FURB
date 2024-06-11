/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package furb.pilha;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Bernardo Chiamolera
 */
public class PilhaListaTest {
    
    public PilhaListaTest() {
    }
    
    @Test
    public void testEstaVazia() {
        PilhaLista pilha = new PilhaLista();
        
        boolean expected = true;
        boolean actual = pilha.estaVazia();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testNaoEstaVazia() throws Exception {
        PilhaLista pilha = new PilhaLista();
        
        pilha.push(10);
        
        boolean expected = false;
        boolean actual = pilha.estaVazia();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testPopPush() throws Exception {
        PilhaLista pilha = new PilhaLista();
        
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        
        int expected1 = 30;
        int actual1 = (int) pilha.pop();
        
        int expected2 = 20;
        int actual2 = (int) pilha.pop();
        
        int expected3 = 10;
        int actual3 = (int) pilha.pop();
        
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }

    @Test
    public void testPeek() throws Exception {
        PilhaLista pilha = new PilhaLista();
        
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        
        int expected = 30;
        int actual = (int) pilha.peek();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testLiberar() throws Exception {
        PilhaLista pilha = new PilhaLista();
        
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        
        pilha.liberar();
        
        boolean expected = true;
        boolean actual = pilha.estaVazia();
        
        assertEquals(expected, actual);
    }
    
}
