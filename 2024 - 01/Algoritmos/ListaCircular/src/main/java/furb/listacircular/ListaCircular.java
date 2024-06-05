/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package furb.listacircular;

/**
 *
 * @author Bernardo Chiamolera
 */
public class ListaCircular<T> {

    private NoLista<T> primeiro;
    private NoLista<T> ultimo;

    public ListaCircular() {
        this.primeiro = null;
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }
    
    public NoLista<T> getUltimo() {
        return ultimo;
    }
    
    public void inserir(T valor) {
        NoLista<T> novoNo = new NoLista<>();
        novoNo.setInfo(valor);
        
        if (primeiro != null) {
            novoNo.setProximo(primeiro);
        }
        
        if (ultimo == null) {
            ultimo = novoNo;
        }
        primeiro = novoNo;
        ultimo.setProximo(primeiro);
    }
    
    public NoLista<T> buscar(T valor) {
        
        if (primeiro != null) {
            NoLista<T> currentNo = primeiro;
            do {
                
                if (currentNo.getInfo().equals(valor)) {
                    return currentNo;
                }
                currentNo = currentNo.getProximo();
            } while (currentNo != primeiro);
        }
        return null;
    }
    
    public void retirar(T valor) {
        NoLista<T> removedNo = buscar(valor);
        
        if (removedNo != null) {
            
            if (removedNo == primeiro && removedNo == ultimo) {
                primeiro = null;
                ultimo = null;
            }
            
            else {
                
                if (removedNo == primeiro) {
                    primeiro = removedNo.getProximo();
                    ultimo.setProximo(primeiro);
                }
                else {
                    NoLista<T> previousNo = primeiro;
                    while (previousNo != ultimo) {
                        if (previousNo.getProximo().equals(removedNo)) {
                            
                            previousNo.setProximo(removedNo.getProximo());    
                            if(removedNo == ultimo) {
                                    ultimo = previousNo;
                            }
                            return;
                        }
                        previousNo = previousNo.getProximo();
                    }

                    
                    
                }
                
            }
            
        }
    }
    
    public void liberar() {
        
        if (primeiro != null) {
            NoLista<T> currentNo = primeiro;
            do {
                NoLista<T> tempNo = currentNo.getProximo();
                currentNo.setProximo(null);
                currentNo = tempNo;
            } while (currentNo != primeiro);

            primeiro = null;
            ultimo = null;
        }   
    }
    
    @Override
    public String toString() {
        String retorno = "";
        NoLista<T> currentNo = primeiro;
        
        if (currentNo != null) {
            do {
                if (currentNo == ultimo) {
                    retorno +=  currentNo;
                } else {
                    retorno += currentNo.toString() + ",";
                }
                currentNo = currentNo.getProximo();
            } while (currentNo != primeiro);
        }
        return retorno;
    }
}
