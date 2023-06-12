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
        boolean vitoria = false;
        int posicao;

        Criacao(tabuleiro);
        jogador = EscolhaCor(teclado);
        if (jogador ==  'A') {
            computador =  'V';
        } else {
            computador = 'A';
        }

        do {
            posicao = EscolhaPosicao(teclado, tabuleiro, jogador, computador);
            Jogada(posicao, tabuleiro, jogador, computador);
        } while (!vitoria);

        teclado.close();
    }

    private void Criacao(char[][] tabuleiro) {
        for (int linhas = 0; linhas < 6; linhas++) {
            for (int colunas = 0; colunas < 7; colunas++) {
                tabuleiro[linhas][colunas] = 'B';
            }
        }
    }

    private char EscolhaCor(Scanner teclado) {
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

    private int EscolhaPosicao(Scanner teclado, char[][] tabuleiro, char jogador, char computador) {
        int posicao = -1;
        boolean check = false;
        do {
            System.out.println("\nEscolha a posição de jogada (entre 1 e 7): \n(0 para ver o tabuleiro)");
            posicao = teclado.nextInt();
            if (posicao == 0) {
                System.out.println();
                Output(tabuleiro);
            } else if (posicao >= 1 && posicao <= 7) {
                check = true;
            }
        } while (!check);
        return posicao;
    }
    
    private void Jogada(int posicao, char[][] tabuleiro, char jogador, char computador) {

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
