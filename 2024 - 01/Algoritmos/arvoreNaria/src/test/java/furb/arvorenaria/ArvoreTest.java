/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package furb.arvorenaria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Bernardo Chiamolera
 */
public class ArvoreTest {
    
    public ArvoreTest() {
    }

    @Test
    public void testToString() {
        Arvore arvore = new Arvore();
        
        NoArvore no7 = new NoArvore(7);
        NoArvore no6 = new NoArvore(6);
        NoArvore no5 = new NoArvore(5);
        
        NoArvore no2 = new NoArvore(2);
        no2.inserirFilho(no7);
        no2.inserirFilho(no6);
        no2.inserirFilho(no5);
        
        NoArvore no8 = new NoArvore(8);
        
        NoArvore no3 = new NoArvore(3);
        no3.inserirFilho(no8);
        
        NoArvore no10 = new NoArvore(10);
        NoArvore no9 = new NoArvore(9);
        
        NoArvore no4 = new NoArvore(4);
        no4.inserirFilho(no10);
        no4.inserirFilho(no9);
        
        NoArvore no1 = new NoArvore(1);
        no1.inserirFilho(no4);
        no1.inserirFilho(no3);
        no1.inserirFilho(no2);
        
        arvore.setRaiz(no1);
        
        String expected = "<1<2<5><6><7>><3<8>><4<9><10>>>";
        String actual = arvore.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testPertence() {
        Arvore arvore = new Arvore();
        
        NoArvore no7 = new NoArvore(7);
        NoArvore no6 = new NoArvore(6);
        NoArvore no5 = new NoArvore(5);
        
        NoArvore no2 = new NoArvore(2);
        no2.inserirFilho(no7);
        no2.inserirFilho(no6);
        no2.inserirFilho(no5);
        
        NoArvore no8 = new NoArvore(8);
        
        NoArvore no3 = new NoArvore(3);
        no3.inserirFilho(no8);
        
        NoArvore no10 = new NoArvore(10);
        NoArvore no9 = new NoArvore(9);
        
        NoArvore no4 = new NoArvore(4);
        no4.inserirFilho(no10);
        no4.inserirFilho(no9);
        
        NoArvore no1 = new NoArvore(1);
        no1.inserirFilho(no4);
        no1.inserirFilho(no3);
        no1.inserirFilho(no2);
        
        arvore.setRaiz(no1);
        
        boolean expected = true;
        boolean actual = arvore.pertence(7);
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testNaoPertence() {
        Arvore arvore = new Arvore();
        
        NoArvore no7 = new NoArvore(7);
        NoArvore no6 = new NoArvore(6);
        NoArvore no5 = new NoArvore(5);
        
        NoArvore no2 = new NoArvore(2);
        no2.inserirFilho(no7);
        no2.inserirFilho(no6);
        no2.inserirFilho(no5);
        
        NoArvore no8 = new NoArvore(8);
        
        NoArvore no3 = new NoArvore(3);
        no3.inserirFilho(no8);
        
        NoArvore no10 = new NoArvore(10);
        NoArvore no9 = new NoArvore(9);
        
        NoArvore no4 = new NoArvore(4);
        no4.inserirFilho(no10);
        no4.inserirFilho(no9);
        
        NoArvore no1 = new NoArvore(1);
        no1.inserirFilho(no4);
        no1.inserirFilho(no3);
        no1.inserirFilho(no2);
        
        arvore.setRaiz(no1);
        
        boolean expected = false;
        boolean actual = arvore.pertence(55);
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testContarNos() {
        Arvore arvore = new Arvore();
        
        NoArvore no7 = new NoArvore(7);
        NoArvore no6 = new NoArvore(6);
        NoArvore no5 = new NoArvore(5);
        
        NoArvore no2 = new NoArvore(2);
        no2.inserirFilho(no7);
        no2.inserirFilho(no6);
        no2.inserirFilho(no5);
        
        NoArvore no8 = new NoArvore(8);
        
        NoArvore no3 = new NoArvore(3);
        no3.inserirFilho(no8);
        
        NoArvore no10 = new NoArvore(10);
        NoArvore no9 = new NoArvore(9);
        
        NoArvore no4 = new NoArvore(4);
        no4.inserirFilho(no10);
        no4.inserirFilho(no9);
        
        NoArvore no1 = new NoArvore(1);
        no1.inserirFilho(no4);
        no1.inserirFilho(no3);
        no1.inserirFilho(no2);
        
        arvore.setRaiz(no1);
        
        int expected = 10;
        int actual = arvore.ContarNos();
        
        assertEquals(expected, actual);
    }
    
}
