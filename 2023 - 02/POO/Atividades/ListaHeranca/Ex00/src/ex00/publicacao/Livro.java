/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex00.publicacao;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Livro extends Publicacao {
    private String isbn;

    public Livro(String nome, String editora, String isbn) {
        super(nome, editora);
        setIsbn(isbn);
    }
    
    public String getIsbn() {
        return isbn;
    }
    protected void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public String imprimir() {
        return "Nome: " + this.getNome() + "\nEditora: " + this.getEditora() + "\nISBN: " + this.getIsbn();
    }
}
