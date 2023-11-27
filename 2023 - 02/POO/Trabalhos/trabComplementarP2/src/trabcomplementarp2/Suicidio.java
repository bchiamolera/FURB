package trabcomplementarp2;

// Bernardo Chiamolera e Ricardo Sasse

import java.util.ArrayList;

public class Suicidio {
    // Atributos
    private int codMunicipio;
    private ArrayList<Ocorrencia> ocorrencias;

    // Construtor
    public Suicidio(int codMunicipio) {
        setCodMunicipio(codMunicipio);
        ocorrencias = new ArrayList<>();
    }

    // Getters e Setters
    public int getCodMunicipio() {
        return codMunicipio;
    }
    public void setCodMunicipio(int codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public ArrayList<Ocorrencia> getOcorrencias() {
        return ocorrencias;
    }
    public void setOcorrencias(ArrayList<Ocorrencia> ocorrencias) {
        this.ocorrencias = ocorrencias;
    }
    
    
 
    // Métodos
    public void addOcorrencia(Ocorrencia ocorrencia) {
        ocorrencias.add(ocorrencia);
    }
}
