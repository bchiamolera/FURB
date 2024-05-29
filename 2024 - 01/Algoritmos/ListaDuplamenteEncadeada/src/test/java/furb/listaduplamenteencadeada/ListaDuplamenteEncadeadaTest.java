/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package furb.listaduplamenteencadeada;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Bernardo Chiamolera
 */
public class ListaDuplamenteEncadeadaTest {
    
    public ListaDuplamenteEncadeadaTest() {
    }

    @Test
    public void testInserir() {
        ListaDuplamenteEncadeada<Integer> lista = new ListaDuplamenteEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        String expected1 = "20,15,10,5";
        String expected2 = "5,10,15,20";
        
        String actual1 = lista.toString();
        String actual2 = lista.exibirOrdemInversa();
        
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    public void testBuscarInicio() {
        ListaDuplamenteEncadeada<Integer> lista = new ListaDuplamenteEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        int expected = 20;
        int actual = lista.buscar(20).getInfo();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testBuscarMeio() {
        ListaDuplamenteEncadeada<Integer> lista = new ListaDuplamenteEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        int expected = 10;
        int actual = lista.buscar(10).getInfo();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testRetirarInicio() {
        ListaDuplamenteEncadeada<Integer> lista = new ListaDuplamenteEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        lista.retirar(20);
        
        String expected1 = "15,10,5";
        String actual1 = lista.toString();
        
        String expected2 = "5,10,15";
        String actual2 = lista.exibirOrdemInversa();
        
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }
    
    @Test
    public void testRetirarMeio() {
        ListaDuplamenteEncadeada<Integer> lista = new ListaDuplamenteEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
                
        lista.retirar(10);
        
        String expected1 = "20,15,5";
        String actual1 = lista.toString();

        String expected2 = "5,15,20";
        String actual2 = lista.exibirOrdemInversa();
        
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    public void testRetirarFim() {
        ListaDuplamenteEncadeada<Integer> lista = new ListaDuplamenteEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        lista.retirar(5);
        
        String expected1 = "20,15,10";
        String actual1 = lista.toString();
        
        String expected2 = "10,15,20";
        String actual2 = lista.exibirOrdemInversa();
        
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    public void testLiberar() {
        ListaDuplamenteEncadeada<Integer> lista = new ListaDuplamenteEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        NoListaDupla no1 = lista.getPrimeiro();
        NoListaDupla no2 = lista.getPrimeiro().getProximo();
        NoListaDupla no3 = lista.getPrimeiro().getProximo().getProximo();
        NoListaDupla no4 = lista.getPrimeiro().getProximo().getProximo().getProximo();
        
        lista.liberar();
        
        NoListaDupla expectedProxNo1 = null;
        NoListaDupla actualProxNo1 = no1.getProximo();
        
        NoListaDupla expectedProxNo2 = null;
        NoListaDupla actualProxNo2 = no2.getProximo();
        NoListaDupla expectedAntNo2 = null;
        NoListaDupla actualAntNo2 = no2.getAnterior();
        
        NoListaDupla expectedProxNo3 = null;
        NoListaDupla actualProxNo3 = no3.getProximo();
        NoListaDupla expectedAntNo3 = null;
        NoListaDupla actualAntNo3 = no3.getAnterior();
        
        NoListaDupla expectedAntNo4 = null;
        NoListaDupla actualAntNo4 = no4.getAnterior();

        
        assertEquals(expectedProxNo1, actualProxNo1, "1");
        
        assertEquals(expectedProxNo2, actualProxNo2);
        assertEquals(expectedAntNo2, actualAntNo2);
        
        assertEquals(expectedProxNo3, actualProxNo3);
        assertEquals(expectedAntNo3, actualAntNo3);

        assertEquals(expectedAntNo4, actualAntNo4);
    }
    
}
