/*
 Dado um vetor de números inteiros, com capacidade limitada a 50 elementos, faça um programa que construa
 um menu com as seguintes opções:

 - “1 – Incluir valor”: nesta opção inclua o valor no fim do vetor, se houver espaço. Informe o usuário se
 o valor foi incluído no vetor ou não;
 - “2 – Pesquisar valor”: nesta opção leia um valor e informe se o mesmo está no vetor;
 - “3 – Alterar valor”: nesta opção informe um número a ser alterado e um novo número a ser colocado no lugar
 (só para a primeira ocorrência deste número). Caso o número a ser alterado exista no vetor, substitua-o pelo
 novo número. Caso contrário, informe “número não encontrado”;
 - “4 – Excluir valor”: nesta opção leia um valor e, caso ele esteja no vetor, exclua-o. Informe o usuário
 se o valor foi excluído do vetor ou não. A posição que foi excluída o valor deve ser preenchida pelo valor
 seguinte, sucessivamente até o final dos valores do vetor;
 - “5 – Mostrar valores”: nesta opção mostre todos os valores armazenados no vetor;
 - “6 – Ordenar valores”: ordene todos os valores do vetor em ordem crescente;
 - “7 – Inverter valores”: desafio (ver abaixo);
 - “8 – Sair do sistema”: nesta opção deve ser finalizada a execução do programa.

  Faça um método para cada uma das opções do menu. O menu deve-se repetir até que o usuário escolha a
  opção 8.
 Para a opção "6 - Ordenar valores" se pode usar o "método bolha" explicado neste vídeo. Existem também
 outros vídeos que mostram a lógica de ordenação usando o "método bolha", no caso é só procurar por
 "Bubble Sort". Um deles é Bubble Sort | GeeksforGeeks. Um outro um pouco mais "divertido" procura mostrar
 a lógica usando uma coreografia de dança: Bubble sort with Hungarian, folk dance.

 Desafio: adapte o código acima para ter mais uma opção no menu para também poder inverter os elementos
 dentro de um vetor. Assim o último elemento passa a ser o primeiro, o penúltimo passa ser o segundo, e
 assim sucessivamente para todos os elementos da lista. Mas lembre, não se deve considerar o vetor inteiro,
 mas somente os elementos que já foram adicionados no vetor. Como base use o código descrito em
 vetorInverter.java.
 */

import java.util.Scanner;

public class Uni6Exe10 {
    public static void main(String[] args) throws Exception {
        new Uni6Exe10();
    }

    public Uni6Exe10() {
        Scanner teclado = new Scanner(System.in);

        int[] vetor = new int[50];
        int qt = 0;
        int op;

        do {
            Menu();
            op = teclado.nextInt();
            switch (op) {
                case 1:
                    qt = Incluir(teclado, vetor, qt);
                    break;
                case 2:
                    Pesquisar(teclado, vetor, qt);
                    break;
                case 3:
                    Alterar(teclado, vetor, qt);
                    break;
                case 4:
                    qt = Excluir(teclado, vetor, qt);
                    break;
                case 5:
                    Mostrar(vetor, qt);
                    break;
                case 6:
                    Ordenar(vetor, qt);
                    break;
                case 7:
                    Inverter(vetor, qt);
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Opção inválida.\n");
            }
        } while (op != 8);

        teclado.close();
    }

    private void Menu() {
        System.out.println("1 - Incluir valor");
        System.out.println("2 - Pesquisar valor");
        System.out.println("3 - Alterar valor");
        System.out.println("4 - Excluir valor");
        System.out.println("5 - Mostrar valores");
        System.out.println("6 - Ordenar valores");
        System.out.println("7 - Inverter valores");
        System.out.println("8 - Sair do sistema");
    }

    private int Incluir(Scanner teclado, int[] vetor, int qt) {
        if (qt < 50) {
            System.out.println("Informe o número que deseja adicionar");
            vetor[qt] = teclado.nextInt();
            System.out.println("Número adicionado.\n");
            qt++;
            return qt;
        } else {
            System.out.println("Vetor cheio.\n");
        }
        return qt;
    }

    private void Pesquisar(Scanner teclado, int[] vetor, int qt) {
        System.out.println("Informe o número que deseja pesquisar:");
        int num = teclado.nextInt();
        boolean check = false;
        for (int i = 0; i < qt; i++) {
            if (num == vetor[i]) {
                check = true;
                System.out.println("O número está no vetor.\n");
                break;
            }
        }
        if (!check) {
            System.out.println("O número não está no vetor.\n");
        }
    }

    private void Alterar(Scanner teclado, int[] vetor, int qt) {
        System.out.println("Que número deseja alterar?");
        int num = teclado.nextInt();
        boolean check = false;
        for (int i = 0; i < qt; i++) {
            if (num == vetor[i]) {
                System.out.println("Digite o novo número:");
                vetor[i] = teclado.nextInt();
                check = true;
                System.out.println("Alteração bem-sucedida.\n");
                break;
            }
        }
        if (!check) {
            System.out.println("Número não existe no vetor.\n");
        }
    }

    private int Excluir(Scanner teclado, int[] vetor, int qt) {
        System.out.println("Que número deseja excluir?");
        int num = teclado.nextInt();
        boolean check = false;
        for (int i = 0; i < qt; i++) {
            if (num == vetor[i]) {
                vetor[i] = 0;
                if (i < 50) {
                    int j = i;
                    while (j < qt) {
                        int k = j + 1;
                        int temp = vetor[j];
                        vetor[j] = vetor[k];
                        vetor[k] = temp;
                        j++;
                    }
                }
                check = true;
                System.out.println("Exclusão bem-sucedida.\n");
                qt--;
                return qt;
            }
        }
        if (!check) {
            System.out.println("Número não existe no vetor.\n");
        }
        return qt;
    }

    private void Mostrar(int[] vetor, int qt) {
        System.out.println();
        if (qt == 0) {
            System.out.println("Vetor vazio.\n");
        } else {
            for (int i = 0; i < qt; i++) {
                System.out.print(vetor[i] + " ");
            }
            System.out.println("\n");
        }
    }

    private void Ordenar(int[] vetor, int qt) {
        int temp;
        for (int i = 0; i < qt; i++) {
            for (int j = i + 1; j < qt; j++) {
                if (vetor[j] < vetor[i]) {
                    temp = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = temp;
                }
            }
        }
        System.out.println("Ordenado.\n");
    }

    private void Inverter(int[] vetor, int qt) {
        int temp = 0;
        for (int i = 0; i < qt; i++) {
            for (int x = 0; x < i; x++) {
                temp = vetor[i];
                vetor[i] = vetor[x];
                vetor[x] = temp;
            }
         }
         System.out.println("Invertido.\n");
    }
}
