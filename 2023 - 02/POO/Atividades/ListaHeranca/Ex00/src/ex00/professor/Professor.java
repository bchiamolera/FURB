/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex00.professor;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Professor {
    private String nome, matricula;
    private int idade;

    public Professor(String nome, String matricula, int idade) {
        setNome(nome);
        setMatricula(matricula);
        setIdade(idade);
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\nMatrícula: " + this.getMatricula() + "\nIdade:" + this.getIdade();
    }
}
