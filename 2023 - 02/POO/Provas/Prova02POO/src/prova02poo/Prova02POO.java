package prova02poo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Prova02POO {
    public static ArrayList<Onibus> listaOnibus = new ArrayList<>();
    public static ArrayList<Motorista> motoristas = new ArrayList<>();
    
    public static String listarPassageiros(String nome, String cnh) {
        String passageiros = "";
        for (Onibus o : listaOnibus) {
            if (o.getMotorista().getNome().trim().toLowerCase().equals(nome.trim().toLowerCase())
                && o.getMotorista().getCnh().trim().toLowerCase().equals(cnh.trim().toLowerCase())) {
                passageiros += o.listarPassageiros();
            }
        }
        if (passageiros.equals("")) passageiros = "Sem passageiros";
        return passageiros;
    }
    
    public static int contarAposentados() {
        int numAposentados = 0;
        for (Onibus o : listaOnibus) {
            for (Passageiro p : o.passageiros) {
                if (p instanceof Aposentado) numAposentados++;
            }
        }
        return numAposentados;
    }
    
    public static String acharOnibusComMenosPassageiros() {
        String infoOnibusMunicipal = "Nenhum onibus municipal cadastrado.";
        String infoOnibusIntermunicipal = "Nenhum onibus intermunicipal cadastrado.";
        int menorQtdPassageiros = Integer.MAX_VALUE;
        
        for (Onibus o : listaOnibus) {
            if (o instanceof Municipal) {
                for (int i = 0; i <= o.passageiros.size(); i++) {
                    if (i == o.passageiros.size()) {
                        infoOnibusMunicipal += "\n\n" + o.toString();
                    } else if (i < menorQtdPassageiros) {
                        infoOnibusMunicipal = o.toString();
                        menorQtdPassageiros = o.passageiros.size();
                    }
                }
            } else if (o instanceof Intermunicipal) {
                for (int i = 0; i <= o.passageiros.size(); i++) {
                    if (i == o.passageiros.size()) {
                        infoOnibusIntermunicipal += "\n\n" + o.toString();
                    } else if (i < menorQtdPassageiros) {
                        infoOnibusIntermunicipal = o.toString();
                        menorQtdPassageiros = o.passageiros.size();
                    }
                }
            }
            
        }
        
        return "Onibus Municipal: \n" + infoOnibusMunicipal + "\n\nOnibus Intermunicipal: \n" + infoOnibusIntermunicipal;
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int res = 0;
        do {
            System.out.println("1. Cadastrar Onibus");
            System.out.println("2. Cadastrar Motorista");
            System.out.println("3. Adicionar Passageiro");
            System.out.println("4. Listar passageiros de um motorista");
            System.out.println("5. Ver valor arrecadado por um ônibus");
            System.out.println("6. Ver quantidade de aposentados transportados");
            System.out.println("7. Ver info dos ônibus com menos passageiros");
            System.out.println("8. Sair");
            res = s.nextInt();
            
            switch (res) {
                case 1:
                    System.out.println("Nome do motorista: ");
                    String nomeMotorista = s.next();
                    Motorista motorista = null;
                    for (Motorista m : motoristas) {
                        if (m.getNome().toLowerCase().equals(nomeMotorista.trim().toLowerCase())) {
                            motorista = m;
                            break;
                        }
                    }
                    if (motorista == null) {
                        System.out.println("Motorista não econtrado. Cadastro cancelado");
                        break;
                    }
                    System.out.println("Placa: ");
                    String placa = s.next();
                    System.out.println("Tipo: 1. Municipal // 2. Intermunicipal");
                    int tipoOnibus = s.nextInt();
                    switch (tipoOnibus) {
                        case 1:
                            listaOnibus.add(new Municipal(placa, motorista));
                            System.out.println("Onibus cadastrado com sucesso!");
                            break;
                            
                        case 2:
                            listaOnibus.add(new Intermunicipal(placa, motorista));
                            System.out.println("Onibus cadastrado com sucesso!");
                            break;
                            
                        default:
                            System.out.println("Tipo inválido, cadastro cancelado");
                    }
                    break;

                case 2:
                    System.out.println("Nome: ");
                    String nome = s.next();
                    boolean motoristaJaExiste = false;
                    for (Motorista m : motoristas) {
                        if (m.getNome().trim().toLowerCase().equals(nome.trim().toLowerCase())) {
                            motoristaJaExiste = true;
                            break;
                        }
                    }
                    if (motoristaJaExiste) {
                        System.out.println("Motorista já cadastrado");
                        break;
                    }
                    System.out.println("CNH: ");
                    String cnh = s.next();
                    motoristas.add(new Motorista(nome, cnh));
                    System.out.println("Motorista cadastrado com sucesso!");
                    break;
                    
                case 3:
                    System.out.println("Placa do ônibus: ");
                    String placaOnibus = s.next();
                    Onibus onibus = null;
                    for (Onibus o : listaOnibus) {
                        if (o.getPlaca().trim().toUpperCase().equals(placaOnibus.trim().toUpperCase())) {
                            onibus = o;
                            break;
                        }
                    }
                    if (onibus == null) {
                        System.out.println("Onibus não encontrado. Cadastro cancelado");
                        break;
                    }
                    System.out.println("Tipo de passageiro: 1. Normal // 2. Estudante // 3. Aposentado");
                    int tipoPassageiro = s.nextInt();
                    switch (tipoPassageiro) {
                        case 1:
                            System.out.println("Nome: ");
                            String nomeNormal = s.next();
                            onibus.adicionarPassageiro(new Passageiro(nomeNormal));
                            System.out.println("Passageiro cadastrado com sucesso!");
                            break;
                        case 2:
                            System.out.println("Nome: ");
                            String nomeEstudante = s.next();
                            System.out.println("Registro Acadêmico: ");
                            String registroAcademico = s.next();
                            onibus.adicionarPassageiro(new Estudante(nomeEstudante, registroAcademico));
                            System.out.println("Passageiro cadastrado com sucesso!");
                            break;
                        case 3:
                            System.out.println("Nome: ");
                            String nomeAposentado = s.next();
                            System.out.println("RG: ");
                            String rg = s.next();
                            onibus.adicionarPassageiro(new Aposentado(nomeAposentado, rg));
                            System.out.println("Passageiro cadastrado com sucesso!");
                            break;
                        default:
                            System.out.println("Tipo inválido. Cadastro cancelado");
                    }
                    break;
                    
                case 4:
                    System.out.println("Nome: ");
                    nome = s.next();
                    System.out.println("CNH: ");
                    cnh = s.next();
                    System.out.println("Passageiros: \n");
                    System.out.println(listarPassageiros(nome, cnh));
                    break;
                    
                case 5:
                    System.out.println("Placa: ");
                    placa = s.next();
                    onibus = null;
                    for (Onibus o : listaOnibus) {
                        if (o.getPlaca().trim().toUpperCase().equals(placa.trim().toUpperCase())) {          
                            onibus = o;
                            break;
                        }
                    }
                    if (onibus == null) {
                        System.out.println("Onibus não econtrado");
                        break;
                    }
                    System.out.println("Valor arrecadado: R$" + onibus.calcularTotalArrecadado());
                    break;
                    
                case 6:
                    System.out.println("Qtd. aposentados: " + contarAposentados());
                    break;
                    
                case 7:
                    System.out.println(acharOnibusComMenosPassageiros());
                    break;
                    
                case 8:
                    break;
                    
                default:
                    System.out.println("Opção inválida\n");
            }
            System.out.println();
        } while (res != 8);
    }
}
