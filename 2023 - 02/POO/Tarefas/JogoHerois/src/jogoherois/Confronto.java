/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogoherois;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Confronto {
    // Métodos
    public int executar(SuperHeroi superheroi, Vilao vilao) {
        if (superheroi.getPoderTotal() < vilao.getPoderTotal()) return 0;
        return 1;
    }
}
