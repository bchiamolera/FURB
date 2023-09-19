/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex03;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Pessoa {
    private String nome;
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException {
        if (nome == null || nome.trim().isEmpty())
            throw new IllegalArgumentException();
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws IllegalArgumentException {
        if (cpf == null || cpf.trim().isEmpty())
            throw new IllegalArgumentException();
        this.cpf = cpf;
    }

    public Pessoa(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
    }
}
