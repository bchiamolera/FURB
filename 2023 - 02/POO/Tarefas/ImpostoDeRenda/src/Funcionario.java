public class Funcionario {
    // Atributos
    private String nome;
    private double salario;

    // Construtor
    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario < 0) {
            throw new IllegalArgumentException("Valor de salário inválido.");
        }
        this.salario = salario;
    }

    public double calcularIrpf() {
        double imposto = 0.0;
        // 1 faixa
        if (getSalario() < 1903.99) {
            imposto += 0;
        }
        // 2 faixa
        if (getSalario() >= 1903.99) {
            if (getSalario() < 2826.66) {
                imposto += (getSalario() - 1903.99) * 0.075;
            } else {
                imposto += (2826.65 - 1903.99) * 0.075;
            }
        }
        // 3 faixa
        if (getSalario() >= 2826.66) {
            if (getSalario() < 3751.06) {
                imposto += (getSalario() - 2826.66) * 0.15;
            } else {
                imposto += (3751.05 - 2826.66) * 0.15;
            }
        }
        // 4 faixa
        if (getSalario() >= 3751.06) {
            if (getSalario() < 4664.69) {
                imposto += (getSalario() - 3751.06) * 0.225;
            } else {
                imposto += (4664.68 - 3751.06) * 0.225;
            }
        }
        // 5 faixa
        if (getSalario() >= 4664.69) {
            imposto += (getSalario() - 4664.69) * 0.275;
        }
        return imposto;
    }
}
