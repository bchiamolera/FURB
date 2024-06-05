/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package furb.listaduplamenteencadeada;

/**
 *
 * @author Bernardo Chiamolera
 */
public class ListaDuplamenteEncadeada<T> {
    
    private NoListaDupla<T> primeiro;

    public ListaDuplamenteEncadeada() {
        primeiro = null;
    }
    
    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }
    
    public void inserir(T valor) {        
        NoListaDupla<T> novoNo = new NoListaDupla<>();
        novoNo.setInfo(valor);
        novoNo.setProximo(primeiro);
        novoNo.setAnterior(null);
        if (primeiro != null) {
            primeiro.setAnterior(novoNo);
        }
        primeiro = novoNo;
    }
    
    public NoListaDupla<T> buscar(T valor) {
        if (primeiro != null) {
            NoListaDupla<T> currentNo = primeiro;
            while (!currentNo.getInfo().equals(valor) && currentNo.getProximo() != null) {
                currentNo = currentNo.getProximo();
            }
            if (currentNo.getInfo().equals(valor)) {
                return currentNo;
            }
        }
        return null;
    }
    
    /* CORREÇAO PROFESSORA
    
    public NoListaDupla<T> buscar(T valor) {
        NoListaDupla = noAtual = primeiro;
        while(noAtual != null) {
            if (noAtual.getInfo().equals(valor) {
                return noAtual;
            }
            noAtual = noAtual.getProximo();
        }
        return null;
    }
    
    */
    
    public void retirar(T valor) {
        NoListaDupla<T> noRemovido = buscar(valor);
        
        if (noRemovido != null) {
            if (noRemovido == primeiro) {
                primeiro = noRemovido.getProximo();
            }
            else {
                noRemovido.getAnterior().setProximo(noRemovido.getProximo());
            }
            if (noRemovido.getProximo() != null) {
                noRemovido.getProximo().setAnterior(noRemovido.getAnterior());
            }
        }
    }
    
    public String exibirOrdemInversa() {
        String retorno = "";
        NoListaDupla<T> currentNo = primeiro;
        if (currentNo != null) {
            do {
                if (currentNo == primeiro) {
                    retorno += currentNo.getInfo();
                } else {
                    retorno = currentNo.getInfo()+ "," + retorno;
                }
                if (currentNo.getProximo() != null) {
                    currentNo = currentNo.getProximo();
                }
            } while (currentNo.getProximo() != null);
            
            retorno = currentNo.getInfo()+ "," + retorno;
        }
        
        return retorno;
    }
    
    /* CORREÇAO DA PROFESSORA
    
    private NoListaDupla<T> getUltimo() {
        NoListaDupla noAtual = primeiro;
        while (noAtual.getProximo != null) {
            noAtual = noAtual.getProximo();
        }
        return noAtual;
    }
    
    public String exibirOrdemInversa() {
        NoListaDupla noAtual = getUltimo();
        String dados = "";
        while (noAtual != null) {
            dados += noAtual.toString() + " ";
            noAtual = noAtual.getAnterior();
        }
        return dados;
    }
    
    */
    
    public void liberar() {
        NoListaDupla<T> lastNo = primeiro;
        NoListaDupla<T> tempNo;
        while (lastNo.getProximo() != null) {
            lastNo = lastNo.getProximo();
        }
        while (lastNo != primeiro) {
            tempNo = lastNo.getAnterior();
            lastNo.setAnterior(null);
            if (lastNo.getProximo() != null) {
                lastNo.setProximo(null);
            }
            lastNo = tempNo;
        }
        
        primeiro.setProximo(null);
        primeiro = null;
    }
    
    /* CORREÇAO DA PROFESSORA
    
    public void liberar() {
        NoListaDupla noAtual = primeiro;
        while (noAtual.getProximo != null) {
            noAtual.setAnterior(null);
            noListaDupla noAuxiliar = noAtual.getProximo();
            noAtual.setProximo(null);
            noAtual = noAuxiliar;
        }
        if (noAtual.getProximo() == null) {
            noAtual.setAnterior(null);
        }
        primeiro = null;
    }
    
    */
    
    @Override
    public String toString() {
        String retorno = "";
        NoListaDupla<T> currentNo = primeiro;
        if (currentNo != null) {
            do {
                if (currentNo != primeiro) {
                    retorno += ",";
                }
                retorno += currentNo.getInfo();
                if (currentNo.getProximo() != null) {
                    currentNo = currentNo.getProximo();
                }
            } while (currentNo.getProximo() != null);
            
            retorno += "," + currentNo.getInfo();
            
        }
        return retorno;
    }
    
    /* CORREÇAO DA PROFESSORA
    
    @Override
    public String toString() {
        NoListaDupla noAtual = primeiro;
        String dados = "";
        while (noAtual != null) {
            dados += noAtual.toString() + ",";
            noAtual = noAtual.getProximo();
        }
        return dados;
    }
    
    */
    
}
