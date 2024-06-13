/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package furb.fila;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Bernardo Chiamolera
 */
public class FilaVetorTest {
    
    public FilaVetorTest() {
    }

    @Test
    public void testEstaVazia() {
        Fila fila = new FilaVetor(5);
        
        boolean expected = true;
        boolean actual = fila.estaVazia();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testNaoEstaVazia() throws Exception {
        Fila fila = new FilaVetor(5);
        
        fila.inserir(10);
        
        boolean expected = false;
        boolean actual = fila.estaVazia();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testInserirRetirar() throws Exception {
        Fila fila = new FilaVetor(10);
        
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        
        int expected1 = 10;
        int actual1 = (int) fila.retirar();
        
        int expected2 = 20;
        int actual2 = (int) fila.retirar();
        
        int expected3 = 30;
        int actual3 = (int) fila.retirar();
        
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }

    @Test
    public void testFilaCheia() throws Exception {
        Fila fila = new FilaVetor(3);
        
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        
        String expected = "A fila está cheia";
        FilaCheiaException actual = assertThrows(FilaCheiaException.class, () -> fila.inserir(40));
        
        assertEquals(expected, actual.getMessage());
    }

    @Test
    public void testFilaVazia() throws Exception {
        Fila fila = new FilaVetor(3);
        
        String expected = "A fila está vazia";
        FilaVaziaException actual = assertThrows(FilaVaziaException.class, () -> fila.retirar());
        
        assertEquals(expected, actual.getMessage());
    }

    @Test
    public void testPeek() throws Exception {
        Fila fila = new FilaVetor(5);
        
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        
        int expected = 10;
        int actual = (int) fila.peek();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testLiberar() throws Exception {
        Fila fila = new FilaVetor(5);
        
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        fila.liberar();
        
        boolean expected = true;
        boolean actual = fila.estaVazia();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testConcatenar() throws Exception {
        FilaVetor f1 = new FilaVetor(5);
        
        f1.inserir(10);
        f1.inserir(20);
        f1.inserir(30);
        
        FilaVetor f2 = new FilaVetor(3);
        f2.inserir(40);
        f2.inserir(50);
        
        FilaVetor f3 = f1.criarFilaConcatenada(f2);
        
        String expected1 = "10,20,30,40,50";
        String actual1 = f3.toString();
        
        String expected2 = "10,20,30";
        String actual2 = f1.toString();
        
        String expected3 = "40,50";
        String actual3 = f2.toString();
        
        int expected4 = 8;
        int actual4 = f3.getLimite();
        
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }
    
}
