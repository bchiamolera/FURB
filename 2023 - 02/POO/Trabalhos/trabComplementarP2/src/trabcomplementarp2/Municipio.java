package trabcomplementarp2;

// Bernardo Chiamolera e Ricardo Sasse

public class Municipio {
    // Atributos
    private int codigoIbge;
    private String nome;
    private String estado;
    private int populacao;

    // Construtor
    public Municipio(int codigoIbge, String nome, String estado, int populacao) {
        setCodigoIbge(codigoIbge);
        setNome(nome);
        setEstado(estado);
        setPopulacao(populacao);
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPopulacao() {
        return populacao;
    }
    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public int getCodigoIbge() {
        return codigoIbge;
    }
    public void setCodigoIbge(int codigoIbge) {
        this.codigoIbge = codigoIbge;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    // Métodos
    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\nPopulação: " + this.getPopulacao();
    }
}
