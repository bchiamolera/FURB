package ex04;

import java.util.ArrayList;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Navio extends Embarcacao {
    private String nome;
    private ArrayList<BotesSalvaVidas> botes;

    public Navio(int registroCapitania, int qtdadePessoas, String nome) {
        super(registroCapitania, qtdadePessoas);
        setNome(nome);
        botes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    private boolean verificarSeguranca() {
        int capacidadeBotes = 0;
        for (BotesSalvaVidas bote : botes) {
            capacidadeBotes += bote.getQtdadePessoas();
        }
        
        return capacidadeBotes >= this.getQtdadePessoas();
    }
    
    public void adicionarBote(BotesSalvaVidas bote) {
        this.botes.add(bote);
    }
    
    private String getBotesInfo() {
        String str = "";
        for (int i = 0; i < botes.size(); i++) {
            str += "\nBote " + (i + 1) + ": ";
            str += "\n" + botes.get(i).mostrar() + "\n";
        }
        
        return str;
    }

    @Override
    public String mostrar() {
        String str = "========================================\n\n";
        if (verificarSeguranca()) str += "Navio atende as normas de segurança\n\n";
        else str += "Navio NÃO atende normas de segurança, número de botes insuficiente\n\n";
        
        return str + "Reg. Capitania: " + this.getRegistroCapitania() + "\nQtde. Pessoas: " + this.getQtdadePessoas()
                + "\nNome: " + this.getNome() + "\n" + this.getBotesInfo() + "\n========================================\n";
    }
    
    
}
