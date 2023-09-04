public class AtvPontos {
    public static void main(String[] args) throws Exception {
        Ponto[] pontos = {
            new Ponto(0, 0),
            new Ponto(-1, 0),
            new Ponto(-1, -1),
            new Ponto(0, -1)
        };

        for (Ponto ponto : pontos) {
            System.out.println(ponto.imprimir());
        }
    }
}