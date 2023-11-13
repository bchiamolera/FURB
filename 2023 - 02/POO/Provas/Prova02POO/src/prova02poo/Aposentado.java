package prova02poo;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Aposentado extends Passageiro {
    // Atributos
    private String rg;

    // Construtor
    public Aposentado(String nome, String rg) {
        super(nome);
        setRg(rg);
    }

    // Getters e Setters
    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
    
    // Métodos
    @Override
    public String toString() {
        return super.toString() + "\nRG: " + this.getRg();
    }
}
