/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex00.funcionario;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Gerente extends Funcionario {
    private String senha;

    public Gerente(String nome, String cpf, String senha) {
        super(nome, cpf);
        setSenha(senha);
    }

    protected String getSenha() {
        return senha;
    }
    protected void setSenha(String senha) {
        this.senha = senha;
    }
    
    public boolean autenticar(String senha) {
        if(senha == this.getSenha()) return true;
        else return false;
    }
}
