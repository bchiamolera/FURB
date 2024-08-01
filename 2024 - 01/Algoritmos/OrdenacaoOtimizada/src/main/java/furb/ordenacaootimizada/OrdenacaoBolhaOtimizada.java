/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.ordenacaootimizada;

/**
 *
 * @author Bernardo Chiamolera
 */
public class OrdenacaoBolhaOtimizada<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        T[] info = this.getInfo();
        int i, j;
        int n = info.length;
        boolean trocou;
        
        // Começando pelo final da lista, percorrese do início até a posição atual; depois diminui-se a posição atual até chegar em 0.
        for (i = n - 1; i > 0; i--) {
            // Cada vez que diminuir i, trocou = false.
            trocou = false;
            // Loop que percorre do início da lista até i;
            for (j = 0; j < i; j++) {
                // Compara o conteúdo em j com o conteúdo que o sucede.
                int comparacao = info[j].compareTo(info[j + 1]);
                // Se o conteúdo em j for maior, troca de posição com o outro.
                if (comparacao > 0) {
                    trocar(j, j + 1);
                    trocou = true;
                }
            }
            // Interrompe o algoritmo se não houver troca. Significa que a lista já está organizada.
            if (!trocou) {
                return;
            }
        }
    }
    
}
