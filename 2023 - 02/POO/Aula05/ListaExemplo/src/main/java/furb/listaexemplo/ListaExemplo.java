/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package furb.listaexemplo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Bernardo Chiamolera
 */
public class ListaExemplo {

    private final ArrayList<Pessoa> listaNomes;

    public ListaExemplo() {
        listaNomes = new ArrayList<Pessoa>();
        popularLista();
        imprimir();
    }

    private void popularLista() {
        Scanner s = new Scanner(System.in);
        String nome;
        int idade;

        do {
            System.out.println("Digite um nome ou \"fim\" para sair");
            nome = s.next();
            if (!nome.equalsIgnoreCase("fim")) {
                System.out.println("Digite a idade: ");
                idade = s.nextInt();
                Pessoa p = new Pessoa(nome, idade);
                listaNomes.add(p);
            }
        } while (!nome.equalsIgnoreCase("fim"));
    }

    private void imprimir() {
        //for (int i = 0; i < listaNomes.size(); i++) {
        //    System.out.println(listaNomes.get(i).toString());
        //}
        for (Pessoa pessoa : listaNomes) {
            System.out.println(pessoa.toString());
        }
    }

    public static void main(String[] args) {
        new ListaExemplo();
    }
}
