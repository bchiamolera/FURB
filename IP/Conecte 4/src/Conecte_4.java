import java.util.Scanner;

public class Conecte_4 {
    public static void main(String[] args) throws Exception {
        new Conecte_4();
    }

    public Conecte_4() {
        Scanner teclado = new Scanner(System.in);

        char[][] tabuleiro = new char[6] [7];
        criacao(tabuleiro);
        output(tabuleiro);

        teclado.close();
    }

    private void criacao(char[][] tabuleiro) {
        for (int linhas = 0; linhas < 6; linhas++) {
            for (int colunas = 0; colunas < 7; colunas++) {
                tabuleiro[linhas][colunas] = 'B';
            }
        }
    }

    private void output(char[][] tabuleiro) {
        for (int linhas = 0; linhas < 6; linhas++) {
            for (int colunas = 0; colunas < 7; colunas++) {
                System.out.print(tabuleiro[linhas][colunas] + " ");;
            }
            System.out.println();
        }
    }
}
