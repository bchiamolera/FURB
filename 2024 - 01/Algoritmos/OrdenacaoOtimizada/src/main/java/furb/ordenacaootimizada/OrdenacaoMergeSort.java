/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.ordenacaootimizada;

/**
 *
 * @author Bernardo Chiamolera
 */
public class OrdenacaoMergeSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        int n = this.getInfo().length - 1;
        mergeSort(0, n);
    }
    
    // Função recursiva para dividir o vetor em sub-vetores e ordenar
    private void mergeSort(int inicio, int fim) {
        if (inicio < fim) {
            // Encontrar a posição do meio da lista;
            int meio = (inicio + fim) / 2;
            // mergeSort para ordenar primeira metade;
            mergeSort(inicio, meio);
            // mergeSort para ordenar a outra metade;
            mergeSort(meio + 1, fim);
            // mesclar as duas partes ordenadas
            merge(inicio, fim, meio);
        }
    }
    
    // Função para mesclar dois vetores de forma ordenada
    private void merge(int inicio, int fim, int meio) {
        T[] info = this.getInfo();
        
        // Calcular o tamanho do vetor da esquerda;
        int tamEsquerda = meio - inicio + 1;
        // Cria-se um vetor temporário para a esquerda;
        T[] esquerda = (T[]) new Comparable[tamEsquerda];
        for (int i = 0; i < tamEsquerda; i++) {
            esquerda[i] = info[inicio + i];
        }
        
        // Calcular o tamanho do vetor da direita;
        int tamDireita = fim - meio;
        // Cria-se um vetor temporário para a direita;
        T[] direita = (T[]) new Comparable[tamEsquerda];
        for (int i = 0; i < tamDireita; i++) {
            direita[i] = info[meio + 1 + i];
        }
        
        // índices para percorrer os vetores da esquerda, direita e o principal
        int cEsq = 0;
        int cDir = 0;
        int indx = inicio;
        
        // mesclar os vetores temporários no principal;
        for (int i = inicio; i <= fim; i++) {
            // Enquanto um dos vetores temporários não acabar de se percorrido
            if (cEsq < tamEsquerda && cDir < tamDireita) {
                // Compara os valores atuais de cada vetor, o menor é adicionado na lista principal;
                if (esquerda[cEsq].compareTo(direita[cDir]) < 0) {
                    info[i] = esquerda[cEsq];
                    cEsq++;
                }
                else {
                    info[i] = direita[cDir];
                    cDir++;
                }
            }
            else {
                break;
            }
            indx++;
        }
        
        // mesclar "resto" do vetor da esquerda no vetor principal
        while (cEsq < tamEsquerda) {
            info[indx] = esquerda[cEsq];
            cEsq++;
            indx++;
        }
        // mesclar "resto" do vetor da direita no vetor principal
        while (cDir < tamDireita) {
            info[indx] = direita[cDir];
            cDir++;
            indx++;
        }
    }
}
