public class Q12 {

    public static String menorIdade(Apolice[] apolices) {
        int menorIdade = Integer.MAX_VALUE;
        String retorno = "";
        for (Apolice apolice : apolices) {
            if (apolice.getIdade() < menorIdade) {
                menorIdade = apolice.getIdade();
                retorno = apolice.imprimir();
            } else if (apolice.getIdade() == menorIdade) {
                retorno += "\n\n" + apolice.imprimir();
            }
        }
        return retorno;
    }

    public static void main(String[] args) throws Exception {
        Apolice[] apolices = {
                new Apolice("Joao da Silva", 27, 900.0),
                new Apolice("Maria", 18, 2000.0),
                new Apolice("Martha", 39, 1600.0),
                new Apolice("Jose", 24, 2300.0),
                new Apolice("Tiago", 18, 1700.0)
        };

        try {
            System.out.println(menorIdade(apolices));
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
    }
}