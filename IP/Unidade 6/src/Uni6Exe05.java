
/*
Com o objetivo de determinar o índice de afinidade entre um rapaz e uma moça cada um respondeu um questionário
com 5 perguntas, como por exemplo:

- Gosta de música sertaneja?
- Gosta de futebol?
- Gosta de seriados?
- Gosta de redes sociais?
- Gosta da Oktoberfest?

A resposta a cada pergunta pode ser: SIM, NÃO ou IND (indiferente). O índice de afinidade é medido da seguinte
maneira:

- se ambos deram a mesma resposta soma-se 3 pontos ao índice;
- se um respondeu IND e o outro SIM ou NÃO soma-se 1;
- se um respondeu SIM e o outro NÃO subtrai-se 2 ao índice.

Crie um vetor para armazenar as respostas do rapaz e outro para armazenar as respostas da moça. Crie um
método que possa ler tanto as respostas do rapaz como da moça, e outro para calcular e retornar a afinidade.
Por fim, escreva a afinidade considerando os seguintes intervalos:

 Afinidade  |	         Mensagem
    15	    |             “Casem!”
  10 a 14	| “Vocês têm muita coisa em comum!”
   5 a 9	|     “Talvez não dê certo :(”
   0 a 4	|       “Vale um encontro.”
  -1 a -9	|    “Melhor não perder tempo”
   -10	    |       “Vocês se odeiam!”

 */
import java.util.Scanner;

public class Uni6Exe05 {
    public static void main(String[] args) {
        new Uni6Exe05();
    }

    public Uni6Exe05() {
        Scanner teclado = new Scanner(System.in);
        char[] respostasRapaz = new char[5];
        char[] respostasMoca = new char[5];
        Ler(teclado, respostasRapaz, respostasMoca);
        Escrever(CalcularAfinidade(respostasRapaz, respostasMoca));
        teclado.close();
    }

    private void Ler(Scanner teclado, char[] respostasRapaz, char[] respostasMoca) {
        String[] perguntas = { "Gosta de música sertaneja?", "Gosta de futebol?", "Gosta de seriados?",
                "Gosta de redes sociais?", "Gosta da Oktoberfest?" };
        System.out.println("Respostas do Rapaz: ");
        for (int i = 0; i < respostasRapaz.length; i++) {
            int validacao = 0;
            do {
                System.out.println(perguntas[i] + " s = Sim; n = Não; i = Indiferente");
                respostasRapaz[i] = teclado.nextLine().trim().toLowerCase().charAt(0);
                if (respostasRapaz[i] == 's' || respostasRapaz[i] == 'n' || respostasRapaz[i] == 'i') {
                    validacao++;
                }
            } while (validacao == 0);
        }
        System.out.println();
        System.out.println("Respostas da Moça");
        for (int i = 0; i < respostasMoca.length; i++) {
            int validacao = 0;
            do {
                System.out.println(perguntas[i] + " s = Sim; n = Não; i = Indiferente");
                respostasMoca[i] = teclado.nextLine().trim().toLowerCase().charAt(0);
                if (respostasMoca[i] == 's' || respostasMoca[i] == 'n' || respostasMoca[i] == 'i') {
                    validacao++;
                }
            } while (validacao == 0);
        }
    }

    private int CalcularAfinidade(char[] respostasRapaz, char[] respostasMoca) {
        int afinidade = 0;
        for (int i = 0; i < respostasRapaz.length; i++) {
            if (respostasRapaz[i] == respostasMoca[i]) {
                afinidade += 3;
            } else if (respostasRapaz[i] == 'i' || respostasMoca[i] == 'i') {
                afinidade += 1;
            } else {
                afinidade -= 2;
            }
        }
        return afinidade;
    }

    private void Escrever(int afinidade) {
        if (afinidade == 15) {
            System.out.println("Casem!");
        } else if (afinidade >= 10) {
            System.out.println("Vocês têm muita coisa em comum!");
        } else if (afinidade >= 5) {
            System.out.println("Talvez não dê certo :(");
        } else if (afinidade >= 0) {
            System.out.println("Vale um encontro.");
        } else if (afinidade > -10) {
            System.out.println("Melhor não perder tempo");
        } else {
            System.out.println("Vocês se odeiam!");
        }
    }
}
