/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package furb.listacircular;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Bernardo Chiamolera
 */
public class ListaCircularTest {
    
    public ListaCircularTest() {
    }

    @Test
    public void testInserir() {
        ListaCircular<Integer> lista = new ListaCircular<>();
        
        lista.inserir(5);
        
        String expected = "5";
        String actual = lista.toString();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testInserir2() {
        ListaCircular<Integer> lista = new ListaCircular<>();
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        String expected = "20,15,10,5";
        String actual = lista.toString();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testUltimo() {
        ListaCircular<Integer> lista = new ListaCircular<>();
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        int expected = 20;
        int actual = lista.getUltimo().getProximo().getInfo();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testBuscar() {
        ListaCircular<Integer> lista = new ListaCircular<>();
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        int expected = 10;
        int actual = lista.buscar(10).getInfo();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testBuscar2() {
        ListaCircular<Integer> lista = new ListaCircular<>();
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        NoLista<Integer> expected = null;
        NoLista<Integer> actual = lista.buscar(30);
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testRetirarInicio() {
        ListaCircular<Integer> lista = new ListaCircular<>();
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        lista.retirar(20);
        
        String expected = "15,10,5";
        String actual = lista.toString();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testRetirarMeio() {
        ListaCircular<Integer> lista = new ListaCircular<>();
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        lista.retirar(10);
        
        String expected = "20,15,5";
        String actual = lista.toString();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testRetirarFim() {
        ListaCircular<Integer> lista = new ListaCircular<>();
        
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        lista.retirar(5);
        
        String expected = "20,15,10";
        String actual = lista.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testLiberar() {
        ListaCircular<Integer> lista = new ListaCircular<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        NoLista no1 = lista.getPrimeiro();
        NoLista no2 = lista.getPrimeiro().getProximo();
        NoLista no3 = lista.getPrimeiro().getProximo().getProximo();
        NoLista no4 = lista.getPrimeiro().getProximo().getProximo().getProximo();
        
        lista.liberar();
        
        NoLista expectedProxNo1 = null;
        NoLista actualProxNo1 = no1.getProximo();
        
        NoLista expectedProxNo2 = null;
        NoLista actualProxNo2 = no2.getProximo();
        
        NoLista expectedProxNo3 = null;
        NoLista actualProxNo3 = no3.getProximo();
        
        NoLista expectedAntNo4 = null;
        NoLista actualAntNo4 = no4.getProximo();

        
        assertEquals(expectedProxNo1, actualProxNo1);
        
        assertEquals(expectedProxNo2, actualProxNo2);
        
        assertEquals(expectedProxNo3, actualProxNo3);

        assertEquals(expectedAntNo4, actualAntNo4);
    }
    
}
