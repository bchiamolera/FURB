/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex00.publicacao;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Revista extends Publicacao {
    private String periodicidade;

    public Revista(String nome, String editora, String periodicidade) {
        super(nome, editora);
        setPeriodicidade(periodicidade);
    }
    
    public String getPeriodicidade() {
        return periodicidade;
    }
    protected void setPeriodicidade(String periodicidade) {
        this.periodicidade = periodicidade;
    }
    
    public String imprimir() {
        return "Nome: " + this.getNome() + "\nEditora: " + this.getEditora() + "\nPeriodicidade: " + this.getPeriodicidade();
    }
}
