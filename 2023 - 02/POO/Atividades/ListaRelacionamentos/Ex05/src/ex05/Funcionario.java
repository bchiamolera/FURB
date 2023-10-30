/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex05;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Funcionario {
    private int matricaula;
    private String nome;
    private int departamento;
    private double salario;
    private String funcao;

    public Funcionario(int matricula, String nome, int departamento, double salario, String funcao) {
        setMatricula(matricula);
        setNome(nome);
        setDepartamento(departamento);
        setSalario(salario);
        setFuncao(funcao);
    }

    public int getMatricula() {
        return matricaula;
    }

    public void setMatricula(int matricaula) {
        this.matricaula = matricaula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }      
}
