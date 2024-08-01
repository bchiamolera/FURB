package furb.buscaarvores;

/**
 *
 * @author Bernardo Chiamolera
 */
public abstract class ArvoreBinariaAbstract<T> {
    private NoArvoreBinaria<T> raiz;
    
    public ArvoreBinariaAbstract() {
        this.raiz = null;
    }
    
    protected void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }
    
    public NoArvoreBinaria<T> getRaiz() {
        return this.raiz;
    }
    
    public boolean estaVazia() {
        return raiz == null;
    }
    
    public boolean pertence(T info) {
        return buscar(info).equals(null);
    }
    
    private boolean pertence(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return false;
        }
        return no.getInfo() == info || pertence(no.getEsquerda(), info) || pertence(no.getDireita(), info);
    }
    
    public abstract NoArvoreBinaria<T> buscar(T info);
    
    private String arvorePre(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        }
        return "<" + no.getInfo().toString() + arvorePre(no.getEsquerda()) + arvorePre(no.getDireita()) + ">";
    }
    
    @Override
    public String toString() {
        return arvorePre(raiz);
    }
    
    public int contarNos() {
        return contarNos(raiz);
    }
    
    private int contarNos(NoArvoreBinaria<T> no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNos(no.getEsquerda()) + contarNos(no.getDireita());
    }
    
    public int contarFolhas(NoArvoreBinaria<T> sa) {
        // Se a raíz da sub-árvore atual for nula, ou seja, ela não possui raiz, retorna 0 a contagem;
        if (sa == null) {
            return 0;
        }
        // Senão, verifica-se os filhos da raíz da sub-árvore atual.
        // Se ambos forem nulos, ou seja, a raíz não possuir filhos, ela é folha, logo, retorna 1.
        else if (sa.getDireita() == null && sa.getEsquerda() == null) {
            return 1;
        }
        
        // Senão, significa que a raíz da sub-árvore NÃO é nula e que pelo menos um de seus filhos também NÃO é nulo,
        // logo, ela não é folha. Então verifica-se se seus filhos são folhas;
        return (contarFolhas(sa.getEsquerda()) + contarFolhas(sa.getDireita()));
    }
}
