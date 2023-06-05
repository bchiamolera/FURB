/*
Descreva um algoritmo que calcule e escreva a soma dos números
pares e a soma dos números ímpares entre 1 e 100.
 */
public class Uni5Exe02 {
    public static void main(String[] args) {
        int num, somaPar, somaImpar;
        somaPar = 0;
        somaImpar = 0;
        for (num = 1; num <= 100; num++) {
            if (num % 2 == 0) {
                somaPar = somaPar + num;
            } else {
                somaImpar = somaImpar + num;
            }
        }
        System.out.println("Soma dos pares: " + somaPar);
        System.out.println("Soma dos ímpares: " + somaImpar);
    }
}
