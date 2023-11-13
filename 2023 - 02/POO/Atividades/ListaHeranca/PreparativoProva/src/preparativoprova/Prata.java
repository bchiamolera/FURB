package preparativoprova;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Prata extends Plano {
    // Construtor
    public Prata(String nome, int ano, int qtdDependentes) {
        super(nome, ano, qtdDependentes);
    }
    
    // Métodos
    @Override
    public double aplicarDesconto() {
        if (this.getAno() <= 2000) return 0.7;
        return 0.8;
    }
    
    @Override
    public String toString() {
        return "Tipo: Prata\n" + super.toString();
    }
}
