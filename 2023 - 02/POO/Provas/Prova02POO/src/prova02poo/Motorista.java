package prova02poo;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Motorista extends Passageiro {
    // Atributos
    private String cnh;

    // Construtor
    public Motorista(String nome, String cnh) {
        super(nome);
        setCnh(cnh);
    }

    // Getters e Setters
    public String getCnh() {
        return cnh;
    }
    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
    
    // Métodos
    @Override
    public String toString() {
        return super.toString() + "\nCNH: " + this.getCnh();
    }
}
