package prova03_bernardochiamolera;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Atleta {
    private String nome;
    private String cpf;
    private double altura;
    private double peso;
    private Endereco endereco;

    public Atleta(String nome, String cpf, double altura, double peso) {
        setNome(nome);
        setCpf(cpf);
        setAltura(altura);
        setPeso(peso);
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\nCPF: " + this.getCpf() + "\nAltura: " + this.getAltura()
                +"m\nPeso: " + this.getPeso() + "kg\nEndereço: \n" + this.getEndereco().toString();
    }
}
