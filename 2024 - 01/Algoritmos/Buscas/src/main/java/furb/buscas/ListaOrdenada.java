package furb.buscas;

/**
 *
 * @author Bernardo Chiamolera
 */
public class ListaOrdenada<T extends Comparable<T>> extends ListaAbstract<T>{
    
    @Override
    public void inserir(T valor) {
        Object[] _info = this.getInfo();
        int _tamanho = this.getTamanho();
        
        if (_tamanho >= _info.length) {
            redimensionar();
            _info = this.getInfo();
        }
        
        int inicio = 0;
        int fim = _tamanho - 1;
        
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            int comparacao = valor.compareTo((T) _info[meio]);
            
            if (comparacao < 0) {
                fim = meio - 1;
            }
            else if (comparacao > 0) {
                inicio = meio + 1;
            } else {
                inicio = meio;
                break;
            }
        }
        
        for (int i = _tamanho; i > inicio; i--) {
            _info[i] = _info [i - 1];
        }
        
        _info[inicio] = valor;
        this.setTamanho(_tamanho + 1);
    }

    @Override
    public int buscar(T valor) {
        Object[] _info = this.getInfo();
        int _tamanho = this.getTamanho();
        
        int inicio = 0;
        int fim = _tamanho - 1;
        
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            int comparacao = valor.compareTo((T) _info[meio]);
            
            if (comparacao < 0) {
                fim = meio - 1;
            }
            else if (comparacao > 0) {
                inicio = meio + 1;
            } else {
                return meio;
            }
        }
        return -1;
    }
    
}
