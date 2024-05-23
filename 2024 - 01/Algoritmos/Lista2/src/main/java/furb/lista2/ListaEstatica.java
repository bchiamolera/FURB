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
       Object[] tempLista = this.info;
        
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
            retorno += this.info[i] + "\n";
        }
        System.out.println(retorno);
    }
    
    public int buscar(T valor) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.info[i] == valor) {
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
        for (int i = 0; i < this.tamanho; i++) {
            if (this.info[i] != null) {
                return false;
            }
        }
        return true;
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
            lastItem = (T) this.info[lastIndex];
            this.info[lastIndex] = this.info[i];
            this.info[i] = lastItem;
            lastIndex--;
        }
    }
}
