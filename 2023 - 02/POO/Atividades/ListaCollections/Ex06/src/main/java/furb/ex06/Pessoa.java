/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.ex06;

/**
 *
 * @author Bernardo Chiamolera
 */
import java.util.ArrayList;
import java.util.HashSet;

public class Pessoa {

    // Atributos
    private String nome;
    private ArrayList<Endereco> enderecos;

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException {
        if (nome.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.nome = nome;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }
    public void addEndereco(String logradouro, String complemento, int num) throws IllegalArgumentException {
        if (logradouro.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        Endereco e = new Endereco(logradouro);
        if (!complemento.trim().isEmpty()) {
            e.setComplemento(complemento);
        }
        if (num > 0) {
            e.setNumero(num);
        }
        this.enderecos.add(e);
    }

    // Construtor
    public Pessoa(String nome) {
        setNome(nome);
        this.enderecos = new ArrayList<Endereco>();
    }

    // Métodos
    public String imprimirEnderecos() {
        String dados = "Endereços de " + this.getNome() + ": ";
        for (Endereco endereco : enderecos) {
            dados += endereco.toString();
        }
        return dados;
    }
}
