package trabcomplementarp2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class TrabComplementarP2 {

    // Bernardo Chiamolera e Ricardo Sasse
    public static void main(String[] args) throws FileNotFoundException {
        new TrabComplementarP2();
    }

    public TrabComplementarP2() throws FileNotFoundException {
        acharPopulacao();
        acharSuicidio();
    }

    public void acharPopulacao() throws FileNotFoundException {
        try {
            ArrayList<Municipio> municipios = new ArrayList<>();

            // Lê arquivo
            FileInputStream fis = new FileInputStream("municipios2.csv");
            InputStreamReader reader = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(reader);

            String linha = br.readLine();
            while (linha != null) {
                linha = br.readLine();
                if (linha != null) {
                    String[] municipio = linha.split(";");
                    municipios.add(new Municipio(Integer.parseInt(municipio[0]), municipio[1], municipio[2], Integer.parseInt(municipio[3])));
                }
            }
            br.close();

            // Procurar cidades com maior e menor população
            int indexMenor = 0;
            int menorPopulacao = Integer.MAX_VALUE;
            int indexMaior = 0;
            int maiorPopulacao = Integer.MIN_VALUE;
            for (Municipio m : municipios) {
                if (m.getPopulacao() > maiorPopulacao) {
                    maiorPopulacao = m.getPopulacao();
                    indexMaior = municipios.indexOf(m);
                }
                if (m.getPopulacao() < menorPopulacao) {
                    menorPopulacao = m.getPopulacao();
                    indexMenor = municipios.indexOf(m);
                }
            }

            // Escreve resultado
            System.out.println("Maior população: ");
            System.out.println(municipios.get(indexMaior));

            System.out.println("\nMenor população: ");
            System.out.println(municipios.get(indexMenor));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void acharSuicidio() throws FileNotFoundException {
        try {
            HashMap<Integer, Suicidio> municipios = new HashMap<>();

            // Lendo arquivo
            FileInputStream fis = new FileInputStream("suicidio.csv");
            InputStreamReader reader = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(reader);

            String linha = br.readLine();
            while (linha != null) {
                linha = br.readLine();
                if (linha != null) {
                    String[] ocorrencia = linha.split(";");
                    if (!ocorrencia[7].equals("") && !ocorrencia[9].equals("")) {
                        if (!municipios.containsKey(Integer.valueOf(ocorrencia[12]))) {
                            municipios.put(Integer.valueOf(ocorrencia[12]), new Suicidio(Integer.parseInt(ocorrencia[12])));
                        }
                        municipios.get(Integer.valueOf(ocorrencia[12])).addOcorrencia(new Ocorrencia(Integer.parseInt(ocorrencia[7]), Integer.parseInt(ocorrencia[9])));
                    }
                }
            }
            br.close();

            // Achar o município com maior quantidade de ocorrencias
            int codMunicipioMaisOcorrencias = 0;
            int qtdOcorrencias = Integer.MIN_VALUE;

            for (int codMunicipio : municipios.keySet()) {
                if (municipios.get(codMunicipio).getOcorrencias().size() > qtdOcorrencias) {
                    qtdOcorrencias = municipios.get(codMunicipio).getOcorrencias().size();
                    codMunicipioMaisOcorrencias = codMunicipio;
                }
            }

            // Guardando dados no arquivo
            File arqEscrita = new File("suicidio.txt");
            FileOutputStream fos = new FileOutputStream(arqEscrita, false);
            PrintWriter out = new PrintWriter(fos);

            out.println("Município com mais casos: " + codMunicipioMaisOcorrencias);
            int qtdOcorrenciasHomem = 0;
            int qtdOcorrenciasMulher = 0;
            for (Ocorrencia o : municipios.get(codMunicipioMaisOcorrencias).getOcorrencias()) {
                if (o.getSexo() == 1) {
                    qtdOcorrenciasHomem++;
                } else {
                    qtdOcorrenciasMulher++;
                }
            }
            out.println("Qtd. Masculino: " + qtdOcorrenciasHomem);
            out.println("Qtd. Feminino: " + qtdOcorrenciasMulher);

            int qtdSolteiro = 0;
            int qtdCasado = 0;
            int qtdViuvo = 0;
            int qtdSeparado = 0;
            int qtdUniao = 0;
            int qtdIgnorado = 0;
            for (Ocorrencia o : municipios.get(codMunicipioMaisOcorrencias).getOcorrencias()) {
                switch (o.getEstadoCivil()) {
                    case 1:
                        qtdSolteiro++;
                        break;
                    case 2:
                        qtdCasado++;
                        break;
                    case 3:
                        qtdViuvo++;
                        break;
                    case 4:
                        qtdSeparado++;
                        break;
                    case 5:
                        qtdUniao++;
                        break;
                    case 9:
                        qtdIgnorado++;
                        break;
                    default:
                }
            }
            if (qtdSolteiro > qtdCasado && qtdSolteiro > qtdViuvo && qtdSolteiro > qtdSeparado && qtdSolteiro > qtdUniao && qtdSolteiro > qtdIgnorado) {
                out.println("Maior qtd Estado Civil: Solteiro");
            } else if (qtdCasado > qtdViuvo && qtdCasado > qtdSeparado && qtdCasado > qtdUniao && qtdCasado > qtdIgnorado) {
                out.println("Maior qtd Estado Civil: Casado");
            } else if (qtdViuvo > qtdSeparado && qtdViuvo > qtdUniao && qtdViuvo > qtdIgnorado) {
                out.println("Maior qtd Estado Civil: Viúvo");
            } else if (qtdSeparado > qtdUniao && qtdSeparado > qtdIgnorado) {
                out.println("Maior qtd Estado Civil: Separado Judicialmente");
            } else if (qtdUniao > qtdIgnorado) {
                out.println("Maior qtd Estado Civil: União Consensual");
            } else {
                out.println("Maior qtd Estado Civil: Ignorado");
            }
            
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
