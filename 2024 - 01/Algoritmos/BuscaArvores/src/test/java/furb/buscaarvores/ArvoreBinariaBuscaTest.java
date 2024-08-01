package furb.buscaarvores;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Bernardo Chiamolera
 */
public class ArvoreBinariaBuscaTest {
    
    public ArvoreBinariaBuscaTest() {
    }

    @Test
    public void testInserir() {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        
        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(40);
        arvore.inserir(25);
        arvore.inserir(75);
        arvore.inserir(65);
        arvore.inserir(35);
        arvore.inserir(60);
        
        String expected = "<50<30<25<><>><40<35<><>><>>><70<65<60<><>><>><75<><>>>>";
        String actual = arvore.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testRetirarFolha() {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        
        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(25);
        arvore.inserir(40);
        
        arvore.retirar(40);
        
        String expected = "<50<30<25<><>><>><>>";
        String actual = arvore.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testRetirarNoComUmFilho() {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        
        arvore.inserir(80);
        arvore.inserir(52);
        arvore.inserir(90);
        arvore.inserir(48);
        arvore.inserir(71);
        arvore.inserir(63);
        arvore.inserir(67);
        
        arvore.retirar(71);
        
        String expected = "<80<52<48<><>><63<><67<><>>>><90<><>>>";
        String actual = arvore.toString();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testRetirarNoComDoisFilhos() {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        
        arvore.inserir(250);
        arvore.inserir(38);
        arvore.inserir(26);
        arvore.inserir(72);
        arvore.inserir(55);
        arvore.inserir(90);
        arvore.inserir(41);
        arvore.inserir(60);
        arvore.inserir(43);
        arvore.inserir(78);
        arvore.inserir(92);
        arvore.inserir(74);
        
        arvore.retirar(38);
        
        String expected = "<250<41<26<><>><72<55<43<><>><60<><>>><90<78<74<><>><>><92<><>>>>><>>";
        String actual = arvore.toString();
        
        assertEquals(expected, actual);
    }
    
}
