/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package furb.atividadearraylist02;

/**
 *
 * @author Bernardo Chiamolera
 */
public class AtividadeArrayList02 {

    public AtividadeArrayList02() {
        try {
            Laboratorio l1 = new Laboratorio(101);
            Laboratorio l2 = new Laboratorio(220);
            Laboratorio l3 = new Laboratorio(333);

            l1.adicionarComputador(new Computador(100, 512, 8));
            l1.adicionarComputador(new Computador(101, 256, 32));
            l2.adicionarComputador(new Computador(200, 1024, 16));
            l3.adicionarComputador(new Computador(300, 128, 4));

            l1.imprimir();
            l2.imprimir();
            l3.imprimir();
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new AtividadeArrayList02();
    }
}
