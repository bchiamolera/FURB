/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex08;

/**
 *
 * @author Bernardo Chiamolera
 */
import java.util.ArrayList;

public class Pedido {
    // Atributos
    private int numeroPedido;
    private String nomeCliente;
    private ArrayList<Produto> produtos;
    
    // Construtor
    public Pedido(int numeroPedido, String nomeCliente) {
        setNumeroPedido(numeroPedido);
        setNomeCliente(nomeCliente);
        this.produtos = new ArrayList<>();
    }
    
    // Getters e Setters
    public int getNumeroPedido() {
        return numeroPedido;
    }
    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
    
    // Métodos
    public void adicionarItemAoPedido(Produto produto) {
        produtos.add(produto);
    }
    
    public void retirarItemDoPedido(int codProduto) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codProduto) {
                produtos.remove(produto);
                return;
            }
        }
    }
    
    private Double calcularTotal() {
        double vlrTotal = 0;
        for (Produto produto: produtos) {
            vlrTotal += produto.getValor();
        }
        return vlrTotal;
    }
    
    public String imprimirPedido() {
        String str = "Número do pedido: " + this.getNumeroPedido() + "\nCliente: " + this.getNomeCliente() + "\n";
        for (Produto produto : produtos) {
            str += produto.toString() + "\n";
        }
        
        return str + "Valor Total: R$" + calcularTotal();
    }
}
