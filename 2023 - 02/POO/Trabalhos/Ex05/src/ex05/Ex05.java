/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex05;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Ex05 {
    public static void main(String[] args) {
        SetorPessoal sp1 = new SetorPessoal(5);
        
        sp1.addFuncionario(new Funcionario(1, "Ricardo", 1, 5000, "Programador"));
        sp1.addFuncionario(new Funcionario(2, "Bernardo", 2, 8000, "Coordenador"));
        sp1.addFuncionario(new Funcionario(3, "Yuri", 3, 5500, "Programador"));
        sp1.addFuncionario(new Funcionario(4, "João", 1, 3000, "Estagiário"));
        sp1.addFuncionario(new Funcionario(5, "Maria", 1, 10000, "Coordenador"));
        sp1.addFuncionario(new Funcionario(6, "Jonas", 2, 3000, "Programador"));
        System.out.println("");
        
        System.out.println("- Folha de Pagamento: ");
        System.out.println(sp1.getFolhaDePagamento());
        
        System.out.println("- Total da Folha:");
        System.out.println(sp1.getTotalFolha());
        System.out.println("");
        
        System.out.println("- Maior Salário:");
        System.out.println(sp1.getMaiorSalario());
        System.out.println("");
        
        System.out.println("- Funcionário(s) do departamento 1: ");
        System.out.println(sp1.getFuncionariosDepartamento(1));
        
        System.out.println("- Funcinário(s) da função Coordenador: ");
        System.out.println(sp1.getFuncionariosFuncao("Coordenador"));
        
        System.out.println("- Folha de Pagamento em ordem crescente: ");
        System.out.println(sp1.getFolhaCrescente());
    }
}
