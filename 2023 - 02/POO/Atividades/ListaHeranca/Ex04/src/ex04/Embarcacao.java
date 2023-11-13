package ex04;

/**
 *
 * @author Bernardo Chiamolera
 */
public abstract class Embarcacao {
    private int registroCapitania;
    private int qtdadePessoas;

    public Embarcacao(int registroCapitania, int qtdadePessoas) {
        setRegistroCapitania(registroCapitania);
        setQtdadePessoas(qtdadePessoas);
    }

    public int getRegistroCapitania() {
        return registroCapitania;
    }
    public void setRegistroCapitania(int registroCapitania) {
        this.registroCapitania = registroCapitania;
    }

    public int getQtdadePessoas() {
        return qtdadePessoas;
    }
    public void setQtdadePessoas(int qtdadePessoas) {
        this.qtdadePessoas = qtdadePessoas;
    }
    
    public abstract String mostrar();
}
