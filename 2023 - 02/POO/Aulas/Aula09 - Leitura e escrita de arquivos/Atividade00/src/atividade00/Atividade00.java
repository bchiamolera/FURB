/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atividade00;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Atividade00 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        new Atividade00();
    }

    public Atividade00() throws FileNotFoundException {
        String rota = "C:/Users/Bernardo Chiamolera/Desktop/Furb/Arquivos/2023 - 02/POO/Aulas/Aula09 - Leitura e escrita de arquivos/Atividade00/";
        boolean fl = true;
        int op;
        do {
            try {
                Scanner s = new Scanner(System.in);
                System.out.println("SELECIONE O QUE DESEJA FAZER:");
                System.out.println("1. CRIAR ARQUIVO");
                System.out.println("2. ESCREVER EM UM ARQUIVO");
                System.out.println("3. LER UM ARQUIVO");
                System.out.println("4. SAIR");
                op = s.nextInt();

                switch (op) {
                    case 1 ->
                        criarDoc();
                    case 2 -> {
                        System.out.println("Nome do arquivo: ");
                        String nome = s.next();
                        System.out.println("");
                        escreverDoc(new File(rota + nome + ".txt"));
                    }
                    case 3 -> {
                        System.out.println("Nome do arquivo: ");
                        String nome = s.next();
                        System.out.println("");
                        lerDoc(new File(rota + nome + ".txt"));
                    }
                    case 4 ->
                        fl = false;
                    default ->
                        System.out.println("Opção inválida");
                }
                System.out.println("");
                s.close();
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } while (fl);
    }

    public void criarDoc() throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        String rota = "C:/Users/Bernardo Chiamolera/Desktop/Furb/Arquivos/2023 - 02/POO/Aulas/Aula09 - Leitura e escrita de arquivos/Atividade00/";
        System.out.println("Nome do arquivo: ");
        String nome = s.nextLine();

        File arq = new File(rota + nome + ".txt");
        FileOutputStream fos = null;
        if (arq.exists()) {
            boolean fl = true;
            while (fl) {
                System.out.println("Arquivo já existe, deseja substituir? 1. Sim / 2. Não");
                int res = s.nextInt();
                switch (res) {
                    case 1 -> {
                        fos = new FileOutputStream(arq, false);
                        fl = false;
                    }
                    case 2 -> {
                        fos = new FileOutputStream(arq, true);
                        fl = false;
                    }
                    default -> {
                        System.out.println("Opção inválida");
                    }
                }
            }
        } else {
            fos = new FileOutputStream(arq, true);
        }
        System.out.println("Arquivo criado com sucesso!");
        s.close();
    }

    public void escreverDoc(File arquivo) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        FileOutputStream fos = new FileOutputStream(arquivo, true);
        PrintWriter out = new PrintWriter(fos);
        System.out.println("Conteúdo que deseja escrever: (DIGITE 'FIM' PARA ENCERRAR)");
        String linha = "";
        while (!linha.equals("FIM")) {
            linha = s.next();
            
            if (!linha.equals("FIM")) {
                out.println(linha);
            }
        }
        out.close();
        s.close();
    }

    public void lerDoc(File arquivo) throws FileNotFoundException {
        Scanner s = new Scanner(arquivo);
        while (s.hasNext()) {
            System.out.println(s.nextLine());
        }
        s.close();
    }
}
