/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex09;

/**
 *
 * @author Bernardo Chiamolera
 */

import java.util.ArrayList;

public class Veiculo {
    // Atributos
    private String placa;
    private char tipoVeiculo;
    private double capacidadeCarga;
    private char tipoCombustivel;
    private double Valor;
    private Proprietario proprietario;
    private ArrayList<Multa> multas;

    // Construtor
    public Veiculo(String placa, char tipoVeiculo, double capacidadeCarga, char tipoCombustivel, double valor, Proprietario proprietario) {
        setPlaca(placa);
        setTipoVeiculo(tipoVeiculo);
        setCapacidadeCarga(capacidadeCarga);
        setTipoCombustivel(tipoCombustivel);
        setValor(valor);
        setProprietario(proprietario);
        this.multas = new ArrayList<>();
    }

    // Getters e Setters
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public char getTipoVeiculo() {
        return tipoVeiculo;
    }
    public void setTipoVeiculo(char tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }
    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public char getTipoCombustivel() {
        return tipoCombustivel;
    }
    public void setTipoCombustivel(char tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public double getValor() {
        return Valor;
    }
    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }
    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    
    // Métodos
    public void addMulta(Multa m) {
        this.multas.add(m);
    }
    
    public String verVeiculo() {
        String tpVeiculo = this.tipoVeiculo == 'c' ? "Carga" : "Passeio";
        String tpCombustivel = this.tipoCombustivel == 'a' ? "Álcool" : "Gasolina";
        return "Placa: " + this.getPlaca() + "\nTipo: " + tpVeiculo + "\nCapacidade: "+ this.getCapacidadeCarga()
                + "\nCombustível: " + tpCombustivel + "\nValor: " + this.getValor() + "\nIPVA: " + this.calcularIpva();
    }
    
    public String verProprietario() {
        return this.getProprietario().toString();
    }
    
    public String verMultas() {
        String str = "Multas: \n------------------\n";
        for(Multa m : multas) str += m.toString() + "\n------------------\n";
        return str;
    }
    
    private double calcularIpva() {
        // Verifica se é um veículo de carga
        if (this.tipoVeiculo == 'c') {
            // Verifica se a capacidade ultrapassa 1 ton;
            if (this.capacidadeCarga > 1000) return this.getValor() * 0.09;
            return this.getValor() * 0.06;
        }
        // Verifica se é movido a álcool
        if (this.tipoCombustivel == 'a') return this.getValor() * 0.03;
        return this.getValor() * 0.04;
    }
    
    public double calcularLicenciamento() {
        double vlr = this.calcularIpva();
        for (Multa m : multas) {
            if (!m.isStatus()) vlr += m.getValor();
        }
        return vlr;
    }
}
