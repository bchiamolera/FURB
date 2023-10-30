package ex02;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Ex02 {

    public static void main(String[] args) throws ParseException {
        new Ex02();
    }

    public Ex02() throws ParseException {
        try (Scanner s = new Scanner(System.in)) {
            ArrayList<Professor> professores = new ArrayList<>();
            
            boolean fl1 = false;
            do {
                System.out.println("1- Cadastrar / 2 - Sair");
                int op = s.nextInt();
                switch (op) {
                    case 1 -> {
                        boolean fl2 = false;
                        do {
                            System.out.println("P - Professor / A - Artigo");
                            char tipoEntrada = s.next().toUpperCase().trim().charAt(0);
                            
                            switch (tipoEntrada) {
                                // Cadastro de Professor
                                case 'P' -> {
                                    System.out.println("Nome: ");
                                    String nome = s.next();
                                    System.out.println("Area");
                                    String area = s.next();
                                    boolean profExiste = false;
                                    for (Professor p : professores) {
                                        if (p.getNome().trim().toLowerCase().equals(nome.trim().toLowerCase())) {
                                            profExiste = true;
                                        }
                                    }
                                    if (profExiste) {
                                        System.out.println("Professor já existe");
                                    } else {
                                        professores.add(new Professor(nome, area));
                                        System.out.println("Professor adicionado!");
                                    }
                                    fl2 = true;
                                }
                                // Cadastro de Artigo
                                case 'A' -> {
                                    Artigo artigo = null;
                                    System.out.println("Título: ");
                                    String titulo = s.next();
                                    System.out.println("Periódico: ");
                                    String periodico = s.next();
                                    System.out.println("Data de publicação (dd/mm/yyyy): ");
                                    String data = s.next();
                                    System.out.println("Qualis: ");
                                    char qualis = s.next().trim().charAt(0);
                                    
                                    boolean fl3 = false;
                                    Professor professor = null;
                                    do {
                                        System.out.println("Professor: ");
                                        String nomeProf = s.next();
                                        for (int i = 0; i < professores.size(); i++) {
                                            if (professores.get(i).getNome().equals(nomeProf)) {
                                                professor = professores.get(i);
                                                fl3 = true;
                                                break;
                                            }
                                        }
                                        if (!fl3) {
                                            System.out.println("Professor não encontrado");
                                        }
                                    } while (!fl3);
                                    System.out.println("É um artigo importante? S - Sim / N - Não");
                                    char tipoArtigo = s.next().trim().toUpperCase().charAt(0);
                                    switch (tipoArtigo) {
                                        case 'S' -> {
                                            System.out.println("Fator impacto: ");
                                            int fatorImpacto = s.nextInt();
                                            artigo = new ArtigoImportante(titulo, periodico, data, qualis, fatorImpacto);
                                        }
                                        case 'N' -> {
                                            artigo = new Artigo(titulo, periodico, data, qualis);
                                        }
                                        default -> {
                                            System.out.println("Opção inválida");
                                        }
                                    }
                                    professor.adicionarArtigo(artigo);
                                    System.out.println("Artigo adicionado com sucesso!");
                                    fl2 = true;
                                }
                                default -> {
                                    System.out.println("Opção inválida");
                                }
                            }
                        } while (!fl2);
                    }
                    case 2 -> {
                        for (Professor p : professores) {
                            System.out.println(p.mostrarEstatistica());
                            System.out.println("");
                        }
                        fl1 = true;
                    }
                    default -> {
                        System.out.println("Opção inválida");
                    }
                }
            } while (!fl1);
        }
    };

}
