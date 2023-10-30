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
public class ProfessorHorista extends Professor {
    private int totalHoras;
    private double salarioHora;
    
    public ProfessorHorista(String nome, String matricula, int idade, int totalHoras, double salarioHora) {
        super(nome, matricula, idade);
        setTotalHoras(totalHoras);
        setSalarioHora(salarioHora);
    }

    public int getTotalHoras() {
        return totalHoras;
    }
    public void setTotalHoras(int totalHoras) {
        this.totalHoras = totalHoras;
    }

    public double getSalarioHora() {
        return salarioHora;
    }
    public void setSalarioHora(double salarioHora) {
        this.salarioHora = salarioHora;
    }
    
    public double calcularSalario() {
        return this.getSalarioHora() * this.getTotalHoras();
    }
    
    @Override
    public String toString() {
        DecimalFormat dfMoney = new DecimalFormat("#,###.00");
        return super.toString() + "\nTipo: Horista" + 
                "\nSalário/hora: R$" + dfMoney.format(this.getSalarioHora()) +
                "\nTotal de horas: " + this.getTotalHoras() + "h" +
                "\nSalário total: R$" + dfMoney.format(this.calcularSalario());
    }
}
