/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package furb.buscas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Bernardo Chiamolera
 */
public class ListaOrdenadaTest {
    
    public ListaOrdenadaTest() {
    }

    @Test
    public void testInserir() {
        ListaOrdenada lista = new ListaOrdenada();
        
        lista.inserir(100);
        lista.inserir(20);
        lista.inserir(70);
        lista.inserir(1);
        
        String expected = "1,20,70,100";
        String actual = lista.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testBuscar() {
        ListaOrdenada lista = new ListaOrdenada();
        
        lista.inserir(0);
        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);
        lista.inserir(40);
        lista.inserir(50);
        lista.inserir(60);
        lista.inserir(70);
        lista.inserir(80);
        lista.inserir(90);
        lista.inserir(100);
        
        int expected = 2;
        int actual = lista.buscar(20);
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testBuscar2() {
        ListaOrdenada lista = new ListaOrdenada();
        
        lista.inserir(0);
        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);
        lista.inserir(40);
        lista.inserir(50);
        lista.inserir(60);
        lista.inserir(70);
        lista.inserir(80);
        lista.inserir(90);
        lista.inserir(100);
        
        int expected = 4;
        int actual = lista.buscar(40);
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testBuscar3() {
        ListaOrdenada lista = new ListaOrdenada();
        
        lista.inserir(0);
        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);
        lista.inserir(40);
        lista.inserir(50);
        lista.inserir(60);
        lista.inserir(70);
        lista.inserir(80);
        lista.inserir(90);
        lista.inserir(100);
        
        int expected = 7;
        int actual = lista.buscar(70);
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testBuscar4() {
        ListaOrdenada lista = new ListaOrdenada();
        
        lista.inserir(0);
        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);
        lista.inserir(40);
        lista.inserir(50);
        lista.inserir(60);
        lista.inserir(70);
        lista.inserir(80);
        lista.inserir(90);
        lista.inserir(100);
        
        int expected = 10;
        int actual = lista.buscar(100);
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testBuscar5() {
        ListaOrdenada lista = new ListaOrdenada();
        
        lista.inserir(0);
        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);
        lista.inserir(40);
        lista.inserir(50);
        lista.inserir(60);
        lista.inserir(70);
        lista.inserir(80);
        lista.inserir(90);
        lista.inserir(100);
        
        int expected = -1;
        int actual = lista.buscar(85);
        
        assertEquals(expected, actual);
    }
    
}
