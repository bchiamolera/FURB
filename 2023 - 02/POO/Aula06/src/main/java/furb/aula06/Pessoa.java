/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.aula06;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Pessoa {
    private int cpf;
    private String nome;
    
    public Pessoa(int cpf, String nome) {
        setCpf(cpf);
        setNome(nome);
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\nCPF: " + this.getCpf();
    }
}
