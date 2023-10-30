/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex09;

/**
 *
 * @author Bernardo Chiamolera
 */
import java.util.HashMap;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Ex09 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        DecimalFormat dfMoney = new DecimalFormat("#,###.00");
        HashMap<String, Veiculo> v = new HashMap<>();

        Proprietario p1 = new Proprietario("Alex", "1234", "R. Tiroleses");
        Proprietario p2 = new Proprietario("Joana", "5678", "R. Sâo Paulo");
        Proprietario p3 = new Proprietario("Bianca", "1423", "R. XV de Novembro");
        Proprietario p4 = new Proprietario("Fábio", "9876", "R. Japão");

        Veiculo v1 = new Veiculo("ABC1234", 'c', 2000, 'g', 70000, p1);
        Veiculo v2 = new Veiculo("DEF5678", 'c', 700, 'g', 10000, p2);
        Veiculo v3 = new Veiculo("XYZ1234", 'p', 250, 'a', 100000, p3);
        Veiculo v4 = new Veiculo("XYZ5678", 'p', 300, 'g', 50000, p4);

        v1.addMulta(new Multa("R. 7 de Setembro", "Leve", 200, true));
        v1.addMulta(new Multa("R. Alemanha", "Leve", 200, false));
        v1.addMulta(new Multa("R. Terra", "Grave", 800, false));

        v2.addMulta(new Multa("R. Amizade", "Gravíssima", 2000, true));

        v3.addMulta(new Multa("R. Padre Eduardo", "Leve", 99.99, false));

        v4.addMulta(new Multa("R. Central", "Leve", 200, true));
        v4.addMulta(new Multa("R. Paulista", "Grave", 999.99, false));

        v.put(v1.getPlaca(), v1);
        v.put(v2.getPlaca(), v2);
        v.put(v3.getPlaca(), v3);
        v.put(v4.getPlaca(), v4);

        boolean check = true;
        while (check) {
            System.out.println("Digite uma placa: (0 para sair)");
            String placa = "";
            placa = s.next().toUpperCase();
            if (placa.equals("0")) {
                check = false;
            } else {
                try {
                    Veiculo veiculo = v.get(placa);
                    veiculo.getPlaca();
                    boolean check2 = true;
                    while (check2) {
                        System.out.println("");
                        System.out.println("1. Ver Veículo");
                        System.out.println("2. Ver Proprietário");
                        System.out.println("3. Ver Multas");
                        System.out.println("0. Sair");
                        int op = s.nextInt();
                        switch (op) {
                            case 1:
                                System.out.println(veiculo.verVeiculo());
                                break;
                            case 2:
                                System.out.println(veiculo.verProprietario());
                                break;
                            case 3:
                                System.out.println(veiculo.verMultas());
                                break;
                            case 0:
                                System.out.println("Licenciamento: R$" + dfMoney.format(veiculo.calcularLicenciamento()));
                                check2 = false;
                            default:
                        }
                    }

                } catch (Exception e) {
                    System.out.println("Placa não encontrada");
                }
            }
            System.out.println("");
        }

        s.close();
    }

}
