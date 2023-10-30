/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex09;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Proprietario {
    // Atributos
    private String name;
    private String cpf;
    private String endereco;

    // Construtor
    public Proprietario(String name, String cpf, String endereco) {
        setName(name);
        setCpf(cpf);
        setEndereco(endereco);
    }

    // Getters e Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    // Métodos
    @Override
    public String toString() {
        return "Proprietário: " + this.getName() + "\nCPF: " + this.getCpf() + "\nEndereço: " + this.getEndereco();
    }
}
