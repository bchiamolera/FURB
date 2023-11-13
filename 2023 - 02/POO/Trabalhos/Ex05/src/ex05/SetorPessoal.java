/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex05;

/**
 *
 * @author Bernardo Chiamolera
 */
public class SetorPessoal {
    private Funcionario[] funcionarios;
    private int index;

    public SetorPessoal(int numFuncionarios) {
        setFuncionarios(numFuncionarios);
        setIndex(0);
    }

    public Funcionario[] getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(int numFuncionarios) {
        this.funcionarios = new Funcionario[numFuncionarios];
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    public void addFuncionario(Funcionario funcionario) {
        if (getIndex() < getFuncionarios().length) {
            funcionarios[index] = funcionario;
            setIndex(getIndex() + 1);
            System.out.println("Funcionario cadastrado");
        } else {
            System.out.println("Máximo de funcionários cadastrados");
        }
    }
    
    public String getFolhaDePagamento() {
        String str = "";
        for (Funcionario funcionario : funcionarios) {
            str += "Nome: " + funcionario.getNome() + "\nSalário: R$" + funcionario.getSalario() + "\n\n";
        }
        return str;
    }
    
    public double getTotalFolha() {
        double total = 0;
        for (Funcionario funcionario : funcionarios) {
            total += funcionario.getSalario();
        }
        return total;
    }
    
    public String getMaiorSalario() {
        double maior = 0;
        String func = "";
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getSalario() > maior) {
                maior = funcionario.getSalario();
                func = funcionario.getNome();
            }
            else if (funcionario.getSalario() == maior) {
                func += "\n" + funcionario.getNome();
            }
        }
        return "Nome(s):" + func + "\nSalário: R$" + maior;
    }
    
    public String getFuncionariosDepartamento(int departamento) {
        String str = "";
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getDepartamento() == departamento) {
                str += "Nome: " + funcionario.getNome() + "\nFunção: " + funcionario.getFuncao() + "\n\n";
            }
        }    
        return str;
    }
    
    public String getFuncionariosFuncao(String funcao) {
        String str = "";
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getFuncao().trim().toLowerCase().equals(funcao.trim().toLowerCase())) {
                str += "Nome: " + funcionario.getNome() + "\n";
            }
        }    
        return str;
    }
    
    public String getFolhaCrescente() {
        Funcionario[] cresc = funcionarios;
        Funcionario temp;
        for (int i = 0; i < cresc.length; i++) {
            for (int j = i; j < cresc.length; j++) {
                if (i != j && cresc[i].getSalario() > cresc[j].getSalario()) {
                    temp = cresc[j];
                    cresc[j] = cresc[i];
                    cresc[i] = temp;
                }
            }
        }
        
        String str = "";
        for (Funcionario func : cresc) {
            str += "Nome: " + func.getNome() + "\nSalário: R$" + func.getSalario() + "\n\n";
        }
        return str;
    }
    
}
