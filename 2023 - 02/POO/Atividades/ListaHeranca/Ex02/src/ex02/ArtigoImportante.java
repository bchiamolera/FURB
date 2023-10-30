package ex02;

import java.text.ParseException;

/**
 *
 * @author Bernardo Chiamolera
 */
public class ArtigoImportante extends Artigo {
    private int fatorImpacto;
    
    public ArtigoImportante(String titulo, String periodico, String dataPublicacao, char qualis, int fatorImpacto) throws ParseException {
        super(titulo, periodico, dataPublicacao, qualis);
        setFatorImpacto(fatorImpacto);
    }

    public int getFatorImpacto() {
        return fatorImpacto;
    }

    private void setFatorImpacto(int fatorImpacto) {
        this.fatorImpacto = fatorImpacto;
    }
    
    // Métodos
    @Override
    public String exibirDados() {
        return super.exibirDados() + "\nFator Impacto: " + this.getFatorImpacto();
    }
}
