package ex01;

import java.util.Scanner;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Ex01 {
    public static void main(String[] args) {
        new Ex01();
    }
    
    public Ex01() {
        try (Scanner s = new Scanner(System.in)) {
            Aluno aluno = null;
            
            System.out.println("Nome: ");
            String nome = s.next();
            System.out.println("Curso: ");
            String curso = s.next();
            
            boolean fl = false;
            do {
                System.out.println("G - Graduação / P - Pós-Graduação: ");
                char tipoAluno = s.next().toUpperCase().charAt(0);
                
                switch (tipoAluno) {
                    case 'G' -> {
                        System.out.println("Semestre: ");
                        int semestre = s.nextInt();
                        
                        aluno = new AlunoGrad(nome, curso, semestre);
                        fl = true;
                    }
                    case 'P' -> {
                        System.out.println("pontos do POSCOMP: ");
                        int pontos = s.nextInt();
                        
                        aluno = new AlunoPosGrad(nome, curso, pontos);
                        fl = true;
                    }
                    default -> System.out.println("Tipo de aluno inválido");
                }
            } while (!fl);
            
//        if (aluno instanceof AlunoGrad) {
//            System.out.println(((AlunoGrad) aluno).exibirDados());
//        } else if (aluno instanceof AlunoPosGrad) {
//            System.out.println(((AlunoPosGrad) aluno).exibirDados());
//        }

            System.out.println(aluno.exibirDados());
        }
    }
}
