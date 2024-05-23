package furb.lista2;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Lista2 {

    public static void main(String[] args) {
        ListaEstatica<Integer> lista = new ListaEstatica();
        
        lista.inserir(0);
        lista.inserir(1);
        lista.inserir(2);
        lista.exibir();
        
        lista.inverter();
        lista.exibir();
    }
}
