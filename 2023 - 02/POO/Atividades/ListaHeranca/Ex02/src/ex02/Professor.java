package ex02;

import java.util.ArrayList;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Professor {
    private String nome;
    private String area;
    private ArrayList<Artigo> artigos;

    public Professor(String nome, String area) {
        setNome(nome);
        setArea(area);
        artigos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    
    public ArrayList<Artigo> getArtigos() {
        return this.artigos;
    }
    
    // Métodos
    public String mostrarEstatistica() {
        String str = "";
        if (this.artigos.isEmpty()) str = "Este professor não possui artigos";
        else {
            for (Artigo a : artigos) {
                str += a.exibirDados();
                str += "------------";
            }
        }
        return "Nome: " + this.getNome() + "\nÁrea: " + this.getArea() + "\nArtigos: \n------------" + str;
    }
    
    public void adicionarArtigo(Artigo artigo) throws IllegalArgumentException {
        if (artigo == null) {
            throw new IllegalArgumentException();
        }
        this.artigos.add(artigo);
    }
}
