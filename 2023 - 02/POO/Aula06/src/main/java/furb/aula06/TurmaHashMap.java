/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.aula06;

/**
 *
 * @author Bernardo Chiamolera
 */
import java.util.HashMap;

public class TurmaHashMap {
    private HashMap<Integer, Pessoa> alunos;
    
    public TurmaHashMap() {
        this.alunos = new HashMap<Integer, Pessoa>();
    }

    // public void addPessoa(String nome)
    public void addPessoa(Pessoa p) throws IllegalArgumentException {
        if (p == null) {
            throw new IllegalArgumentException();
        }
        if(getAluno(p.getCpf()) == null) {
            alunos.put(p.getCpf(), p);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Pessoa getAluno(int cpf) {
        return alunos.get(cpf);
    }
    
    // Get all
    public String toString() {
        String s = "";
        for(Pessoa p : alunos.values()) {
            s += "Nome: " + p.getNome() + "\n";
            s += "CPF: " + p.getCpf() + "\n\n";
        }
        return s;
    }
    
    public boolean updatePessoa(int cpf, String novoNome) {
        if (alunos.containsKey(cpf)) {
            alunos.get(cpf).setNome(novoNome);
            return true;
        }
        return false;
    }
    
    public boolean removePessoa(int cpf) {
        if (alunos.get(cpf) != null){
            alunos.remove(cpf);
            return true;
        }
        return false;
    }

}
