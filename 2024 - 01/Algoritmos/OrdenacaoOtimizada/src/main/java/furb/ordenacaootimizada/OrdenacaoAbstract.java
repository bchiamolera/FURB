/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.ordenacaootimizada;

/**
 *
 * @author Bernardo Chiamolera
 */
public abstract class OrdenacaoAbstract<T extends Comparable<T>> {
    private T[] info;

    public T[] getInfo() {
        return info;
    }

    public void setInfo(T[] info) {
        this.info = info;
    }
    
    // Troca a posição do conteúdo em A com a posição do conteúdo em B
    public void trocar(int a, int b) {
        T temp = info[a];
        info[a] = info[b];
        info[b] = temp;
    }
    
    public abstract void ordenar();
}
