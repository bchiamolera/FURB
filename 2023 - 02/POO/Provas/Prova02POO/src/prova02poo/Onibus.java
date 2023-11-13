package prova02poo;

import java.util.ArrayList;

/**
 *
 * @author Bernardo Chiamolera
 */
public abstract class Onibus {
    // Atributos
    private String placa;
    private Motorista motorista;
    protected ArrayList<Passageiro> passageiros;

    // Construtor
    public Onibus(String placa, Motorista motorista) {
        setPlaca(placa);
        setMotorista(motorista);
        passageiros = new ArrayList<>();
    }

    // Getters e Setters
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Motorista getMotorista() {
        return motorista;
    }
    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public ArrayList<Passageiro> getPassageiros() {
        return passageiros;
    }
    public void setPassageiros(ArrayList<Passageiro> passageiros) {
        this.passageiros = passageiros;
    }
    
    // Métodos
    public void adicionarPassageiro(Passageiro p) {
        if (verificarQtdPassageiros()) passageiros.add(p);
    }
    
    public String listarPassageiros() {
        String str = "";
        for (Passageiro p : passageiros) {
            str += p.toString() + "\n\n";
        }
        return str;
    }
    
    public abstract boolean verificarQtdPassageiros();
    
    public abstract double calcularTotalArrecadado();
    
    @Override
    public String toString() {
        return "Placa: " + this.getPlaca()+ "\nMotorista: " + this.getMotorista().toString();
    }
}
