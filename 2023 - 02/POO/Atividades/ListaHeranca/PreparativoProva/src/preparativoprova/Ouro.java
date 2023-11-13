package preparativoprova;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Ouro extends Plano {
    // Construtor
    public Ouro(String nome, int ano, int qtdDependentes) {
        super(nome, ano, qtdDependentes);
    }
    
    // Métodos
    @Override
    public double aplicarDesconto() {
        if (this.getQtdDependentes() > 2) return 0.5;
        return 0.6;
    }
    
    @Override
    public String toString() {
        return "Tipo: Ouro\n" + super.toString();
    }
}
