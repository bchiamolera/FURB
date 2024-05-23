/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package furb.lista2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Bernardo Chiamolera
 */
public class ListaEstaticaTest {
    
    public ListaEstaticaTest() {
    }

    @Test
    public void testInclusao() {
        ListaEstatica<Integer> lista = new ListaEstatica();
        
        String expected = "5,10,15,20";
        String actual;
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        actual = lista.toString();
        
        assertEquals(expected, actual, "Teste 1 deu ruim :(");
    }
    
    @Test
    public void testGetTamanho() {
        ListaEstatica<Integer> lista = new ListaEstatica();
        
        int expected = 4;
        int actual;
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        actual = lista.getTamanho();
        
        assertEquals(expected, actual, "Teste 2 deu ruim :(");
    }
    
    @Test
    public void testBuscar() {
        ListaEstatica<Integer> lista = new ListaEstatica();
        
        int expected = 2;
        int actual;
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        actual = lista.buscar(15);
        
        assertEquals(expected, actual, "Teste 3 deu ruim :(");
    }
    
    @Test
    public void testBuscarErro() {
        ListaEstatica<Integer> lista = new ListaEstatica();
        
        int expected = -1;
        int actual;
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        actual = lista.buscar(30);
        
        assertEquals(expected, actual, "Teste 4 deu ruim :(");
    }
    
    @Test
    public void testRetirar() {
        ListaEstatica<Integer> lista = new ListaEstatica();
        
        String expected1 = "5,10,15";
        String actual1;
        int expected2 = 3;
        int actual2;
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        lista.retirar(20);
        
        actual1 = lista.toString();
        actual2 = lista.getTamanho();
        
        assertEquals(expected1, actual1, "Teste 5.1 deu ruim :(");
        assertEquals(expected2, actual2, "Teste 5.2 deu ruim :(");
    }
    
    @Test
    public void testRedimensionar() {
        ListaEstatica<Integer> lista = new ListaEstatica();
        
        String expected1 = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15";
        String actual1;
        int expected2 = 15;
        int actual2;
        
        for (int i = 1; i <= 15; i++) {
            lista.inserir(i);
        }
        
        actual1 = lista.toString();
        actual2 = lista.getTamanho();
        
        assertEquals(expected1, actual1, "Teste 6.1 deu ruim :(");
        assertEquals(expected2, actual2, "Teste 6.2 deu ruim :(");
    }
    
    @Test
    public void testObterElemento() {
        ListaEstatica<Integer> lista = new ListaEstatica();
        
        int expected = 20;
        int actual;
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        actual = lista.obterElemento(3);
        
        assertEquals(expected, actual, "Teste 7 deu ruim :(");
    }
    
    @Test
    public void testObterElementoErro() {
        ListaEstatica<Integer> lista = new ListaEstatica();
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        try {
            lista.obterElemento(5);
            fail();
        } catch (IndexOutOfBoundsException e) {
            
        }
    }
    
    @Test
    public void testLiberar() {
        ListaEstatica<Integer> lista = new ListaEstatica();
        
        boolean expected = true;
        boolean actual;
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        lista.liberar();
        
        actual = lista.estaVazia();
        
        assertEquals(expected, actual, "Teste 9 deu ruim :(");
    }
    
    @Test
    public void testInverterPar() {
        ListaEstatica<Integer> lista = new ListaEstatica();
        
        String expected = "20,15,10,5";
        String actual;
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        lista.inverter();
        
        actual = lista.toString();
        
        assertEquals(expected, actual, "Teste 10 deu ruim :(");
    }
    
    @Test
    public void testInverterImpar() {
        ListaEstatica<Integer> lista = new ListaEstatica();
        
        String expected = "25,20,15,10,5";
        String actual;
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.inserir(25);
        
        lista.inverter();
        
        actual = lista.toString();
        
        assertEquals(expected, actual, "Teste 11 deu ruim :(");
    }
    
}
