// int rand = (int) Math.random() * 7;

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
        boolean fim = false;
        int[] camadaColuna = {5, 5, 5, 5, 5, 5, 5};

        Criacao(tabuleiro);
        jogador = EscolhaCor(teclado);
        if (jogador == 'A') {
            computador = 'V';
        } else {
            computador = 'A';
        }

        do {
            JogadaPlayer(teclado, tabuleiro, camadaColuna, jogador);
            JogadaComputador(camadaColuna, tabuleiro, computador);
            Output(tabuleiro);
            fim = ValidarVitoria(camadaColuna);

        } while (!fim);

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

    private void JogadaPlayer(Scanner teclado, char[][] tabuleiro, int[] camadaColuna, char jogador) {
        int posicao;
        boolean check = false;
        do {
            System.out.println("\nEscolha a posição de jogada (entre 1 e 7): \n(0 para ver o tabuleiro)");
            posicao = teclado.nextInt();
            if (posicao == 0) {
                Output(tabuleiro);
            } else if (posicao >= 1 && posicao <= 7) {
                posicao--;
                if (camadaColuna[posicao] >= 0) {
                    tabuleiro[camadaColuna[posicao]][posicao] = jogador;
                    camadaColuna[posicao]--;
                    check = true;
                } else {
                    System.out.println("\nJogada inválida. Coluna cheia.");
                }
            }
        } while (!check);
    }

    private void JogadaComputador(int[] camadaColuna, char[][] tabuleiro, char computador) {
        int posicaoComp = (int) (Math.random() * 7);
        boolean check = false;
        do {
            if (camadaColuna[posicaoComp] >= 0) {
                tabuleiro[camadaColuna[posicaoComp]][posicaoComp] = computador;
                camadaColuna[posicaoComp]--;
                check = true;
            }
        } while (!check);
    }

    private void Output(char[][] tabuleiro) {
        System.out.println();
        for (int linhas = 0; linhas < 6; linhas++) {
            for (int colunas = 0; colunas < 7; colunas++) {
                System.out.print(tabuleiro[linhas][colunas] + " ");
            }
            System.out.println();
        }
    }

    private boolean ValidarVitoria(int[] camadaColuna) {
        int validarEmpate = 0;
        for (int i = 0; i < camadaColuna.length; i++) {
            if (camadaColuna[i] == -1) {
                validarEmpate++;
            }
        }
        if (validarEmpate == 7) {
            System.out.println("\nEmpate.");
            return true;
        } else {
            return false;
        }
    
    }
}
