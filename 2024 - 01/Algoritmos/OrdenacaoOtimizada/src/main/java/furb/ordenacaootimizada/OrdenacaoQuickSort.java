/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.ordenacaootimizada;

/**
 *
 * @author Bernardo Chiamolera
 */
public class OrdenacaoQuickSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        int n = this.getInfo().length - 1;
        quickSort(0, n);
    }
    
    // Função recursiva para escolher o pivô, dividir em 2 sub-vetores e ordená-los;
    private void quickSort(int inicio, int fim) {
        if (inicio < fim) {
            int idxPivo = particionar(inicio, fim);
            quickSort(inicio, idxPivo - 1);
            quickSort(idxPivo + 1, fim);
        }
    }
    
    // Função recursiva para escolher o pivô e dividir o vetor principal em 2 sub-vetores,
    // um com os valores menores que o pivô e outro com os valores maiores;
    private int particionar(int inicio, int fim) {
        int a = inicio;
        int b = fim + 1;
        T[] info = this.getInfo();
        T pivo = info[inicio];
        
        while (true) {
            // aumenta a posição A até chegar ao fim ou o valor nessa posição ser maior que o do pivo.
            do {
                a++;
            } while (a <= fim && info[a].compareTo(pivo) < 0);
            
            // diminui a posição B até chegar ao inicio ou o valor nessa posição ser menor que o do pivo.
            do {
                b--;
            } while (b >= inicio && info[b].compareTo(pivo) > 0);
            
            // se a posição A for maior ou igual que a posição B, percorreu-se a lista inteira até o ponto de encontro; 
            if (a >= b) {
                break;
            }
            // Senão, troca os valores de A e B. Dessa forma, os valores menores que o pivô ficam a sua esquerda, e os maiores a sua direita;
            trocar(a,b);
        }
        // b é a posição do pivô, coloca-se ele no início da lista e retorna sua posição
        trocar(b, inicio);
        return b;
    }
}
