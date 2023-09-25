/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex05;

/**
 *
 * @author Bernardo Chiamolera
 */
import java.text.DecimalFormat;

public class Pessoa {
    DecimalFormat dfMoney = new DecimalFormat("#,###.00");
    // Atributos
    private String nome;
    private String cpf;
    private double rendaAnual;
    private double imposto;

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getRendaAnual() {
        return rendaAnual;
    }

    public void setRendaAnual(double rendaAnual) {
        this.rendaAnual = rendaAnual;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }
    

    // Construtor
    public Pessoa(String nome, String cpf, double rendaAnual) {
        setNome(nome);
        setCpf(cpf);
        setRendaAnual(rendaAnual);
    }
    
    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\nCPF:: " + this.getCpf() + "\nRenda anual: R$" +  dfMoney.format(this.getRendaAnual());
    }
}
