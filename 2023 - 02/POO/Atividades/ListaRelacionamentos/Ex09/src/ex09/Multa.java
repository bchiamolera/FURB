/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex09;

/**
 *
 * @author Bernardo Chiamolera
 */

import java.text.DecimalFormat;

public class Multa {
    // Atributos
    private String local;
    private String tipo;
    private double valor;
    private boolean status; // True == Paga; False == Aberta

    // Construtor
    public Multa(String local, String tipo, double valor, boolean status) {
        setLocal(local);
        setTipo(tipo);
        setValor(valor);
        setStatus(status);
    }

    // Getters e Setters
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    // Métodos
    
    @Override
    public String toString() {
        DecimalFormat dfMoney = new DecimalFormat("#,###.00");
        String sts = this.isStatus() ? "Paga" : "Em aberto";
        return "Local: " + this.getLocal() + "\nTipo: " + this.getTipo() +
                "\nValor: R$" + dfMoney.format(this.getValor()) + "\nStatus: " + sts;
    }
}
