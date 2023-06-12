import java.util.Scanner;

public class Conecte_4 {
    public static void main(String[] args) throws Exception {
        new Conecte_4();
    }

    public Conecte_4() {
        Scanner teclado = new Scanner(System.in);

        char[][] tabuleiro = new char[6][7];
        char jogador = ' ';
        char computador = ' ';

        Criacao(tabuleiro);
        jogador = Escolha(teclado);
        if (jogador ==  'A') {
            computador =  'V';
        } else {
            computador = 'A';
        }

        Output(tabuleiro);

        teclado.close();
    }

    private void Criacao(char[][] tabuleiro) {
        for (int linhas = 0; linhas < 6; linhas++) {
            for (int colunas = 0; colunas < 7; colunas++) {
                tabuleiro[linhas][colunas] = 'B';
            }
        }
    }

    private char Escolha(Scanner teclado) {
        char op = ' ';
        boolean check = false;
        do {
            System.out.println("Escolha a sua cor: A - Amarelo; V - Vermelho");
            op = teclado.next().trim().toUpperCase().charAt(0);
            if (op == 'A' || op == 'V') {
                check = true;
            }
        } while (!check);
        return op;
    }

    private void Output(char[][] tabuleiro) {
        for (int linhas = 0; linhas < 6; linhas++) {
            for (int colunas = 0; colunas < 7; colunas++) {
                System.out.print(tabuleiro[linhas][colunas] + " ");
                ;
            }
            System.out.println();
        }
    }
}
