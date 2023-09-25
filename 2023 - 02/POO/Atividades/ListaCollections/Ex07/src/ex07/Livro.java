/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex07;

/**
 *
 * @author Bernardo Chiamolera
 */
import java.text.DecimalFormat;

public class Livro {
    DecimalFormat dfMoney = new DecimalFormat("#,###.00");
    
    // Atributos
    private String titulo;
    private String autor;
    private String isbn;
    private int estoque;
    private double pCompra;
    private double pVenda;
    
    // Getters e Setters

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getEstoque() {
        return estoque;
    }
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getpCompra() {
        return pCompra;
    }
    public void setpCompra(double pCompra) {
        this.pCompra = pCompra;
    }

    public double getpVenda() {
        return pVenda;
    }
    public void setpVenda(double pVenda) {
        this.pVenda = pVenda;
    }
    
    //Construtor
    public Livro(String titulo, String autor, String isbn, double pCompra, double pVenda) {
        setTitulo(titulo);
        setAutor(autor);
        setIsbn(isbn);
        setEstoque(0);
        setpCompra(pCompra);
        setpVenda(pVenda);
    }
    
    @Override
    public String toString() {
        return "Titulo: " + this.getTitulo() + "\nAutor: " + this.getAutor() 
             + "\nISBN: " + this.getIsbn() + "\nEstoque: " + this.getEstoque() 
             + "\nPreco compra: R$" + dfMoney.format(this.getpCompra())
             + "\nPreco venda: R$" + dfMoney.format(this.getpVenda());
    }
}
