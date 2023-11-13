/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.aula06;

/**
 *
 * @author Bernardo Chiamolera
 */
import java.util.ArrayList;

public class Turma {

    private ArrayList<Pessoa> alunos;

    public Turma() {
        this.alunos = new ArrayList<Pessoa>();
    }

    // public void addPessoa(String nome)
    public void addPessoa(Pessoa p) throws IllegalArgumentException {
        if (p == null) {
            throw new IllegalArgumentException();
        }
        if(getAluno(p.getCpf()) == null) {
            alunos.add(p);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Pessoa getAluno(int cpf) {
        for (Pessoa p : alunos) {
            if (p.getCpf() == cpf)
                return p;
        }
        return null;
    }
    
    // Get all
    public String toString() {
        String s = "";
        for(Pessoa p : alunos) {
            s += "Nome: " + p.getNome() + "\n";
            s += "CPF: " + p.getCpf() + "\n\n";
        }
        return s;
    }
    
    public boolean updatePessoa(int cpf, String novoNome) {
        for(Pessoa p : alunos) {
            if (p.getCpf() == cpf) {
                p.setNome(novoNome);
                return true;
            }
        } 
        return false;
    }
    
    public boolean removePessoa(int cpf) {
        for(int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getCpf() == cpf) {
                alunos.remove(i);
                return true;
            }
        }
        return false;
    }

}
