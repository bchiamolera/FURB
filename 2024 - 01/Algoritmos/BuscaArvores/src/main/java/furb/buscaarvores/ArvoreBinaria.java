package furb.buscaarvores;

/**
 *
 * @author Bernardo Chiamolera
 */
public class ArvoreBinaria<T> extends ArvoreBinariaAbstract<T> {

    @Override
    public void setRaiz(NoArvoreBinaria<T> raiz) {
        super.setRaiz(raiz);
    }
    
    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        return this.buscar(this.getRaiz(), info);
    }
    
    private NoArvoreBinaria<T> buscar(NoArvoreBinaria<T> no, T info) {
        // Se o nó não existir, retorna null.
        if (no == null) {
            return null;
        }
        // Se o conteúdo do nó for igual à busca, retorna o nó.
        if (no.getInfo().equals(info)) {
            return no;
        }
        
        // Verifica recursivamente se o conteúdo do seu filho a esquerda corresponde à busca;
        // Caso não corresponda, o filho chamará o método novamente, até que se retorne um nó ou null.
        NoArvoreBinaria<T> resultEsquerda = this.buscar(no.getEsquerda(), info);
        if (resultEsquerda != null) {
            return resultEsquerda;
        }
        
        // Se nenhum dos filhos à esquerda corresponder à busca do nó atual, verifica-se o filho à direita.
        return this.buscar(no.getDireita(), info);
    }
    
}
