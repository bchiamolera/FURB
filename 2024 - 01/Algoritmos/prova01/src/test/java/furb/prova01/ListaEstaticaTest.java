package furb.prova01;

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
    public void testInserir_index_meio() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();
        
        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);
        lista.inserir(40);
        lista.inserir(50);
        
        lista.inserir(2, 99);
        
        String expected = "10,20,99,30,40,50";
        String actual = lista.toString();
        
        assertEquals(expected, actual);
    }
    @Test
    public void testInserir_index_comeco() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();
        
        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);
        lista.inserir(40);
        lista.inserir(50);
        
        lista.inserir(0, 99);
        
        String expected = "99,10,20,30,40,50";
        String actual = lista.toString();
        
        assertEquals(expected, actual);
    }
    @Test
    public void testInserir_index_fim() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();
        
        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);
        lista.inserir(40);
        lista.inserir(50);
        
        lista.inserir(4, 99);
        
        String expected = "10,20,30,40,99,50";
        String actual = lista.toString();
        
        assertEquals(expected, actual);
    }
    @Test
    public void testInserir_index_redimensionar() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();
        
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
        
        lista.inserir(2, 99);
        
        String expected = "10,20,99,30,40,50,60,70,80,90,100";
        String actual = lista.toString();
        
        assertEquals(expected, actual);
    }
    
}
