/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex00;

import java.text.DecimalFormat;
import ex00.professor.*;
import ex00.aviao.*;
import ex00.publicacao.*;
import ex00.animal.*;

/**
 *
 * @author Bernardo Chiamolera
 */
import java.util.ArrayList;

public class Ex00 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DecimalFormat dfMoney = new DecimalFormat("#,###.00");

        Livro umLivro = new Livro("Pinóquio", "Darkside", "1234-5678-90");
        System.out.println(umLivro.imprimir());

        System.out.println("==============================");

        Revista umaRevista = new Revista("Recreio", "Abril", "Semanal");
        System.out.println(umaRevista.imprimir());

        System.out.println("===============================");

        Bombardeiro umAviao = new Bombardeiro("Vermelho");

        System.out.println("===============================");

        ProfessorDE pde = new ProfessorDE("João", "1234", 30, 2500);
        ProfessorHorista ph = new ProfessorHorista("Carlos", "5678", 45, 350, 12.5);

        System.out.println(pde);
        System.out.println("-------------------------------");
        System.out.println(ph);

        System.out.println("===============================");

        ArrayList<Professor> professores = new ArrayList<>();
        professores.add(pde);
        professores.add(ph);
        for (Professor p : professores) {
            // Verificando tipo do objeto
            if (p instanceof ProfessorDE) {
                ProfessorDE pde2 = (ProfessorDE) p;
                System.out.println("R$" + dfMoney.format(pde2.getSalario()));
            } else if (p instanceof ProfessorHorista) {
                ProfessorHorista ph2 = (ProfessorHorista) p;
                System.out.println("R$" + dfMoney.format(ph2.calcularSalario()));
            }
        }

        System.out.println("===============================");

        ArrayList<Animal> zoo = new ArrayList();
        zoo.add(new Gato());
        zoo.add(new Cachorro());
        zoo.add(new Vaca());

//        for (Animal umAnimal : zoo) {
//            if (umAnimal instanceof Gato) {
//                ((Gato)umAnimal).som();
//            } else if (umAnimal instanceof Cachorro) {
//                ((Cachorro)umAnimal).som();
//            } else if (umAnimal instanceof Vaca) {
//                ((Vaca)umAnimal).som();
//            }
//        }

        for (Animal umAnimal : zoo) {
            umAnimal.som();
        }
    }
}
