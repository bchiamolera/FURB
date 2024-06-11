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
public class PilhaVetorTest {
    
    public PilhaVetorTest() {
    }

    @Test
    public void testEstaVazia() {
        PilhaVetor pilha = new PilhaVetor(1);
        
        boolean expected = true;
        boolean actual = pilha.estaVazia();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testNaoEstaVazia() throws Exception {
        PilhaVetor pilha = new PilhaVetor(5);
        
        pilha.push(10);
        
        boolean expected = false;
        boolean actual = pilha.estaVazia();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testPushPop() throws Exception {
        PilhaVetor pilha = new PilhaVetor(10);
        
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
    public void testPilhaCheiaException() throws Exception {
        PilhaVetor pilha = new PilhaVetor(3);
        
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        
        String expected = "A pilha está cheia";
        PilhaCheiaException actual = assertThrows(PilhaCheiaException.class, () -> pilha.push(40));
        
        assertEquals(expected, actual.getMessage());
    }

    @Test
    public void testPilhaVaziaException() throws Exception {
        PilhaVetor pilha = new PilhaVetor(3);
        
        String expected = "A pilha está vazia";
        PilhaVaziaException actual = assertThrows(PilhaVaziaException.class, () -> pilha.pop());
        
        assertEquals(expected, actual.getMessage());
    }

    @Test
    public void testToString() throws Exception {
        PilhaVetor pilha = new PilhaVetor(5);
        
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        
        int expected = 30;
        int actual = (int) pilha.peek();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testGetTamanho() throws Exception {
        PilhaVetor pilha = new PilhaVetor(5);
        
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        
        pilha.liberar();
        
        boolean expected = true;
        boolean actual = pilha.estaVazia();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testConcatenar() throws Exception {
        PilhaVetor pilha = new PilhaVetor(10);
        
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        
        PilhaVetor outraPilha = new PilhaVetor(5);
        outraPilha.push(40);
        outraPilha.push(50);
        
        pilha.concatenar(outraPilha);
        
        String expected = "50,40,30,20,10";
        String actual = pilha.toString();
        
        assertEquals(expected, actual);
    }
    
}
