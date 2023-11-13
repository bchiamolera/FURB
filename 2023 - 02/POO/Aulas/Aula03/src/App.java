/*
Crie uma classe lutador que contenha os seguintes atributos: Nome e Peso. A classe deve
possuir métodos para modificar e acessar cada um dos atributos, construtores, um método
para definir a categoria do lutador e um método imprimir() que fornece o nome do lutador
e a descrição de sua categoria, conforme a tabela abaixo:
---------------------------------------
                Lutador
---------------------------------------
Faixa de Peso       |   Categoria
---------------------------------------
até 54kg            |   Pluma
acima de 54, até 60 |   Leve
acima de 60, até 75 |   Meio-leve
acima de 75         |   Pesado
---------------------------------------
*/

public class App {
    public static double calcularDistancia(Coordenada p1, Coordenada p2) {
        return Math.sqrt(
            Math.pow(p1.getX() - p2.getX(), 2)
            +
            Math.pow(p1.getY() - p2.getY(), 2)
        );
    }
    public static void main(String[] args) throws Exception {
        Lutador umLutador = new Lutador("Jorge", 65);
        umLutador.imprimir();
        Lutador outroLutador = new Lutador("Ricardo", 85);
        outroLutador.imprimir();

        System.out.println();

        // ----------------------------------------------------------- //

        // Criando vetor para armazenar várias Coordenadas
        Coordenada[] vetCoordenadas = new Coordenada[8];
        //Criando vários objetos do tipo Coordenada e armazenando dentro do vetor
        vetCoordenadas[0] = new Coordenada(1, 1);
        vetCoordenadas[1] = new Coordenada(3, 1);
        vetCoordenadas[2] = new Coordenada(2, 4);
        vetCoordenadas[3] = new Coordenada(4, 5);
        vetCoordenadas[4] = new Coordenada(-1, 3);
        vetCoordenadas[5] = new Coordenada(1, 4);
        vetCoordenadas[6] = new Coordenada(-1, -3);
        vetCoordenadas[7] = new Coordenada(3, 4);
        //
        double menorDistancia = 999999999;
        String coordenadas = "";
        for (int i = 0; i < vetCoordenadas.length; i++) {
            for (int j = i + 1; j < vetCoordenadas.length; j++) {
                double distanciaPontos = calcularDistancia(vetCoordenadas[i], vetCoordenadas[j]);
                String linha = "P" + i + "(" + vetCoordenadas[i].getX() + ", " + vetCoordenadas[i].getY() + ") e P" + j +  "(" + vetCoordenadas[j].getX() + ", " + vetCoordenadas[j].getY() + ")";

                if (distanciaPontos < menorDistancia) {
                    menorDistancia = distanciaPontos;
                    coordenadas = linha;
                } else if (distanciaPontos == menorDistancia) {
                    coordenadas += "\n" + linha;
                }
            }
        }
        System.out.println("Menor distancia = " + menorDistancia);
        System.out.println(coordenadas);
    }
}
