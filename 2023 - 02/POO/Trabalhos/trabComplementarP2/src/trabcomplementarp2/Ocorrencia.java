package trabcomplementarp2;

// Bernardo Chiamolera e Ricardo Sasse

public class Ocorrencia {
    // Atributos
    private int sexo;
    private int estadoCivil;

    // Construtor
    public Ocorrencia(int sexo, int estadoCivil) {
        setSexo(sexo);
        setEstadoCivil(estadoCivil);
    }    
    
    // Getters e Setters
    public int getSexo() {
        return sexo;
    }
    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public int getEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(int estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
}
