package furb.trab_estrutura_dados;

public class ListaEncadeada<T> {

    private NoLista<T> primeiro;

    public ListaEncadeada() {
        this.primeiro = null;
    }

    public NoLista<T> getPrimeiro() {
        return this.primeiro;
    }

    public void inserir(T info) {
        NoLista<T> novoNo = new NoLista<T>();
        novoNo.setInfo(info);
        novoNo.setProximo(this.primeiro);
        this.primeiro = novoNo;
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public NoLista<T> buscar(T info) {
        NoLista<T> no = getPrimeiro();
        while (no != null) {
            if (no.getInfo().equals(info)) {
                return no;
            }
            no = no.getProximo();
        }
        return null;
    }

    public void retirar(T info) {
        if (primeiro.getInfo() == info) {
            primeiro = primeiro.getProximo();
            return;
        }
        NoLista<T> no = primeiro;
        while (no != null) {
            NoLista<T> proximo = no.getProximo();
            if (proximo != null) {
                if (proximo.getInfo() == info) {
                    no.setProximo(proximo.getProximo());
                }
            }
            no = no.getProximo();
        }
    }

    public int obterComprimento() {
        NoLista<T> no = getPrimeiro();
        int tamanho = 0;
        while (no != null) {
            tamanho++;
            no = no.getProximo();
        }
        return tamanho;
    }

    public NoLista<T> obterNo(int idx) {
        NoLista<T> no = primeiro;
        int posicao = 0;
        while (no != null) {
            if (posicao == idx) {
                return no;
            }
            posicao++;
            no = no.getProximo();
        }
        throw new IndexOutOfBoundsException();
    }

    // Método para liberar a memória dos nós da lista
    public void liberar() {
        NoLista<T> atual = primeiro;

        while (atual != null) {
            NoLista<T> proximo = atual.getProximo();
            atual.setProximo(null);
            atual = proximo;
        }

        primeiro = null;
    }

    @Override
    public String toString() {
        String r = "";
        if (!estaVazia()) {
            NoLista<T> currentNo = primeiro;
            while (currentNo.getProximo() != null) {
                r += (String) currentNo.getInfo().toString() + ",";
                currentNo = currentNo.getProximo();
            }
            r += (String) currentNo.getInfo().toString();
        }
        return r;
    }
}
