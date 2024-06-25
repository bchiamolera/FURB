/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package furb.mapadispersao;

import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Bernardo Chiamolera
 */
public class MapaDispersaoTest {
    
    public MapaDispersaoTest() {
    }

    @Test
    public void testInserirOne() {
        MapaDispersao mapa = new MapaDispersao(53);
        
        Aluno obj1 = new Aluno(12000,"Jean", LocalDate.of(2000, Month.JANUARY, 1));
        
        mapa.inserir(obj1.getMatricula(), obj1);
        
        Aluno expected = obj1;
        Aluno actual = (Aluno) mapa.buscar(12000);
        
        assertEquals(expected, actual);
    }

    @Test
    public void testInserirMore() {
        MapaDispersao mapa = new MapaDispersao(53);
        
        Aluno obj1 = new Aluno(12000,"Jean", LocalDate.of(2000, Month.JANUARY, 1));
        mapa.inserir(obj1.getMatricula(), obj1);
        
        Aluno obj2 = new Aluno(14000,"Pedro", LocalDate.of(1999, Month.JANUARY, 20));
        mapa.inserir(obj2.getMatricula(), obj2);
        
        Aluno obj3 = new Aluno(12500,"Marta", LocalDate.of(2001, Month.FEBRUARY, 18));
        mapa.inserir(obj3.getMatricula(), obj3);
        
        Aluno obj4 = new Aluno(13000,"Lucas", LocalDate.of(1998, Month.NOVEMBER, 25));
        mapa.inserir(obj4.getMatricula(), obj4);
        
        Aluno expected1 = obj1;
        Aluno actual1 = (Aluno) mapa.buscar(12000);
        
        Aluno expected2 = obj2;
        Aluno actual2 = (Aluno) mapa.buscar(14000);
        
        Aluno expected3 = obj3;
        Aluno actual3 = (Aluno) mapa.buscar(12500);
        
        Aluno expected4 = obj4;
        Aluno actual4 = (Aluno) mapa.buscar(13000);
        
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @Test
    public void testInserirColission() {
        MapaDispersao mapa = new MapaDispersao(53);
        
        Aluno obj1 = new Aluno(12000,"Jean", LocalDate.of(2000, Month.JANUARY, 1));
        mapa.inserir(obj1.getMatricula(), obj1);
        
        Aluno obj2 = new Aluno(14000,"Pedro", LocalDate.of(1999, Month.JANUARY, 20));
        mapa.inserir(obj2.getMatricula(), obj2);
        
        Aluno obj3 = new Aluno(14226,"Marta", LocalDate.of(2001, Month.FEBRUARY, 18));
        mapa.inserir(obj3.getMatricula(), obj3);
        
        Aluno obj4 = new Aluno(17180,"Lucas", LocalDate.of(1998, Month.NOVEMBER, 25));
        mapa.inserir(obj4.getMatricula(), obj4);
        
        Aluno expected1 = obj1;
        Aluno actual1 = (Aluno) mapa.buscar(12000);
        
        Aluno expected2 = obj2;
        Aluno actual2 = (Aluno) mapa.buscar(14000);
        
        Aluno expected3 = obj3;
        Aluno actual3 = (Aluno) mapa.buscar(14226);
        
        Aluno expected4 = obj4;
        Aluno actual4 = (Aluno) mapa.buscar(17180);
        
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }
    
    
    @Test
    public void testInserirRemover() {
        MapaDispersao mapa = new MapaDispersao(53);
        
        Aluno obj1 = new Aluno(12000,"Jean", LocalDate.of(2000, Month.JANUARY, 1));
        
        mapa.inserir(obj1.getMatricula(), obj1);
        mapa.remover(12000);
        
        
        Aluno expected = null;
        Aluno actual = (Aluno) mapa.buscar(12000);
        
        assertEquals(expected, actual);
    }
}
