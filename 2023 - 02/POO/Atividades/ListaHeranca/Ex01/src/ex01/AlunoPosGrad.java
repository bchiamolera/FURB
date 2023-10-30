package ex01;

/**
 *
 * @author Bernardo Chiamolera
 */
public class AlunoPosGrad extends Aluno {
    private int pontosPosComp;
    
    public AlunoPosGrad(String nome, String curso, int pontosPosComp) {
        super(nome, curso);
        setPontosPosComp(pontosPosComp);
    }

    public int getPontosPosComp() {
        return pontosPosComp;
    }
    private void setPontosPosComp(int pontosPosComp) {
        this.pontosPosComp = pontosPosComp;
    }
    
    // Métodos
    @Override
    public String exibirDados() {
        return "Nome: " + this.getNome() + "\nCurso: " + this.getCurso() + "\nPontos: " + this.getPontosPosComp();
    }
}
