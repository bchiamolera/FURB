package prova02poo;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Intermunicipal extends Onibus {
    // Construtor
    public Intermunicipal(String placa, Motorista motorista) {
        super(placa, motorista);
    }

    @Override
    public boolean verificarQtdPassageiros() {
        int qtdPassageiros = 0;
        for (Passageiro p : passageiros) {
            qtdPassageiros++;
        }
        return qtdPassageiros < 45;
    }

    @Override
    public double calcularTotalArrecadado() {
        double totalArrecadado = 0;
        for (Passageiro p : passageiros) {
            if (!(p instanceof Aposentado) && !(p instanceof Estudante)) {
                totalArrecadado += 5.3;
            } else if (p instanceof Estudante) {
                totalArrecadado += (5.3 / 2);
            }
            totalArrecadado += 0.7;
        }
        return totalArrecadado;
    }
}
