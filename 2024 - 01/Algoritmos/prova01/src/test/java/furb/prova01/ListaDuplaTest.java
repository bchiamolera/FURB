package furb.prova01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Bernardo Chiamolera
 */
public class ListaDuplaTest {
    
    public ListaDuplaTest() {
    }

    @Test
    public void testCriarSubLista() {
        ListaDupla<Integer> lista1 = new ListaDupla<>();
        
        lista1.inserir(70);
        lista1.inserir(60);
        lista1.inserir(50);
        lista1.inserir(40);
        lista1.inserir(30);
        lista1.inserir(20);
        lista1.inserir(10);
        
        ListaDupla<Integer> lista2;
        lista2 = lista1.criarSubLista(2, 5);
        
        String expected = "30,40,50,60";
        String actual = lista2.toString();
        
        assertEquals(expected, actual);
    }
    
    public void testCriarSubLista_1_elemento() {
        ListaDupla<Integer> lista1 = new ListaDupla<>();
        
        lista1.inserir(70);
        lista1.inserir(60);
        lista1.inserir(50);
        lista1.inserir(40);
        lista1.inserir(30);
        lista1.inserir(20);
        lista1.inserir(10);
        
        ListaDupla<Integer> lista2;
        lista2 = lista1.criarSubLista(0, 0);
        
        String expected = "10";
        String actual = lista2.toString();
        
        assertEquals(expected, actual);
    }
    
}
