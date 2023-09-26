/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex01;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Concorrente {

    // Atributos
    private String nomeConcorrente;
    private String area;
    private int inscricao;
    private String telefone;
    private String endereco;

    // Construtor
    public Concorrente(String nomeConcorrente, String area, int inscricao, String telefone, String endereco) {
        setNomeConcorrente(nomeConcorrente);
        setArea(area);
        setInscricao(inscricao);
        setTelefone(telefone);
        setEndereco(endereco);
    }

    // Getters e Setters
    public String getNomeConcorrente() {
        return nomeConcorrente;
    }

    public void setNomeConcorrente(String nomeConcorrente) throws IllegalArgumentException {
        if (nomeConcorrente.trim().isEmpty() || nomeConcorrente == null) {
            throw new IllegalArgumentException();
        }
        this.nomeConcorrente = nomeConcorrente;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) throws IllegalArgumentException {
        if (area.trim().isEmpty() || area == null) {
            throw new IllegalArgumentException();
        }
        this.area = area;
    }

    public int getInscricao() {
        return inscricao;
    }

    public void setInscricao(int inscricao) throws IllegalArgumentException {
        if (inscricao < 0) {
            throw new IllegalArgumentException();
        }
        this.inscricao = inscricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws IllegalArgumentException {
        if (telefone.trim().isEmpty() || telefone == null) {
            throw new IllegalArgumentException();
        }
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) throws IllegalArgumentException {
        if (endereco.trim().isEmpty() || endereco == null) {
            throw new IllegalArgumentException();
        }
        this.endereco = endereco;
    }

    // Métodos
    @Override
    public String toString() {
        return getNomeConcorrente() + " - " + getArea() + " - " + getInscricao()
                + " - " + getTelefone() + " - " + getEndereco();
    }
}
