package preparativoprova;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Plano {
    // Atributos
    private String nome;
    private int ano;
    private int qtdDependentes;

    // Construtor
    public Plano(String nome, int ano, int qtdDependentes) {
        setNome(nome);
        setAno(ano);
        setQtdDependentes(qtdDependentes);
    }
    
    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getQtdDependentes() {
        return qtdDependentes;
    }
    public void setQtdDependentes(int qtdDependentes) {
        this.qtdDependentes = qtdDependentes;
    }
    
    public double aplicarDesconto() {
        return 1;
    };
    
    // Métodos
    @Override
    public String toString() {
        return "Plano: " + this.getNome() + "\nAno de início: " + this.getAno() + "\nQtd. Dependentes: " + this.getQtdDependentes();
    }
}
