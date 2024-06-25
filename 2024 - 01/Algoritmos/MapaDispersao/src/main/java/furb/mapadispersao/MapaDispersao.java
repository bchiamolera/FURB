/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package furb.mapadispersao;

/**
 *
 * @author Bernardo Chiamolera
 */
public class MapaDispersao<T> {
    private ListaEncadeada<NoMapa<T>>[] info;

    public MapaDispersao(int tamanho) {
        this.info = new ListaEncadeada[tamanho];
    }

    private int calcularHash(int chave) {
        return (chave % info.length);
    }
    
    public void inserir(int chave, T dado) {
        int index = calcularHash(chave);
        
        if (info[index] == null) {
            info[index] = new ListaEncadeada();
        }
        
        NoMapa no = new NoMapa();
        no.setChave(chave);
        no.setInfo(dado);
        
        info[index].inserir(no);
    }
    
    public void remover(int chave) {
        int index = calcularHash(chave);
        
        if (info[index] != null) {
            NoMapa noMapa = new NoMapa();
            noMapa.setChave(chave);
            
            info[index].retirar(noMapa);
        }
    }
    
    public T buscar(int chave) {
        int index = calcularHash(chave);
        
        if (info[index] != null) {
            NoMapa noMapa = new NoMapa();
            noMapa.setChave(chave);
            
            NoLista no = info[index].buscar(noMapa);
            if (no != null) {
                return (T) ( (NoMapa) no.getInfo() ).getInfo();
            }
        }
        
        return null;
    }
    
    public void realocarMapa(int novoTamanho) {
        ListaEncadeada<NoMapa<T>>[] antigo = info;
        info = new ListaEncadeada[novoTamanho];
        
        for (int i = 0; i < antigo.length; i++) {
            if (antigo[i] != null) {
                NoLista<NoMapa<T>> p = antigo[i].getPrimeiro();
                while (p != null) {
                    inserir(p.getInfo().getChave(), p.getInfo().getInfo());
                    p = p.getProximo();
                }
            }
        }
    }
    
    private boolean isPrimo(int num) {
        int qtdDivisores = 0;
        for (int i = 1; i <= num; i ++) {
            if (num % i == 0) {
                qtdDivisores++;
                if (qtdDivisores > 2) {
                    break;
                }
            }
        }
        return qtdDivisores == 2;
    }
    
    public int buscarProximoNumeroPrimo(int num) {
        while (!isPrimo(num)) {
            num++;
        }
        return num;
    }
}
