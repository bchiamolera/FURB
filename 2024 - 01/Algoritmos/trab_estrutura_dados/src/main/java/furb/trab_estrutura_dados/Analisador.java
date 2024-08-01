package furb.trab_estrutura_dados;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Analisador {

    private File arquivo;
    private ListaEncadeada listaTagsFechadas;
    private PilhaLista pilhaTagsAbertas;

    public Analisador(File arquivo, ListaEncadeada listaTags) {
        this.arquivo = arquivo;
        listaTagsFechadas = listaTags;
        pilhaTagsAbertas = new PilhaLista();
    }

    public String analisarArquivo() throws FileNotFoundException {
        Scanner scan = new Scanner(arquivo);
        // Percorre o arquivo
        while (scan.hasNextLine()) {
            String linha = scan.nextLine().trim();
            //Pula linhas vazias; analisa linhas não vazias;
            if (!linha.isEmpty()) {
                String wrongCloseTag = acharTags(linha);
                if (!wrongCloseTag.isEmpty()) {
                    return wrongCloseTag;
                }
            }
        }
        return null;
    }

    private String acharTags(String linha) {
        // Procura por abre tag '<'
        for (int i = 0; i < linha.length(); i++) {
            if (linha.charAt(i) == '<') {
                // Procura por fecha tag '>'
                for (int j = i; j < linha.length() && linha.charAt(j) != '>'; j++) {
                    // Pega a tag formatada sem atributos
                    String tag = linha.substring(i + 1, j).split(" ")[0].toLowerCase();
                    // Verifica se ha '/' apos o '<'
                    if (!tag.startsWith("/")) {
                        pilhaTagsAbertas.push(tag);
                        return null;
                    }
                    else {
                        // Remove "/"
                        tag = tag.substring(1);
                        if (pilhaTagsAbertasEstaVazia() || !pilhaTagsAbertas.peek().equals(tag)) {
                            return tag;
                        }
                        pilhaTagsAbertas.pop();
                        addTagNaLista(tag);
                    }
                }
            }
        }
        return null;
    }
    
    private void addTagNaLista(String tag) {
        for (int i = 0; i < listaTagsFechadas.obterComprimento(); i++) {
            Tag currentTag = (Tag) listaTagsFechadas.obterNo(i).getInfo();
            if (currentTag.getNome().equals(tag)) {
                currentTag.incrementQuantidade();
                return;
            }
        }
        listaTagsFechadas.inserir(new Tag(tag));
    }

    public boolean pilhaTagsAbertasEstaVazia() {
        return pilhaTagsAbertas.estaVazia();
    }
    
    public PilhaLista getPilhaTagsAbertas() {
        return pilhaTagsAbertas;
    }
}
