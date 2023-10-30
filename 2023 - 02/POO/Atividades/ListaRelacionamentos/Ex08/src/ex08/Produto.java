/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex08;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Produto {
    // Atributos
    private int codigo;
    private String descricao;
    private double valor;
    
    // Construtor
    public Produto(int codigo, String descricao, double valor) {
        setCodigo(codigo);
        setDescricao(descricao);
        setValor(valor);
    }
    
    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    // Métodos
    @Override
    public String toString() {
        return "Código: " + getCodigo() + " Descrição: " + getDescricao() + " Valor: R$" + getValor();
    }
}
