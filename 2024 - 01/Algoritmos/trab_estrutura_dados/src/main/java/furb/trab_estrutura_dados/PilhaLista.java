package furb.trab_estrutura_dados;

public class PilhaLista<T> implements Pilha<T> {

    private ListaEncadeada<T> listaPilha;

    @SuppressWarnings("unchecked")
    public PilhaLista() {
        this.listaPilha = new ListaEncadeada();
    }

    @Override
    public void push(T info) {
        this.listaPilha.inserir(info);
    }

    @Override
    public T pop() throws PilhaVaziaException {
        if (listaPilha.estaVazia()) {
            throw new PilhaVaziaException();
        }

        T valor = peek();
        this.listaPilha.retirar(valor);

        return valor;
    }

    @Override
    public T peek() throws PilhaVaziaException {
        if (listaPilha.estaVazia()) {
            throw new PilhaVaziaException();
        }
        return this.listaPilha.getPrimeiro().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return this.listaPilha.estaVazia();
    }

    @Override
    public void liberar() throws PilhaVaziaException {
        while (!this.estaVazia()) {
            this.pop();
        }
    }

    public ListaEncadeada<T> getLista() {
        return this.listaPilha;
    }
}
