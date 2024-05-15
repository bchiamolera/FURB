
/*
 Uma máquina de biscoito está com problemas. Quando ligada, após 1 hora ela quebra
 1 biscoito, na segunda hora ela quebra 3 biscoitos, na hora seguinte ela quebra
 3 vezes a quantidade de biscoitos quebrados na hora anterior, e assim por diante.
 Faça um algoritmo que calcule quantos biscoitos são quebrados no final de cada dia
 (a máquina opera 16 horas por dia).
 */
import java.lang.Math;

public class Uni5Exe11 {
    public static void main(String[] args) {
        double hora, biscoitos, biscoitosTotal;
        biscoitos = 0;
        biscoitosTotal = 0;
        for (hora = 1; hora <= 16; hora++) {
            if (hora == 1) {
                biscoitos = 1;
            } else {
                biscoitos = Math.pow(3, (hora - 1));
            }
            biscoitosTotal += biscoitos;
        }
        System.out.println(biscoitosTotal + " biscoitos quebrados.");
    }
}
