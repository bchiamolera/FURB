package prova03_bernardochiamolera;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Prova03_BernardoChiamolera {

    public static void main(String[] args) throws EArquivoOrigemIncorreto, IOException {
        serializar("atletas.csv", "serializado.bin");
        buscarAcidentes("acidentes_transito.csv");
    }

    public static void serializar(String arqOrigem, String arqDestino) throws IOException {
        try {
            if (!arqOrigem.contains(".csv")) {
                throw new EArquivoOrigemIncorreto("Formato incorreto");
            }

            // Leitura
            FileInputStream fis = new FileInputStream(arqOrigem);
            InputStreamReader reader = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(reader);

            ArrayList<Atleta> atletas = new ArrayList<>(); // Lista de atletas
            String linha = br.readLine();
            if (linha.isEmpty()) {
                throw new EArquivoOrigemIncorreto("Arquivo vazio");
            }
            while (linha != null) {
                String[] atletaArray = linha.split(","); // Array da linha
                Atleta atleta = new Atleta(atletaArray[0], atletaArray[1], Double.parseDouble(atletaArray[2]), Double.parseDouble(atletaArray[3])); // Criação atleta
                Endereco endereco = new Endereco(atletaArray[4], atletaArray[5], atletaArray[6], atletaArray[7], atletaArray[8], atletaArray[9]); // Criação endereço
                atleta.setEndereco(endereco); // Setando endereço no atleta
                atleta.toString();
                atletas.add(atleta); // Adicionando atleta na lista
                linha = br.readLine();
            }
            br.close();

            // Escrita
            FileOutputStream fos = new FileOutputStream(new File(arqDestino));
            Writer wr = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(wr);

            for (Atleta atleta : atletas) {
                bw.write(atleta.toString());
                bw.write("\n\n");
            }
            bw.close();

        } catch (EArquivoOrigemIncorreto e) {
            System.out.println(e.getMessage());
        }
    }

    public static void buscarAcidentes(String arqOrigem) throws IOException {
        try {
            if (!arqOrigem.contains(".csv")) {
                throw new EArquivoOrigemIncorreto("Formato incorreto");
            }
            // Leitura
            FileInputStream fis = new FileInputStream(arqOrigem);
            InputStreamReader reader = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(reader);

            ArrayList<Cidade> cidades = new ArrayList();
            String linha = br.readLine();
            linha = br.readLine(); // Pula primeira linha
            if (linha.isEmpty()) {
                throw new EArquivoOrigemIncorreto("Arquivo vazio");
            }
            while (linha != null) {
                String[] acidenteArray = linha.split(";");
                boolean cidadeExiste = false;
                for (Cidade c : cidades) {
                    if (c.getNome().equals(acidenteArray[0])) {
                        cidadeExiste = true;
                    }
                }
                if (!cidadeExiste) {
                    cidades.add(new Cidade(acidenteArray[0]));
                }
                Acidente acidente = new Acidente(acidenteArray[1], Integer.parseInt(acidenteArray[2]), acidenteArray[3]);
                for (Cidade c : cidades) {
                    if (c.getNome().equals(acidenteArray[0])) {
                        c.addAcidente(acidente);
                        break;
                    }
                }

                linha = br.readLine();
            }
            br.close();

            // Escrita
            FileOutputStream fos = new FileOutputStream(new File("resultados_acidentes.txt"));
            Writer wr = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(wr);

            Cidade cidadeMaisAcidentes = null;
            double numMaiorAcidentes = Double.MIN_VALUE;
            int totalAcidentes;
            for (Cidade c : cidades) {
                totalAcidentes = 0;
                for (Acidente a : c.getAcidentes()) {
                    totalAcidentes += a.getNumAcidentes();
                }
                if (totalAcidentes > numMaiorAcidentes) {
                    numMaiorAcidentes = totalAcidentes;
                    cidadeMaisAcidentes = c;
                }
            }
            bw.write("Cidade com mais acidentes:\n" + cidadeMaisAcidentes.toString() + "\n\n");

            double totalSolteiro = 0;
            double totalCasado = 0;
            double totalDivorciado = 0;
            for (Acidente a : cidadeMaisAcidentes.getAcidentes()) {
                switch (a.getEstadoCivil()) {
                    case "solteiro":
                        totalSolteiro += a.getNumAcidentes();
                        break;
                    case "casado":
                        totalCasado += a.getNumAcidentes();
                        break;
                    case "divorciado":
                        totalDivorciado += a.getNumAcidentes();
                        break;
                    default:
                        break;
                }
            }
            if (totalSolteiro > totalCasado && totalSolteiro > totalDivorciado) {
                bw.write("Estado Civil com mais incidência: Solteiro\n");
                Double incidencia = (totalSolteiro / numMaiorAcidentes) * 100;
                bw.write("Incidência: " + incidencia + "%");
            } else if (totalCasado > totalDivorciado) {
                bw.write("Estado Civil com mais incidência: Casado\n");
                Double incidencia = (totalCasado / numMaiorAcidentes) * 100;
                bw.write("Incidência: " + incidencia + "%");
            } else {
                bw.write("Estado Civil com mais incidência: Divorciado\n");
                Double incidencia = (totalDivorciado / numMaiorAcidentes) * 100;
                bw.write("Incidência: " + incidencia + "%");
            }
            bw.close();
            
        } catch (EArquivoOrigemIncorreto e) {
            System.out.println(e.getMessage());
        }
    }
}
