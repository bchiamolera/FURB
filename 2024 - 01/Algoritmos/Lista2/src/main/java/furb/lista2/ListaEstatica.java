package furb.lista2;

/**
 *
 * @author Bernardo Chiamolera
 * @param <T>
 */
public class ListaEstatica<T> {
    
    private Object[] info;
    private int tamanho;

    public ListaEstatica() {
        this.info = (T[]) new Object[10];
        this.tamanho = 0;
    }
    
    private void redimensionar() {
       T[] tempLista = (T[]) this.info;
       this.info = (T[]) new Object[this.info.length + 10];
        
        for (int i = 0; i < tempLista.length; i++) {
            this.info[i] = tempLista[i];
        }
    }
    
    public void inserir(int valor) {
        this.tamanho++;
        if (this.tamanho > this.info.length) {
            redimensionar();
        }
        this.info[tamanho - 1] = valor;
    }
    
    public void exibir() {
        String retorno = "";
        for (int i = 0; i < this.tamanho; i++) {
            retorno += this.info[i] + " ";
        }
        System.out.println(retorno);
    }
    
    public int buscar(T valor) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.info[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }
    
    public void retirar (T valor) {
        
        int posicao = buscar(valor);
        
        for (int i = posicao; i < this.tamanho - 1; i++) {
            this.info[i] = this.info[i + 1];
        }
        tamanho--;
    }
    
    public void liberar() {
        this.info = (T[]) new Object[10];
        this.tamanho = 0;
    }
    
    public T obterElemento(int posicao) throws IndexOutOfBoundsException {
        if (posicao > tamanho) {
            throw new IndexOutOfBoundsException();
        }
        
        return (T) this.info[posicao];
        
    }
    
    public boolean estaVazia() {
        return tamanho == 0;
    }
    
    public int getTamanho() {
        return this.tamanho;
    }
    
    @Override
    public String toString() {
        String retorno = "";
        for (int i = 0; i < this.tamanho; i++) {
            if (i == tamanho - 1) {
                retorno += this.info[i];
            }
            else {
                retorno += this.info[i] + ",";
            }
        }
        return retorno;
    }
    
    public void inverter() {
        T lastItem;
        int lastIndex = tamanho - 1;
        
        for (int i = 0; i < lastIndex; i++) {
            lastItem = obterElemento(lastIndex);
            this.info[lastIndex] = obterElemento(i);
            this.info[i] = lastItem;
            lastIndex--;
        }
    }
}
