/*
As tarifas de um estacionamento são as seguintes:

1° e 2° hora - R$ 5,00 cada
3° e 4° hora - R$ 7,50 cada
5° hora e seguintes - R$ 10,00 cada

O número de horas a pagar é sempre inteiro e arredondado para
cima ou para baixo dependendo do tempo. Até 29 minutos depois
da chegada, arredonda-se para baixo e após 30 minutos arredonda-se
para cima. Por exemplo, quem estacionar durante 1 hora e 15 minutos
pagará por 1 hora e quem estacionar por 1 hora e 35 minutos pagará
por duas horas. Entretanto, se a pessoa permaneceu menos de 30 minutos,
também pagará por uma hora. Os horários de chegada e partida são
apresentados na forma de pares de inteiros, representando horas e
minutos. Por exemplo, o par 12 50 representará meio dia e cinquenta.

Assim, faça um algoritmo que leia os horários de chegada e de partida
e escreva na tela o tempo que ficou estacionado, e o preço a ser cobrado.
Deverá haver validação de dados. Admite-se que a chegada e a partida se
dão com intervalo não superior a 24 horas, e sempre chegam e saem no mesmo dia.
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Uni4Exe27 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        DecimalFormat df_02 = new DecimalFormat("0.00");

        System.out.println("Escolha o horário de chegada (Ex.: 12 50): ");
        int horaChegada = teclado.nextInt();
        int minutosChegada = teclado.nextInt();
        if (horaChegada >= 0 && horaChegada < 24 && minutosChegada >= 0 && minutosChegada <= 59) {
            int totalChegada = horaChegada * 60 + minutosChegada;

            System.out.println("Escolha o horário de saída: (Ex: 20 10)");
            int horaSaida = teclado.nextInt();
            int minutosSaida = teclado.nextInt();
            if (horaSaida >= 0 && horaSaida < 24 && minutosSaida >= 0 && minutosSaida <= 59) {
                int totalSaida = horaSaida * 60 + minutosSaida;

                if (totalChegada >= 0 && totalSaida <= 1439 && totalSaida > totalChegada) {
                    int tempoTotal = totalSaida - totalChegada;
                    int tarifa = 0;

                    if (tempoTotal < 150) {
                        tarifa = 1;
                    } else if (tempoTotal >= 150 && tempoTotal < 270) {
                        tarifa = 2;
                    } else if (tempoTotal >= 270) {
                        tarifa = 3;
                    }

                    int horasTotal = tempoTotal / 60;
                    int minutosTotal = tempoTotal % 60;
                    Double preçoTarifa = 0.0;
                    Double valorTotal = 0.0;
                    int horaCobrada = 0;

                    switch (tarifa) {
                        case 1: {
                            preçoTarifa = 5.0;
                            if ((minutosTotal < 30 && horasTotal == 0) || minutosTotal >= 30) {
                                valorTotal = (horasTotal + 1) * preçoTarifa;
                                horaCobrada = horasTotal + 1;
                            } else {
                                valorTotal = horasTotal * preçoTarifa;
                                horaCobrada = horasTotal;
                            }
                            System.out.println("Tempo estacionado: " + horasTotal + "h " + minutosTotal + "min");
                            System.out.println("Tempo cobrado: " + horaCobrada + "h " + "00min");
                            System.out.println("Preço Tarifa = R$5.00 / h (1ª e 2ª hora)");
                            System.out.println("Valor total = R$" + df_02.format(valorTotal));
                            break;
                        }
                        case 2: {
                            preçoTarifa = 7.5;
                            if (minutosTotal >= 30) {
                                valorTotal = 10 + (horasTotal + 1 - 2) * preçoTarifa;
                                horaCobrada = horasTotal + 1;
                            } else {
                                valorTotal = 10 + (horasTotal - 2) * preçoTarifa;
                                horaCobrada = horasTotal;
                            }
                            System.out.println("Tempo estacionado: " + horasTotal + "h " + minutosTotal + "min");
                            System.out.println("Tempo cobrado: " + horaCobrada + "h " + "00min");
                            System.out.println("Preço Tarifa = R$10 + R$7.50 / h (3ª e 4ª hora)");
                            System.out.println("Valor total = R$" + df_02.format(valorTotal));
                            break;
                        }
                        case 3: {
                            preçoTarifa = 10.0;
                            if (minutosTotal >= 30) {
                                valorTotal = 25 + (horasTotal + 1 - 4) * preçoTarifa;
                                horaCobrada = horasTotal + 1;
                            } else {
                                valorTotal = 25 + (horasTotal - 4) * preçoTarifa;
                                horaCobrada = horasTotal;
                            }
                            System.out.println("Tempo estacionado: " + horasTotal + "h " + minutosTotal + "min");
                            System.out.println("Tempo cobrado: " + horaCobrada + "h " + "00min");
                            System.out.println("Preço Tarifa = R$25.00 + R$10.00 / h (5ª hora)");
                            System.out.println("Valor total = R$" + df_02.format(valorTotal));
                            break;
                        }
                    }
                } else {
                    System.out.println("Valor(es) inválido(s). Entrada e saída devem ser no mesmo dia.");
                }
            } else {
                System.out.println("Valor(es) inválido(s)");
            }
        } else {
            System.out.println("Valor(es) inválido(s)");
        }
        teclado.close();
    }
}
