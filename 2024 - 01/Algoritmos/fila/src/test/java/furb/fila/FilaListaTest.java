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
public class FilaListaTest {
    
    public FilaListaTest() {
    }

    @Test
    public void testEstaVazia() {
        Fila fila = new FilaLista();
        
        boolean expected = true;
        boolean actual = fila.estaVazia();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testNaoEstaVazia() throws FilaCheiaException {
        Fila fila = new FilaLista();
        
        fila.inserir(10);
        
        boolean expected = false;
        boolean actual = fila.estaVazia();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testInserirRetirar() throws FilaCheiaException, FilaVaziaException {
        Fila fila = new FilaLista();
        
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
    public void testPeek() throws FilaCheiaException, FilaVaziaException {
        Fila fila = new FilaLista();
        
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        
        int expected = 10;
        int actual = (int) fila.peek();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testLiberar() throws FilaCheiaException, FilaVaziaException {
        Fila fila = new FilaLista();
        
        fila.inserir(10);
        fila.inserir(10);
        fila.inserir(10);
        
        fila.liberar();
        
        boolean expected = true;
        boolean actual = fila.estaVazia();
        
        assertEquals(expected, actual);
    }
    
}
