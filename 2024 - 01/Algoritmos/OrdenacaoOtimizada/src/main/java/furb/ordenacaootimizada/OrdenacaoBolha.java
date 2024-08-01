/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.ordenacaootimizada;

/**
 *
 * @author Bernardo Chiamolera
 */
public class OrdenacaoBolha<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        T[] info = this.getInfo();
        
        // Começando pelo final da lista, percorrese do início até a posição atual; depois diminui-se a posição atual até chegar em 0.
        for (int i = info.length - 1; i > 0; i--) {
            // Loop que percorre do início da lista até i;
            for (int j = 0; j < i; j++) {
                // Compara o conteúdo em j com o conteúdo que o sucede.
                int comparacao = info[j].compareTo(info[j + 1]);
                // Se o conteúdo em j for maior, troca de posição com o outro. Isso faz com que os contepudos de maior valor fiquem por último.
                if (comparacao > 0) {
                    trocar(j, j + 1);
                }
            }
        }
    }
    
}
