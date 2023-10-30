/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex00.funcionario;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Funcionario {
    private String nome, cpf;

    public Funcionario(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
    }
    
    protected String getNome() {
        return nome;
    }
    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected String getCpf() {
        return cpf;
    }
    protected void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
