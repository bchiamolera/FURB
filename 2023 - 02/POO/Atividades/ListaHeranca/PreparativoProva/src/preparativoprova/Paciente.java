package preparativoprova;

import java.util.ArrayList;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Paciente extends Pessoa {
    // Atributos
    private Plano plano;
    
    // Construtor
    public Paciente(String nome, Plano plano) {
        super(nome);
        setPlano(plano);
    }

    // Getters e Setters
    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }
    
    // Métodos
    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\nPlano: " + this.getPlano();
    }
    
}
