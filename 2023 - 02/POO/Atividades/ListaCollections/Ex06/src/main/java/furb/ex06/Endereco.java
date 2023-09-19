/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.ex06;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Endereco {

    // Atributos
    private String logradouro;
    private String complemento;
    private int numero;

    // Getters e Setters
    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) throws IllegalArgumentException {
        if (logradouro.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) throws IllegalArgumentException {
        if (getComplemento() == null && complemento.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.complemento = complemento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) throws IllegalArgumentException {
        if (numero < 0) {
            throw new IllegalArgumentException();
        }
        this.numero = numero;
    }

    // Construtor
    public Endereco(String logradouro) {
        setLogradouro(logradouro);
    }

    //Métodos
    @Override
    public String toString() {
        String dados = "\n- Logradouro: " + getLogradouro();
        if (getNumero() > 0) {
            dados += "\n- Número: " + getNumero();
        }
        if (getComplemento() != null && !getComplemento().trim().isEmpty()) {
            dados += "\n- Complemento: " + getComplemento() + "\n";
        }
        return dados;
    }
}
