/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.ordenacao;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Ordenador<T> {
    
    private int[] info;
    
    public Ordenador(int[] info) {
        this.info = info;
    }
    
    // BubbleSort
    public void bubbleSort() {
        for (int i = info.length - 1; i > 0; i--) {
            for (int j = 0; j < info.length - 1; j++) {
                if ((float) info[j] > (float) info[j +1]) {
                    trocar(j, j + 1);
                }
            }
        }
    }

    private void trocar(int pos1, int pos2) {
        int temp = info[pos1];
        info[pos1] = info[pos2];
        info[pos2] = temp;
    }
    
    // QuickSort
    public void quickSort() {
        int n = info.length - 1;
        quickSort(0, n);
    }
    
    private void quickSort(int inicio, int fim) {
        if (inicio < fim) {
            int indexPivo = particionar(inicio, fim);
            quickSort(inicio, indexPivo - 1);
            quickSort(indexPivo + 1, fim);
        }
    }
    
    private int particionar(int inicio, int fim) {
        int a = inicio;
        int b = fim + 1;
        int pivo = info[inicio];
        
        while(true) {
            do {
                a += 1;
            } while (a <= fim && (float) info[a] < (float) pivo);
            do {
                b -= 1;
            } while (b >= inicio && (float) info[b] > (float) pivo);
            if (a >= b) {
                break;
            }
            trocar(a, b);
        }
        
        trocar (b, inicio);
        return b;
    }
    
    // MergeSort
    public void mergeSort() {
        int n = info.length - 1;
        mergeSort(0, n);
    }
    
    private void mergeSort(int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(inicio, meio);
            mergeSort(meio + 1, fim);
            merge(inicio, fim, meio);
        }
    }
    
    private void merge(int inicio, int fim, int meio) {
        int tamEsquerda = meio - inicio + 1;
        int[] esquerda = new int[tamEsquerda];
        for (int i = 0; i < tamEsquerda; i++) {
            esquerda[i] = info[inicio + i];
        }
        
        int tamDireita = fim - meio;
        int[] direita = new int[tamDireita];
        for (int i = 0; i < tamDireita; i++) {
            direita[i] = info[meio + 1 + i];
        }
        
        int cEsq = 0;
        int cDir = 0;
        int indx = 0;
        
        for (int i = inicio; i <= fim; i++) {
            indx = i;
            if (cEsq < tamEsquerda && cDir < tamDireita) {
                if ((float) esquerda[cEsq] < (float) direita[cDir]) {
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
        }
        
        while (cEsq < tamEsquerda) {
            info[indx] = esquerda[cEsq];
            cEsq++;
            indx++;
        }
        
        while (cDir < tamDireita) {
            info[indx] = direita[cDir];
            cDir++;
            indx++;
        }
    }

    public int[] getInfo() {
        return info;
    }

    public void setInfo(int[] info) {
        this.info = info;
    }
}
