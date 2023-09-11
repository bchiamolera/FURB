// Bernardo Chiamolera; BCC-2SEM MAT. 2023/02 FURB
public class Telhado {
    // Atributos
    private double comprimento;
    private double largura;

    // Construtor
    public Telhado(double comprimentoExpostoChuva, double larguraExpostoChuva) {
        setComprimento(comprimentoExpostoChuva);
        setLargura(larguraExpostoChuva);
    }

    // Getters e Setters
    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        if (comprimento < 0) {
            throw new IllegalArgumentException("Valor de comprimento inválido");
        }
        this.comprimento = comprimento;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        if (largura < 0) {
            throw new IllegalArgumentException("Valor de largura inválido");
        }
        this.largura = largura;
    }

    // Métodos
    public double calcularVazão() {
        return 0.067 * getComprimento() * getLargura();
    }

    public int calcularQtdCondutores() {
        int qtdCondutores = 1;
        while (calcularVazão() / qtdCondutores > 7.1) {
            qtdCondutores++;
        }
        return (qtdCondutores);
    }

    public String imprimir() {
        return "- Quantidade mínima de condutores necessários: " + calcularQtdCondutores();
    }
}
