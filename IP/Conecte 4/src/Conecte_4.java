import java.util.Scanner;

public class Conecte_4 {
    public static void main(String[] args) throws Exception {
        new Conecte_4();
    }

    public Conecte_4() {
        Scanner teclado = new Scanner(System.in);
        boolean check = false;
        
        do {
        char[][] tabuleiro = new char[6][7];
        char jogador;
        char computador;
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
            fim = ValidarVitoria(camadaColuna, tabuleiro, jogador, computador);
            if (!fim) {
                JogadaComputador(camadaColuna, tabuleiro, computador);
                fim = ValidarVitoria(camadaColuna, tabuleiro, jogador, computador);
            }
        } while (!fim);
        Output(tabuleiro);
        check = JogarNovamente(teclado);
    } while (!check);

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
        char op;
        boolean check = false;
        do {
            System.out.println("\nEscolha a sua cor: A - Amarelo; V - Vermelho");
            op = teclado.next().trim().toUpperCase().charAt(0);
            if (op == 'A' || op == 'V') {
                check = true;
            }
        } while (!check);
        return op;
    }

    private void JogadaPlayer(Scanner teclado, char[][] tabuleiro, int[] camadaColuna, char jogador) {
        int posicaoJogador;
        boolean check = false;
        do {
            System.out.println("\nEscolha a posição de jogada (entre 1 e 7): \n(0 para ver o tabuleiro)");
            posicaoJogador = teclado.nextInt();
            if (posicaoJogador == 0) {
                Output(tabuleiro);
            } else if (posicaoJogador >= 1 && posicaoJogador <= 7) {
                posicaoJogador--;
                if (camadaColuna[posicaoJogador] >= 0) {
                    tabuleiro[camadaColuna[posicaoJogador]][posicaoJogador] = jogador;
                    camadaColuna[posicaoJogador]--;
                    check = true;
                } else {
                    System.out.println("\nJogada inválida. Coluna cheia.");
                }
            }
        } while (!check);
    }

    private void JogadaComputador(int[] camadaColuna, char[][] tabuleiro, char computador) {
        boolean check = false;
        do {
            int posicaoComp = (int) (Math.random() * 7);
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

    private boolean ValidarVitoria(int[] camadaColuna, char[][] tabuleiro, char jogador, char computador) {
        int validarEmpate = 0;
        int validarJogador = 0;
        int validarComputador = 0;
        for (int i = 0; i < camadaColuna.length; i++) {
            if (camadaColuna[i] == -1) {
                validarEmpate++;
            }
        }
        if (validarEmpate == 7) {
            System.out.println("\nEMPATE");
            return true;
        } else {
            // VALIDACAO HORIZONTAL JOGADOR
            for (int linhas = 0; linhas < 6; linhas++) {
                for (int colunas = 0; colunas < 7; colunas++) {
                    if (tabuleiro[linhas][colunas] == jogador){
                        validarJogador++;
                        if (validarJogador == 4) {
                            System.out.println("\nVOCÊ VENCEU!");
                            return true;
                        }
                    } else {
                        validarJogador = 0;
                    }
                }
            }

            // VALIDACAO HORIZONTAL COMPUTADOR
            for (int linhas = 0; linhas < 6; linhas++) {
                for (int colunas = 0; colunas < 7; colunas++) {
                    if (tabuleiro[linhas][colunas] == computador){
                        validarComputador++;
                        if (validarComputador == 4) {
                            System.out.println("\nVOCÊ PERDEU!");
                            return true;
                        }
                    } else {
                        validarComputador = 0;
                    }
                }
            }

            // VALIDACAO VERTICAL JOGADOR 
            for (int colunas = 0; colunas < 7; colunas++) {
                for (int linhas = 0; linhas < 6; linhas++) {
                    if (tabuleiro[linhas][colunas] == jogador){
                        validarJogador++;
                        if (validarJogador == 4) {
                            System.out.println("\nVOCÊ VENCEU!");
                            return true;
                        }
                    } else {
                        validarJogador = 0;
                    }
                }
            }

            // VALIDACAO VERTICAL COMPUTADOR
            for (int colunas = 0; colunas < 7; colunas++) {
                for (int linhas = 0; linhas < 6; linhas++) {
                    if (tabuleiro[linhas][colunas] == computador){
                        validarComputador++;
                        if (validarComputador == 4) {
                            System.out.println("\nVOCÊ PERDEU!");
                            return true;
                        }
                    } else {
                        validarComputador = 0;
                    }
                }
            }

        // VALIDACAO DIAGONAL PARA ESQUERDA JOGADOR
            for (int linhas = 0; linhas < tabuleiro.length - 3; linhas++) {
                for (int colunas = 0; colunas < tabuleiro[0].length - 3; colunas ++) {
                    if (tabuleiro[linhas][colunas] == jogador &&
                        tabuleiro[linhas + 1][colunas + 1] == jogador &&
                        tabuleiro[linhas + 2][colunas + 2] == jogador &&
                        tabuleiro[linhas + 3][colunas + 3] == jogador) {
                            System.out.println("\nVOCÊ GANHOU!");
                            return true;
                    }
                }
            }

        // VALIDACAO DIAGONAL PARA ESQUERDA COMPUTADOR
        for (int linhas = 0; linhas < tabuleiro.length - 3; linhas++) {
            for (int colunas = 0; colunas < tabuleiro[0].length - 3; colunas ++) {
                if (tabuleiro[linhas][colunas] == computador &&
                    tabuleiro[linhas + 1][colunas + 1] == computador &&
                    tabuleiro[linhas + 2][colunas + 2] == computador &&
                    tabuleiro[linhas + 3][colunas + 3] == computador) {
                        System.out.println("\nVOCÊ PERDEU!");
                        return true;
                }
            }
        }

        // VALIDACAO DIAGONAL PARA DIREITA JOGADOR
        for (int linhas = 3; linhas < tabuleiro.length; linhas++) {
            for (int colunas = 0; colunas < tabuleiro[0].length - 3; colunas ++) {
                if (tabuleiro[linhas][colunas] == jogador &&
                    tabuleiro[linhas - 1][colunas + 1] == jogador &&
                    tabuleiro[linhas - 2][colunas + 2] == jogador &&
                    tabuleiro[linhas - 3][colunas + 3] == jogador) {
                        System.out.println("\nVOCÊ GANHOU!");
                        return true;
                }
            }
        }

        // VALIDACAO DIAGONAL PARA DIREITA COMPUTADOR
        for (int linhas = 3; linhas < tabuleiro.length; linhas++) {
            for (int colunas = 0; colunas < tabuleiro[0].length - 3; colunas ++) {
                if (tabuleiro[linhas][colunas] == computador &&
                    tabuleiro[linhas - 1][colunas + 1] == computador &&
                    tabuleiro[linhas - 2][colunas + 2] == computador &&
                    tabuleiro[linhas - 3][colunas + 3] == computador) {
                        System.out.println("\nVOCÊ PERDEU!");
                        return true;
                }
            }
        }
        }
        return false;
    }

    private boolean JogarNovamente(Scanner teclado) {
        int op = 0;
        boolean check = false;
        do {
            System.out.println("\nDeseja jogar novamente?\n1. Sim   2. Não");
            op = teclado.nextInt();
            if (op == 1 || op == 2) {
                check = true;
            } else {
                System.out.println("Opção inválida.");
            }
        } while (!check);
        if (op == 1) {
            return false;
        }
        return true;
    }
}
