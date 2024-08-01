/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package furb.ordenacaootimizada;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Bernardo Chiamolera
 */
public class OrdenacaoAbstractTest {
    
    public OrdenacaoAbstractTest() {
    }

    @org.junit.jupiter.api.Test
    public void testBolha() {
        Integer[] lista = {70,2,88,15,90,30};
        
        OrdenacaoBolha ordenador = new OrdenacaoBolha();
        ordenador.setInfo(lista);
        
        ordenador.ordenar();
        
        Integer[] expected = {2,15,30,70,88,90};
        var actual = ordenador.getInfo();
        
        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void testBolhaOtimizado() {
        Integer[] lista = {70,2,88,15,90,30};
        
        OrdenacaoBolhaOtimizada ordenador = new OrdenacaoBolhaOtimizada();
        ordenador.setInfo(lista);
        
        ordenador.ordenar();
        
        Integer[] expected = {2,15,30,70,88,90};
        var actual = ordenador.getInfo();
        
        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void testQuickSort() {
        Integer[] lista = {70,2,88,15,90,30};
        
        OrdenacaoQuickSort ordenador = new OrdenacaoQuickSort();
        ordenador.setInfo(lista);
        
        ordenador.ordenar();
        
        Integer[] expected = {2,15,30,70,88,90};
        var actual = ordenador.getInfo();
        
        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void testMergeSort() {
        Integer[] lista = {70,2,88,15,90,30};
        
        OrdenacaoMergeSort ordenador = new OrdenacaoMergeSort();
        ordenador.setInfo(lista);
        
        ordenador.ordenar();
        
        Integer[] expected = {2,15,30,70,88,90};
        var actual = ordenador.getInfo();
        
        assertArrayEquals(expected, actual);
    }
    
}
