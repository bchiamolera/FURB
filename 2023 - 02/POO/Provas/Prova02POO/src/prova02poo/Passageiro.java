package prova02poo;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Passageiro {
    // Atributos
    private String nome;

    // Construtor
    public Passageiro(String nome) {
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
    public String toString() {
        return "Nome: " + this.getNome();
    }
}
