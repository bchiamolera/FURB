package prova03_bernardochiamolera;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Acidente {
    private String tipoVeiculo;
    private int numAcidentes;
    private String estadoCivil;

    public Acidente(String tipoVeiculo, int numAcidentes, String estadoCivil) {
        setTipoVeiculo(tipoVeiculo);
        setNumAcidentes(numAcidentes);
        setEstadoCivil(estadoCivil);
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }
    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public int getNumAcidentes() {
        return numAcidentes;
    }
    public void setNumAcidentes(int numAcidentes) {
        this.numAcidentes = numAcidentes;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    
    
}
