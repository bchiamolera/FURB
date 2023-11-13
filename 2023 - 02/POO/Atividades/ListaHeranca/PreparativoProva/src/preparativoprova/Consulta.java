package preparativoprova;

import java.text.DecimalFormat;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Consulta {
    // Atributos
    private String codigo;
    private Paciente paciente;
    private Medico medico;
    private String dia;
    private double valor;

    // Construtor
    public Consulta(String codigo, Paciente paciente, Medico medico, String dia) {
        setCodigo(codigo);
        setPaciente(paciente);
        setMedico(medico);
        setDia(dia);
        setValor(250.0 * paciente.getPlano().aplicarDesconto());
    }

    // Getters e Setters
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getDia() {
        return dia;
    }
    public void setDia(String dia) {
        this.dia = dia;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    // Métodos
    DecimalFormat dfMoney = new DecimalFormat("#,###.00");
    @Override
    public String toString() {
        return "Cód. Consulta: " + this.getCodigo() + "\nPaciente: " + this.getPaciente().getNome() +
                "\nMédico: " + this.getMedico().getNome() + "\nData: " + this.getDia() +
                "\nValor: R$" + dfMoney.format(this.getValor());
    }
}
