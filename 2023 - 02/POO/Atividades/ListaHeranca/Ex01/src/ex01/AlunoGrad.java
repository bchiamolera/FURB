package ex01;

/**
 *
 * @author Bernardo Chiamolera
 */
public class AlunoGrad extends Aluno {
    private int semestre;

    public AlunoGrad(String nome, String curso, int semestre) {
        super(nome, curso);
        setSemestre(semestre);
    }

    public int getSemestre() {
        return semestre;
    }
    private void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    
    // Métodos
    @Override
    public String exibirDados() {
        return "Nome: " + this.getNome() + "\nCurso: " + this.getCurso() + "\nSemestre: " + this.getSemestre();
    }
}
