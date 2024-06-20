/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package furb.arvorebinaria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Bernardo Chiamolera
 */
public class ArvoreBinariaTest {
    
    public ArvoreBinariaTest() {
    }

    @Test
    public void testEstaVazia() {
        ArvoreBinaria arvore = new ArvoreBinaria();
        
        boolean expected = true;
        boolean actual = arvore.estaVazia();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testNaoEstaVazia() {
        ArvoreBinaria arvore = new ArvoreBinaria();
        
        NoArvoreBinaria noRaiz = new NoArvoreBinaria(5);
        
        arvore.setRaiz(noRaiz);
        
        boolean expected = false;
        boolean actual = arvore.estaVazia();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testToString() {
        ArvoreBinaria arvore = new ArvoreBinaria();
        
        NoArvoreBinaria no6 = new NoArvoreBinaria(6);
        NoArvoreBinaria no5 = new NoArvoreBinaria(5);
        NoArvoreBinaria no4 = new NoArvoreBinaria(4);
        NoArvoreBinaria no3 = new NoArvoreBinaria(3, no5, no6);
        NoArvoreBinaria no2 = new NoArvoreBinaria(2, null, no4);
        NoArvoreBinaria noRaiz = new NoArvoreBinaria(1, no2, no3);
        
        arvore.setRaiz(noRaiz);
        
        String expected = "<1<2<><4<><>>><3<5<><>><6<><>>>>";
        String actual = arvore.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testRaizPertence() {
        ArvoreBinaria arvore = new ArvoreBinaria();
        
        NoArvoreBinaria no6 = new NoArvoreBinaria(6);
        NoArvoreBinaria no5 = new NoArvoreBinaria(5);
        NoArvoreBinaria no4 = new NoArvoreBinaria(4);
        NoArvoreBinaria no3 = new NoArvoreBinaria(3, no5, no6);
        NoArvoreBinaria no2 = new NoArvoreBinaria(2, null, no4);
        NoArvoreBinaria noRaiz = new NoArvoreBinaria(1, no2, no3);
        
        arvore.setRaiz(noRaiz);
        
        boolean expected = true;
        boolean actual = arvore.pertence(1);
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testNoInternoPertence() {
        ArvoreBinaria arvore = new ArvoreBinaria();
        
        NoArvoreBinaria no6 = new NoArvoreBinaria(6);
        NoArvoreBinaria no5 = new NoArvoreBinaria(5);
        NoArvoreBinaria no4 = new NoArvoreBinaria(4);
        NoArvoreBinaria no3 = new NoArvoreBinaria(3, no5, no6);
        NoArvoreBinaria no2 = new NoArvoreBinaria(2, null, no4);
        NoArvoreBinaria noRaiz = new NoArvoreBinaria(1, no2, no3);
        
        arvore.setRaiz(noRaiz);
        
        boolean expected = true;
        boolean actual = arvore.pertence(3);
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testNoFolhaPertence() {
        ArvoreBinaria arvore = new ArvoreBinaria();
        
        NoArvoreBinaria no6 = new NoArvoreBinaria(6);
        NoArvoreBinaria no5 = new NoArvoreBinaria(5);
        NoArvoreBinaria no4 = new NoArvoreBinaria(4);
        NoArvoreBinaria no3 = new NoArvoreBinaria(3, no5, no6);
        NoArvoreBinaria no2 = new NoArvoreBinaria(2, null, no4);
        NoArvoreBinaria noRaiz = new NoArvoreBinaria(1, no2, no3);
        
        arvore.setRaiz(noRaiz);
        
        boolean expected = true;
        boolean actual = arvore.pertence(6);
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testNoNaoPertence() {
        ArvoreBinaria arvore = new ArvoreBinaria();
        
        NoArvoreBinaria no6 = new NoArvoreBinaria(6);
        NoArvoreBinaria no5 = new NoArvoreBinaria(5);
        NoArvoreBinaria no4 = new NoArvoreBinaria(4);
        NoArvoreBinaria no3 = new NoArvoreBinaria(3, no5, no6);
        NoArvoreBinaria no2 = new NoArvoreBinaria(2, null, no4);
        NoArvoreBinaria noRaiz = new NoArvoreBinaria(1, no2, no3);
        
        arvore.setRaiz(noRaiz);
        
        boolean expected = false;
        boolean actual = arvore.pertence(10);
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testContar() {
        ArvoreBinaria arvore = new ArvoreBinaria();
        
        NoArvoreBinaria no6 = new NoArvoreBinaria(6);
        NoArvoreBinaria no5 = new NoArvoreBinaria(5);
        NoArvoreBinaria no4 = new NoArvoreBinaria(4);
        NoArvoreBinaria no3 = new NoArvoreBinaria(3, no5, no6);
        NoArvoreBinaria no2 = new NoArvoreBinaria(2, null, no4);
        NoArvoreBinaria noRaiz = new NoArvoreBinaria(1, no2, no3);
        
        arvore.setRaiz(noRaiz);
        
        int expected = 6;
        int actual = arvore.contarNos();
        
        assertEquals(expected, actual);
    }
}
