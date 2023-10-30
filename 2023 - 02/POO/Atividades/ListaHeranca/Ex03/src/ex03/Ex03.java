package ex03;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Ex03 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Atleta> atletas = new ArrayList();
        System.out.println("Cadastro de Atletas: ");
        boolean fl = false;
        do {
            System.out.println("Nome: ");
            String nome = s.next();
            System.out.println("Peso: ");
            double peso = s.nextDouble();
            System.out.println("Idade: ");
            int idade = s.nextInt();
            System.out.println("L - Lutador / J - Jogador");
            char tipoAtleta = s.next().trim().toUpperCase().charAt(0);
            switch (tipoAtleta) {
                case 'L' -> {
                    atletas.add(new Lutador(nome, peso, idade));
                }
                case 'J' -> {
                    atletas.add(new Jogador(nome, peso, idade));
                }
                default -> {
                    System.out.println("Tipo Inválido");
                }
            }
            System.out.println("Sair? S - Sim / N - Não");
            char op = s.next().trim().toUpperCase().charAt(0);
            if (op == 'S') fl = true;
        } while (!fl);
        for(Atleta a : atletas) {
            System.out.println("Nome: " + a.getNome());
            System.out.println("Peso: " + a.getPeso());
            System.out.println("Idade: " + a.getIdade());
            System.out.println("Categoria: " + a.definirCategoria());
            System.out.println("");
        }
        s.close();
    }
    
}
