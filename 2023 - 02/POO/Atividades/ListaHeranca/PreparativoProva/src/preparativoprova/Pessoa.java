package preparativoprova;

/**
 *
 * @author Bernardo Chiamolera
 */
public abstract class Pessoa {
    // Atributos
    private String nome;

    // Construtor
    public Pessoa(String nome) {
        setNome(nome);
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    // Métodos
    @Override
    public abstract String toString();
}
