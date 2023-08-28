public class Lutador {
    // Definindo e declarando os atributos da classe
    private String Nome;
    private double Peso;

    // Criando os métodos acessores e modificadores dos atributos
    private void setNome(String nome) {
        this.Nome = nome;
    }
    private String getNome() {
        return Nome;
    }

    private void setPeso(double peso) {
        this.Peso = peso;
    }
    private double getPeso() {
        return Peso;
    }

    // Constutor
    public Lutador(String nome, double peso) {
        setNome(nome);
        setPeso(peso);
    }

    // Métodos
    private String definirCategoria() {
        double peso = getPeso();
        if (peso <= 54) {
            return "Pluma";
        } else if (peso <= 60) {
            return "Leve";
        } else if (peso <= 75) {
            return "Meio-leve";
        } else {
            return "Pesado";
        }
    }

    public void imprimir() {
        System.out.println("\nLutador " + getNome() + " está na categoria ["
        + definirCategoria() + "]");
    }
}
