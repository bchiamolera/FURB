/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package furb.ordenacao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Bernardo Chiamolera
 */
public class OrdenadorTest {
    
    public OrdenadorTest() {
    }

    @Test
    public void testBubbleSort() {
        int[] lista = {9,2,4,1,0,8};
        Ordenador o = new Ordenador(lista);
        
        o.bubbleSort();
        
        int[] expected = {0,1,2,4,8,9};
        int[] actual = o.getInfo();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testQuickSort() {
        int[] lista = {9,2,4,1,0,8};
        Ordenador o = new Ordenador(lista);
        
        o.quickSort();
        
        int[] expected = {0,1,2,4,8,9};
        int[] actual = o.getInfo();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testMergeSort() {
        int[] lista = {9,2,4,1,0,8};
        Ordenador o = new Ordenador(lista);
        
        o.mergeSort();
        
        int[] expected = {0,1,2,4,8,9};
        int[] actual = o.getInfo();
        
        assertEquals(expected, actual);
    }
    
}
