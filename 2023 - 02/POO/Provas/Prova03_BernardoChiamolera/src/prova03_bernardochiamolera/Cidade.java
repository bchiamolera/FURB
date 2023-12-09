package prova03_bernardochiamolera;

import java.util.ArrayList;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Cidade {
    private String nome;
    private ArrayList<Acidente> acidentes;

    public Cidade(String nome) {
        this.nome = nome;
        this.acidentes = new ArrayList();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Acidente> getAcidentes() {
        return acidentes;
    }
    public void setAcidentes(ArrayList<Acidente> acidentes) {
        this.acidentes = acidentes;
    }
    
    public void addAcidente(Acidente acidente) {
        this.acidentes.add(acidente);
    }
    
    @Override
    public String toString() {
        int qtdCarro = 0;
        int qtdMoto = 0;
        int qtdCaminhão = 0;
        
        for (Acidente a : acidentes) {
            switch (a.getTipoVeiculo()) {
                case "carro":
                    qtdCarro += a.getNumAcidentes();
                    break;
                case "moto":
                    qtdMoto += a.getNumAcidentes();
                    break;
                case "caminhão":
                    qtdCaminhão += a.getNumAcidentes();
                    break;
                default:
                    break;
            }
        }
        
        return "Nome: " + this.getNome() + "\nQtd. Acidentes Carro: " + qtdCarro
                + "\nQtd. Acidentes Moto: " + qtdMoto + "\nQtd. Acidentes Caminhão: " + qtdCaminhão;
    }
}
