package aula;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 *
 * @author Bernardo Chiamolera
 */
public class Aula {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        /*
        // Criando e manipulando um arquivo
        File arquivo = new File("D://Arquivos/exemplo.dat");
        FileOutputStream fos = new FileOutputStream(arquivo);
        // Gravando dados no arquivo
        fos.write(90);
        fos.write(100);
        fos.write(200);
        fos.write(232);
        // Fechando o arquivo
        fos.close();

        // Lendo o arquivo
        FileInputStream fis = new FileInputStream(arquivo);
        int dado;
        while ((dado = fis.read()) != -1) {
            System.out.println(dado);
        }
        // Fechando o arquivo
        fis.close();
        */
        
        /*
        // Gravando um arquivo
        OutputStream os = new FileOutputStream("D://Arquivos/file.dat"); // Arquivo
        Writer wr = new OutputStreamWriter(os); // Escritor
        BufferedWriter bw = new BufferedWriter(wr); // Adiciono um escritor de buffer

        String m[][] = {{"Joao", "Ilhota", "20"},
                        {"Maria", "Gaspar", "23"}};
        
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                bw.write(m[i][j] + ";");
            }
            bw.newLine();
        }
        bw.close();
        
        FileInputStream stream = new FileInputStream("D://Arquivos/file.dat");
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(reader);
        
        String linha = br.readLine();
        while ( linha != null ) {
            String[] textoSeparado = linha.split(";");
            System.out.print(textoSeparado[0] + " ");
            System.out.print(textoSeparado[1] + " ");
            System.out.println(textoSeparado[2]);
            
            System.out.println();
            
            linha = br.readLine();
        }
        br.close();
        */
        
        /*
        // Definindo diretório
        File dir = new File("D://Arquivos");
        // Pegando lista de arquivos e diretórios
        File conteudo[] = dir.listFiles();
        
        // Varrendo o vetor
        long total = 0;
        for (File f : conteudo) {
            if (f.isDirectory()) {
                System.out.println("<DIR> " + f.getName());
            } else {
                total += f.length();
                System.out.println(f.getName() + "\t\tSize: " + f.length() + " b");
            }
            
        }
        
        System.out.println("\nTotal: " + conteudo.length);
        System.out.println("Tamanho total: " + total + " b");
         */
    }
}
