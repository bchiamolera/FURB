package ex04;

/**
 *
 * @author Bernardo Chiamolera
 */
public class BotesSalvaVidas extends Embarcacao {
    private boolean inflavel;

    public BotesSalvaVidas(int registroCapitania, int qtdadePessoas, boolean inflavel) {
        super(registroCapitania, qtdadePessoas);
        setInflavel(inflavel);
    }

    public boolean isInflavel() {
        return inflavel;
    }
    public void setInflavel(boolean inflavel) {
        this.inflavel = inflavel;
    }

    @Override
    public String mostrar() {
        String str;
        if (isInflavel()) str = "Sim";
        else str = "Não";
        return "Reg. Capitania: " + this.getRegistroCapitania() + "\nQtde. Pessoas: " + this.getQtdadePessoas()
                + "\nInflável: " + str;
    }
    
    
}
