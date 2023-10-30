package ex02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Artigo {
    private String titulo;
    private String periodico;
    private Date dataPublicacao;
    private char qualis;

    public Artigo(String titulo, String periodico, String dataPublicacao, char qualis) throws ParseException {
        setTitulo(titulo);
        setPeriodico(periodico);
        setDataPublicacao(dataPublicacao);
        setQualis(qualis);
    }

    public String getTitulo() {
        return titulo;
    }
    private void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPeriodico() {
        return periodico;
    }
    private void setPeriodico(String periodico) {
        this.periodico = periodico;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }
    private void setDataPublicacao(String dataPublicacao) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date data = sdf.parse(dataPublicacao);
        this.dataPublicacao = data;
    }
    
    public char getQualis() {
        return qualis;
    }
    private void setQualis(char qualis) {
        this.qualis = qualis;
    }
    
    // Métodos
    public String exibirDados() {
        return "Título: " + this.getTitulo() + "\nPeriodico: " + this.getPeriodico()
                + "\nData de Publicação: " + this.getDataPublicacao()+ "\nQualis: " + this.getQualis();
    }
}
