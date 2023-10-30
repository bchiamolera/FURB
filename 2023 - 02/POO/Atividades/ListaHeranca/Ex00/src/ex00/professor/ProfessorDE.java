/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex00.professor;

/**
 *
 * @author Bernardo Chiamolera
 */
import java.text.DecimalFormat;
public class ProfessorDE extends Professor {
    private double salario;

    public ProfessorDE(String nome, String matricula, int idade, double salario) {
        super(nome, matricula, idade);
        setSalario(salario);
    }
    
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    @Override
    public String toString() {
        DecimalFormat dfMoney = new DecimalFormat("#,###.00");
        return super.toString() + "\nTipo: D.E." + this.getIdade() + "Salário: R$" + dfMoney.format(this.getSalario());
    }
}
