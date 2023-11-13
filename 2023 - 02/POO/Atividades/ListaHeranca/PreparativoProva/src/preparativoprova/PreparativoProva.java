package preparativoprova;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Bernardo Chiamolera
 */
public class PreparativoProva {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Consulta> consultas = new ArrayList<>();
        consultas.add(new Consulta("123",
                new Paciente("Hermes", new Ouro("Unimed", 1999, 3)),
                new Medico("Francisco", "12345", "Cardiologia"),
                "02/10/2023"));

        consultas.add(new Consulta("456",
                new Paciente("Bernardo", new Ouro("Bradesco Saúde", 2005, 1)),
                new Medico("Klaus", "25012", "Gastroenterologia"),
                "01/05/2023"));

        consultas.add(new Consulta("456",
                new Paciente("Monica", new Prata("Amil", 1995, 2)),
                new Medico("Cristiano", "43632", "Pneumologia"),
                "05/12/2023"));

        consultas.add(new Consulta("456",
                new Paciente("João", new Prata("SulAmérica", 2010, 1)),
                new Medico("Maria", "87693", "Odontologia"),
                "27/04/2023"));

        // mostrar a(s) consulta(s) que pagaram o menor valor[
        double menorValor = Double.MAX_VALUE;
        String infConsulta = "";
        for (Consulta c : consultas) {
            if (c.getValor() == menorValor) {
                infConsulta += c.toString() + "\n";
            }
            if (c.getValor() < menorValor) {
                infConsulta = "\n" + c.toString() + "\n";
                menorValor = c.getValor();
            }
        }
        System.out.println("Consulta(s) de menor valor: ");
        System.out.println("-------------------------");
        System.out.println(infConsulta);
        System.out.println("-------------------------\n\n");

        // mostrar todas as consultas feitas por um determinado Paciente. Ao final, mostre o somatório total das consultas
        String nomePaciente = "Bernardo";
        String infConsultasPaciente = "";
        int numConsultas = 0;
        for (Consulta c : consultas) {
            if (c.getPaciente().getNome().toLowerCase().equals(nomePaciente.trim().toLowerCase())) {
                infConsultasPaciente += "\n" + c.toString() + "\n";
                numConsultas++;
            }
        }
        System.out.println("Consultas do paciente " + nomePaciente + ": ");
        System.out.println("-------------------------");
        System.out.println(infConsultasPaciente);
        System.out.println("Total de consultas: " + numConsultas);
        System.out.println("-------------------------\n\n");

        // mostrar as informações de todos o(s) paciente(s) de um determinado tipo de Plano (Prata ou Ouro)
        String infPacientesOuro = "";
        String infPacientesPrata = "";
        for (Consulta c : consultas) {
            if (c.getPaciente().getPlano() instanceof Ouro) {
                infPacientesOuro += "\n" + c.getPaciente().toString() + "\n";
            }
            if (c.getPaciente().getPlano() instanceof Prata) {
                infPacientesPrata += "\n" + c.getPaciente().toString() + "\n";
            }
        }
        System.out.println("Informações dos paciente de plano Ouro: ");
        System.out.println("-------------------------");
        System.out.println(infPacientesOuro);
        System.out.println("-------------------------\n\n");
        System.out.println("Informações dos paciente de plano Prata: ");
        System.out.println("-------------------------");
        System.out.println(infPacientesPrata);
        System.out.println("-------------------------\n\n");

        // mostrar quantos paciente(s) possuem o plano Prata - Ouro (ex.: Quantidade de pacientes que 
        // possuem plano Prata: X, Quantidade de pacientes que possuem plano Ouro: Y)
        int qtdPacientesOuro = 0;
        int qtdPacientesPrata = 0;
        for (Consulta c : consultas) {
            if (c.getPaciente().getPlano() instanceof Ouro) {
                qtdPacientesOuro++;
            }
            if (c.getPaciente().getPlano() instanceof Prata) {
                qtdPacientesPrata++;
            }
        }
        System.out.println("Quantidade de pacientes que possuem plano Prata: " + qtdPacientesPrata);
        System.out.println("Quantidade de pacientes que possuem plano Ouro: " + qtdPacientesOuro + "\n\n");
        System.out.println("-------------------------\n\n");

        // mostrar todas as consultas do(s) paciente(s) que possuem plano Ouro e que se tratam/trataram com 
        // médicos especialistas em Gastroenterologia
        String infPacienteOuroGastro = "";
        for (Consulta c : consultas) {
            if ((c.getPaciente().getPlano() instanceof Ouro) && (c.getMedico().getEspecialidade().toLowerCase().equals("gastroenterologia"))) {
                infPacienteOuroGastro += "\n" + c.toString() + "\n";
            }
        }
        System.out.println("Consultas de pacientes Ouro com gastroenterologistas: ");
        System.out.println("-------------------------");
        System.out.println(infPacienteOuroGastro);
        System.out.println("-------------------------\n\n");
        
        for (Consulta c : consultas) {
            if (c.getPaciente().getPlano() instanceof Ouro) {
                // Aplica o código...
            }
        }
    }
}
