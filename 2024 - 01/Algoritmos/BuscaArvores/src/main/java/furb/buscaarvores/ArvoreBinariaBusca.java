package furb.buscaarvores;

/**
 *
 * @author Bernardo Chiamolera
 */
public class ArvoreBinariaBusca<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    public void inserir(T info) {
        NoArvoreBinaria<T> novo = new NoArvoreBinaria(info);
        
        // Verifica se a árvore não possui raíz
        if (this.getRaiz() == null) {
            this.setRaiz(novo);
        }
        else {
            NoArvoreBinaria<T> p = this.getRaiz();
            // Loop até achar uma posição vazia
            while (true) {
                NoArvoreBinaria<T> pai = p;
                
                int comparacao = info.compareTo(p.getInfo());
                // Se a info for menor que a raíz atual, move-se para a esquerda;
                if (comparacao < 0) {
                    p = pai.getEsquerda();
                    // Se estiver vazio, insere o número e finaliza o método.
                    if (p == null) {
                        pai.setEsquerda(novo);
                        return;
                    }
                }
                // Se a info for maior ou igual que a raíz atual, move-se para a direita;
                else {
                    p = pai.getDireita();
                    // Se estiver vazio, insere o número e finaliza o método.
                    if (p == null) {
                        pai.setDireita(novo);
                        return;
                    }
                }
            }
        }
    }
    
    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        NoArvoreBinaria<T> p = this.getRaiz();
        
        // percorre-se a árvore até achar o valor ou chegar ao fim da árvore (p == null);
        while (p != null && !p.getInfo().equals(info)) {
            int comparacao = info.compareTo(p.getInfo());
            // Caso o valor seja menor, verifica o nó à esquerda
            if (comparacao < 0) {
                p = p.getEsquerda();
            }
            // Caso o valor seja maior, verifica o nó à direita
            else if (comparacao < 0){
                p = p.getDireita();
            }
        }
        // retorna null se o valor não for encontrado, visto que percorreu-se a árvore inteira.
        return p;
    }
    
    private NoArvoreBinaria<T> extrairSucessor(NoArvoreBinaria<T> excluir) {
        // Pega o primeiro nó a direita do nó que se quer excluir
        NoArvoreBinaria<T> atual = excluir.getDireita();
        NoArvoreBinaria<T> paiSucessor = excluir;
        NoArvoreBinaria<T> sucessor = excluir;
        
        // Procura-se pelo último nó à esquerda;
        while (atual != null) {
            paiSucessor = sucessor;
            sucessor = atual;
            atual = atual.getEsquerda();
        }
        
        // Se o sucessor não for o nó imediatamente à direita do nó que se quer excluir
        // move-se o filho à direita do sucessor ao antigo lugar do sucessor
        // e os filhos à direita do nó a ser excluído passam a ser do sucessor
        if (sucessor != excluir.getDireita()) {
            paiSucessor.setEsquerda(sucessor.getDireita());
            sucessor.setDireita(excluir.getDireita());
        }
        
        return sucessor;
    }
    
    public void retirar(T info) {
        NoArvoreBinaria<T> p = this.getRaiz();
        NoArvoreBinaria<T> pai = null;
        
        boolean filhoEsquerda = false;
        
        // procura por p.
        while (p != null && !p.getInfo().equals(info)) {
            pai = p;
            
            int comparacao = info.compareTo(p.getInfo());
            // Se o valor de p for menor que o valor procurado, p move para o filho da esquerda.
            if (comparacao < 0) {
                filhoEsquerda = true;
                p = p.getEsquerda();
            }
            // Senão, move pro da direita.
            else {
                filhoEsquerda = false;
                p = p.getDireita();
            }
        }
        
        // se p existe:
        if (p != null) {
            // Se p é folha:
            if (p.getEsquerda() == null && p.getDireita() == null) {
                // Verifica se p é raiz.
                if (p == this.getRaiz()) {
                    this.setRaiz(null);
                }
                else {
                    // Se p for o filho à esquerda do pai, zera a esquerda do seu pai.
                    if (filhoEsquerda) {
                        pai.setEsquerda(null);
                    }
                    // Senão, zera o filho à direita.
                    else {
                        pai.setDireita(null);
                    }
                }
            }
            // Se p não é folha:
            else {
                // Verifica se p não tem um filho na direita.
                if (p.getDireita() == null) {
                    // Verifica se p é raíz, define seu filho da esquerda como a nova raíz.
                    if (p == this.getRaiz()) {
                        this.setRaiz(p.getEsquerda());
                    }
                    else {
                        // Se p for o filho à esquerda do pai, define o filho à esquerda de p como o novo filho à esquerda do pai
                        if (filhoEsquerda) {
                            pai.setEsquerda(p.getEsquerda());
                        }
                        // Senão, p é filho à direita do pai, logo, difine o filho à esquerda de p como o filho à direita do pai.
                        else {
                            pai.setDireita(p.getEsquerda());
                        }
                    }
                }
                // Senão, verifica se p não tem um filho na esquerda.
                else if (p.getEsquerda() == null) {
                    // Verifica se p é raíz, define seu filho da direita como a nova raíz.
                    if (p == this.getRaiz()) {
                        this.setRaiz(p.getDireita());
                    }
                    else {
                        // Se p for o filho à esquerda do pai, define o filho à direita de p como o novo filho à esquerda do pai
                        if (filhoEsquerda) {
                            pai.setEsquerda(p.getDireita());
                        }
                        // Senão, p é filho à direita do pai, logo, difine o filho à direita de p como o filho à direita do pai.
                        else {
                            pai.setDireita(p.getDireita());
                        }
                    }
                }
                // Senão, p tem 2 filhos.
                else {
                    NoArvoreBinaria sucessor = extrairSucessor(p);
                    
                    // Verifica se p é raíz.
                    if (p == this.getRaiz()) {
                        this.setRaiz(sucessor);
                    }
                    // Se p não for raíz:
                    else {
                        // Se p for o filho à esquerda do pai, define o sucessor como filho à esquerda do pai
                        if (filhoEsquerda) {
                            pai.setEsquerda(sucessor);
                        // Se p for o filho à direita do pai, define o sucessor como filho à direita do pai
                        } else {
                            pai.setDireita(sucessor);
                        }
                    }
                    
                    // Define o filho à esquerda de p como o filho à esquerda do sucessor
                    sucessor.setEsquerda(p.getEsquerda());
                }
            }
            
        }
    }
    
}
