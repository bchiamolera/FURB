import java.text.DecimalFormat;

public class Apolice {
    // Atributos
    private String nome;
    private int idade;
    private double valorPremio;
    
    // Construtor
    public Apolice(String nome, int idade, double valorPremio) {
        this.setNome(nome);
        this.setIdade(idade);
        this.setValorPremio(valorPremio);
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        if (idade < 18)
            throw new IllegalArgumentException("Idade inválida");
        this.idade = idade;
    }
    public double getValorPremio() {
        return valorPremio;
    }
    public void setValorPremio(double valorPremio) {
        if (idade < 0.0)
            throw new IllegalArgumentException("Valor do prêmio inválido");
        this.valorPremio = valorPremio;
    }

    // Métodos
    DecimalFormat dfMoney = new DecimalFormat("###,###.00");

    public String imprimir() {
        return "Nome: " + this.getNome() +
               "\nIdade: " + this.getIdade() +
               "\nValor Prêmio: R$ " + dfMoney.format(this.getValorPremio());
    }

    public void calcularPremio() {
        if (this.getIdade() <= 25) {
            this.setValorPremio(this.getValorPremio() * 1.20);
        }
        else if (this.getIdade() > 25 && this.getIdade() <= 36) {
            this.setValorPremio(this.getValorPremio() * 1.15);
        }
        else if (this.getIdade() > 36) {
            this.setValorPremio(this.getValorPremio() * 1.10);
        }
    }

    public void oferecerDesconto(String cidade) {
        if (cidade.equalsIgnoreCase("ilhota")) {
            this.setValorPremio(this.getValorPremio() * 0.95);
        }
        else if (cidade.equalsIgnoreCase("blumenau")) {
            this.setValorPremio(this.getValorPremio() * 0.97);
        }
        else if (cidade.equalsIgnoreCase("itajaí") || cidade.equalsIgnoreCase("itajai")) {
            this.setValorPremio(this.getValorPremio() * 0.99);
        }
        else {
            throw new IllegalArgumentException("Cidade sem benefício de desconto");
        }
    }
}
