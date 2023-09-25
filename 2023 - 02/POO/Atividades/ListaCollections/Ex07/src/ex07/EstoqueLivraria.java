/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex07;

/**
 *
 * @author Bernardo Chiamolera
 */
import java.util.HashMap;

public class EstoqueLivraria {

    // Atributos
    private double saldoCaixa;
    private HashMap<String, Livro> estoque;

    // Getters e Setters
    public double getSaldoCaixa() {
        return saldoCaixa;
    }

    public void setSaldoCaixa(double saldoCaixa) throws IllegalArgumentException {
        if (saldoCaixa < 0) {
            throw new IllegalArgumentException();
        }
        this.saldoCaixa = saldoCaixa;
    }

    public HashMap<String, Livro> getEstoque() {
        return estoque;
    }

    // Construtor
    public EstoqueLivraria(double saldoCaixa) {
        setSaldoCaixa(saldoCaixa);
        this.estoque = new HashMap<String, Livro>();
    }

    // Métodos
    public String compraDeLivros(Livro livro, int qtd) {
        String ret = "";
        if (saldoCaixa >= livro.getpCompra() * qtd) {
            if (this.estoque.containsKey(livro.getIsbn())) {
                livro.setEstoque(livro.getEstoque() + qtd);
            } else {
                livro.setEstoque(livro.getEstoque() + qtd);
                this.estoque.put(livro.getIsbn(), livro);
            }
            this.saldoCaixa -= livro.getpCompra() * qtd;
            ret = qtd + " cópias compradas";
        } else {
            ret = "Saldo insuficiente no caixa";
        }
        return ret;
    }

    public String vendaDeLivros(String isbnLivro, int qtd) {
        String ret = "";
        if (this.estoque.containsKey(isbnLivro)) {
            Livro livro = this.estoque.get(isbnLivro);
            if (livro.getEstoque() >= qtd) {
                this.saldoCaixa += livro.getpVenda()* qtd;
                livro.setEstoque(livro.getEstoque() - qtd);
                ret = qtd + " cópias vendidas";
            } else {
                ret = "Cópias insuficientes.";
            }
        } else {
            ret = "Livro não encontrado.";
        }
        return ret;
    }

    public String imprimeEstoque() {
        String ret = "Estoque: ";
        for (Livro livro : this.estoque.values()) {
            ret += "\n" + livro.toString() + "\n";
        }
        return ret;
    }
}
