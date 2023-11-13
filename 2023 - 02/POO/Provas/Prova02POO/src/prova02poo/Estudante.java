package prova02poo;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Estudante extends Passageiro {
    // Atributos
    private String registroAcademico;

    // Construtor
    public Estudante(String nome, String registroAcademico) {
        super(nome);
        setRegistroAcademico(registroAcademico);
    }

    // Getters e Setters
    public String getRegistroAcademico() {
        return registroAcademico;
    }
    public void setRegistroAcademico(String registroAcademico) {
        this.registroAcademico = registroAcademico;
    }
    
    // Métodos
    @Override
    public String toString() {
        return super.toString() + "\nRegistro Acadêmico: " + this.getRegistroAcademico();
    }
}
