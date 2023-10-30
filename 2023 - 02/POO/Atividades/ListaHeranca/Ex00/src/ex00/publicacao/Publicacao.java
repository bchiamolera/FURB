/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex00.publicacao;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Publicacao {
    private String nome, editora;

    public Publicacao(String nome, String editora) {
        setNome(nome);
        setEditora(editora);
    }

    public String getNome() {
        return nome;
    }
    protected void setNome(String nome) {
        this.nome = nome;
    }

    public String getEditora() {
        return editora;
    }
    protected void setEditora(String editora) {
        this.editora = editora;
    }
}
