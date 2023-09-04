import java.text.DecimalFormat;

public class ContaCorrente {

    // Atributos
    private String Nome;
    private double Saldo;

    // Construtores
    public ContaCorrente() {
        this.setNome("SemNome");
        this.setSaldo(0);
    }

    public ContaCorrente(String nome) {
        this.setNome(nome);
        this.setSaldo(0);
    }

    public ContaCorrente(String nome, double saldo) {
        this.setNome(nome);
        this.setSaldo(saldo);
    }

    // Gets e sets
    public void setContaCorrente(String nome, double saldo) {
        this.setNome(nome);
        this.setSaldo(saldo);
    }

    private String getNome() {
        return this.Nome;
    }

    private void setNome(String nome) {
        this.Nome = nome;
    }

    private double getSaldo() {
        return this.Saldo;
    }

    private void setSaldo(double saldo) {
        if (saldo < 0) {
            this.Saldo = 0;
            throw new IllegalArgumentException("Saldo com valor inválido // Valor negativo/zerado");
        } else {
            this.Saldo = saldo;
        }
    }

    // Métodos
    DecimalFormat df_02 = new DecimalFormat("0.00");

    public String getStatusContaCorrente() {
        return getNome() + " seu saldo atual é de R$" + df_02.format(getSaldo());
    }

    public void fazerDeposito(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Depósito com valor inválido // Valor negativo/zerado");
        }
        setSaldo(getSaldo() + valor);
    }

    public void fazerSaque(double valor) {
        if (valor > getSaldo()) {
            throw new IllegalArgumentException("Saque com valor inválido // Saldo insuficiente");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Saque com valor inválido // Valor negativo/zerado");
        }
        setSaldo(getSaldo() - valor);
    }

    public void fazerTransferencia(ContaCorrente conta, double valor) {
        this.fazerSaque(valor);
        conta.fazerDeposito(valor);
    }
}