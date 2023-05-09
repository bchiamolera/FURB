import java.util.Scanner;

public class Uni4Uri1046 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        int start = teclado.nextInt();
        int end = teclado.nextInt();
        int tempo = 0;
    
        if (start > end) {
            tempo = (end + 24) - start;
        } else if (start < end) {
            tempo = end - start;
        } else if (start == end) {
            tempo = 24;
        }
        System.out.println("O JOGO DUROU " + tempo + " HORA(S)");

        teclado.close();
    }
}
