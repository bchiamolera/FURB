package preparativoprova;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Medico extends Pessoa {
    // Atributos
    private String crm;
    private String especialidade;
    
    // Construtor
    public Medico(String nome, String crm, String especialidade) {
        super(nome);
        setCrm(crm);
        setEspecialidade(especialidade);
    }

    // Getters e Setters
    public String getCrm() {
        return crm;
    }
    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    // Métodos
    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\nCRM: " + this.getCrm() + "\nEspecialidade: " + this.getEspecialidade();
    }
    
}
