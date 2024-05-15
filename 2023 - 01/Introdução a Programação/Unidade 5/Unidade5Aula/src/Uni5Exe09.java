/*
 Uma turma tem n alunos. Dado n, o nome e idade de cada aluno descreva um algoritmo que:
- escreva os nomes dos alunos que tem 18 anos;
- escreva a quantidade de alunos que tem idade acima de 20 anos.
 */
import java.util.Scanner;
public class Uni5Exe09 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int n, alunoIdade, alunosMaiores20Anos, contador;
        String alunos18anos, alunoNome;
        alunosMaiores20Anos = 0;
        alunos18anos = "";
        System.out.println("Digite a quantidade de alunos: ");
        n = teclado.nextInt();
        for (contador = 1; contador <= n; contador++) {
            System.out.println("Nome do(a) aluno(a): ");
            alunoNome = teclado.next();
            System.out.println("Idade do(a) aluno(a): ");
            alunoIdade = teclado.nextInt();
            if (alunoIdade == 18) {
                alunos18anos = alunos18anos + alunoNome + "; ";
            }
            if (alunoIdade > 20) {
                alunosMaiores20Anos++;
            }
        }
        System.out.println("Alunos com 18 anos: " + alunos18anos);
        System.out.println("Quantidade de alunos com mais de 20 anos: " + alunosMaiores20Anos);
        teclado.close();
    }
}
