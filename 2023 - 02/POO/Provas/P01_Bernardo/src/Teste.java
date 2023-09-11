// Bernardo Chiamolera; BCC-2SEM MAT. 2023/02 FURB
public class Teste {

    // Métodos
    public static String descobrirMaiorArea(Telhado[] casa) {
        String maiorTelhado = "";
        double areaMaiorTelhado = 0;
        for (int i = 0; i < casa.length; i++) {
            double areaTelhado = casa[i].getComprimento() * casa[i].getLargura();
            if (areaTelhado > areaMaiorTelhado) {
                maiorTelhado = "Maior telhado: \n- telhado na posição [" + i + "]. Área = " + areaTelhado + "m²;";
            }
            if (areaTelhado == areaMaiorTelhado) {
                maiorTelhado += "\n- telhado na posição [" + i + "]. Área = " + areaTelhado + "m²;";
            }
        }
        return maiorTelhado;
    }

    // Main
    public static void main(String[] args) throws Exception {
        try {
            Telhado[] casa = {
                    new Telhado(8, 7.2),
                    new Telhado(8, 4.5)
            };
            int qtdTotalCondutores = 0;
            // Imprimindo qtd de condutores de cada telhado
            for (int i = 0; i < casa.length; i++) {
                System.out.println("Telhado posição " + i + ": ");
                System.out.println(casa[i].imprimir());
                qtdTotalCondutores += casa[i].calcularQtdCondutores();
            }
            // Imprimindo qtd total de condutores
            System.out.println("\nQuantidade total de condutores: " + qtdTotalCondutores);
            // Imprimindo maior área
            System.out.println("\n" + descobrirMaiorArea(casa));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
