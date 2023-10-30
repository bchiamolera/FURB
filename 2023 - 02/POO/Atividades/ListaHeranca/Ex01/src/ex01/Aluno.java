package ex01;

/**
 *
 * @author Bernardo Chiamolera
 */
public abstract class Aluno {
    private String nome;
    private String curso;

    public String getNome() {
        return nome;
    }
    private void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }
    private void setCurso(String curso) {
        this.curso = curso;
    }

    public Aluno(String nome, String curso) {
        setNome(nome);
        setCurso(curso);
    }
    
    public abstract String exibirDados();
}
