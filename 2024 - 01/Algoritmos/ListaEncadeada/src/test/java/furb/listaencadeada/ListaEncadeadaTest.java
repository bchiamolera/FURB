/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package furb.listaencadeada;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Bernardo Chiamolera
 */
public class ListaEncadeadaTest {
    
    public ListaEncadeadaTest() {
    }

    @Test
    public void testEstaVazia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada();
        
        boolean expected = true;
        boolean actual = lista.estaVazia();
        
        assertEquals(expected, actual, "Teste 1 de errado :(");
    }
    
    @Test
    public void testNaoEstaVazia() {
        ListaEncadeada<Integer> lista = new ListaEncadeada();
        
        boolean expected = false;
        
        lista.inserir(5);
        
        boolean actual = lista.estaVazia();
        
        assertEquals(expected, actual, "Teste 2 de errado :(");
    }
    
    @Test
    public void testInserir() {
        ListaEncadeada<Integer> lista = new ListaEncadeada();
        
        boolean expected = true;
        
        lista.inserir(5);
        
        boolean actual = lista.estaVazia();
        
        assertEquals(expected, actual, "Teste 2 de errado :(");
    }
}
