/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex07;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Ex07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EstoqueLivraria e = new EstoqueLivraria(1000);

        Livro l1 = new Livro("A Revolução dos Bichos", "George Orwell", "978-0451526342", 12.99, 19.99);
        Livro l2 = new Livro("Dom Quixote", "Miguel de Cervantes", "978-0142437230", 14.99, 24.99);
        Livro l3 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "978-0345538376", 20.0, 29.99);
        Livro l4 = new Livro("1984", "George Orwell", "978-0451524935", 10.0, 17.99);
        Livro l5 = new Livro("Cem Anos de Solidão", "Gabriel García Márquez", "978-0061120091", 15.5, 22.99);
        
        Livro l6 = new Livro("O Pequeno Principe", "Antoine de Saint-Exupery", "978-3150003747", 9.99, 16.99);
        
        System.out.println(e.compraDeLivros(l1, 3));
        System.out.println(e.compraDeLivros(l2, 6));
        System.out.println(e.compraDeLivros(l3, 10));
        System.out.println(e.compraDeLivros(l4, 5));
        System.out.println(e.compraDeLivros(l5, 1));
        
        System.out.println(e.vendaDeLivros(l1, 2));
        System.out.println(e.vendaDeLivros(l2, 1));
        System.out.println(e.vendaDeLivros(l3, 5));
        System.out.println(e.vendaDeLivros(l4, 7));
        System.out.println(e.vendaDeLivros(l5, 1));
        
        System.out.println(e.vendaDeLivros(l6, 2));
        
        System.out.println(e.imprimeEstoque());
    }
}
