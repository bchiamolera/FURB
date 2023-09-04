/*
 * Por: Bernardo Chiamolera
 * Data de início:  01/09/2023
 * Data de término: 01/09/2023
 * Trabalho Prático 01 - Classes, Métodos, Atributos
 * Professor: Aurélio Hopper
 * Fundação Universidade Regional de Blumenau - BCC
 */

// -------------------------- Imports -------------------------- //
import java.text.DecimalFormat;

public class TrabPrat01 {

    public static DecimalFormat dfMoney = new DecimalFormat("###,###.00");

    // -------------------------- Métodos -------------------------- //
    public static String carrosMaisCarosAno(Carro[] carros, int ano) {
        String result = "Carro(s) mais caro(s) de " + ano + ": ";
        double maiorPreco = 0;
        
        // Encontrando preço mais caro;
        for (Carro carro : carros) {
            if (carro.getAno() == ano && carro.getPreco() > maiorPreco) {
                maiorPreco = carro.getPreco();
            }
        }
        // Encontrando carros com o preço mais caro
        for (Carro carro : carros) {
            if (carro.getAno() == ano && carro.getPreco() == maiorPreco) {
                result += carro.getInfo() + "\n";
            }
        }
        return result;
    }

    public static String carrosMarcaPorPreco(Carro[] carros, String marca, double precoX, double precoY) {
        String result = "";

        // Se os preços colocados forem iguais
        if (precoX == precoY) {
            result = "Carro(s) da marca " + marca + " de R$" + dfMoney.format(precoX) + ":";
            for (Carro carro : carros) {
                if (carro.getMarca() == marca && carro.getPreco() == precoX) {
                    result += carro.getInfo() + "\n";
                }
            }
            return result;
        }

        //Se os preços colocados forem diferentes
        if (precoX > precoY) {
            double temp = precoX;
            precoX = precoY;
            precoY = temp;
        }
        result = "Carro(s) da marca " + marca + " entre R$" + dfMoney.format(precoX) + " e R$" + dfMoney.format(precoY) + ":";
        for (Carro carro : carros) {
            if (carro.getMarca() == marca && carro.getPreco() >= precoX && carro.getPreco() <= precoY) {
                result += carro.getInfo() + "\n";
            }
        }
        return result;
    }

    public static String carrosMaisCarosEBaratosLocal(Carro[] carros, int localizacao) {
        double maiorPreco = 0;
        double menorPreco = Double.MAX_VALUE;

        // Determinando preço mais caro e mais barato do local
        for (Carro carro : carros) {
            if (carro.getLocalizacao() == localizacao) {
                if (carro.getPreco() > maiorPreco) {
                    maiorPreco = carro.getPreco();
                }
                if (carro.getPreco() < menorPreco) {
                    menorPreco = carro.getPreco();
                }
            }
        }
        
        // Encontrando os carros
        String result = "";
        result += "Carro(s) mais caro(s) do local " + localizacao + ": ";
        for (Carro carro : carros) {
            if (carro.getLocalizacao() == localizacao && carro.getPreco() == maiorPreco) {
                result += carro.getInfo() + "\n";
            }
        }
        result += "\nCarro(s) mais barato(s) do local " + localizacao + ": ";
        for (Carro carro : carros) {
            if (carro.getLocalizacao() == localizacao && carro.getPreco() == menorPreco) {
                result += carro.getInfo() + "\n";
            }
        }
        return result;
    }

    // -------------------------- Main -------------------------- //
    public static void main(String[] args) throws Exception {
        Carro[] carros = {
            new Carro("Gol", "VW", "MMM001", "Preta", 2009, 25000, 1),
            new Carro("Fox", "VW", "LML002", "Vermelha", 2010, 30000, 2),
            new Carro("Uno", "Fiat", "MLM003", "Cinza", 2011, 32000, 3),
            new Carro("Fiesta", "Ford", "LLL004", "Branca", 2009, 29000, 1),
            new Carro("Palio", "Fiat", "KKK345", "Amarelo", 2011, 26000, 1),
        };

        System.out.println(carrosMaisCarosAno(carros, 2011));
        System.out.println(carrosMarcaPorPreco(carros, "VW", 25000, 29999.99));
        System.out.println(carrosMaisCarosEBaratosLocal(carros, 1));
    }
}