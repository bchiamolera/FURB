package furb.trab_estrutura_dados;

public class Tag {

    private String nomeTag;
    private int quantidade;
    
    public Tag(String nomeTag) {
        this.nomeTag = nomeTag;
        quantidade = 1;
    }

    public String getNome() {
        return this.nomeTag;
    }
    
    public int getQuantidade() {
        return this.quantidade;
    }
    
    public void incrementQuantidade() {
        this.quantidade++;
    }
    
    @Override
    public String toString() {
        return "<" + nomeTag + ">";
    }
}
