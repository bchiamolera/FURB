/*
 Descreva um algoritmo que calcule e escreva a soma da seguinte série de 100 termos:
 1/1 + 1/2 + 1/3 + 1/4 + ... + 1/100
 */
public class Uni5Exe3 {
    public static void main(String[] args) {
        double num, soma;
        soma = 0.0;
        for (num = 1.0; num <= 100.0; num++) {
            soma = soma + (1/num);
        }
        System.out.println(soma);
    }
}
