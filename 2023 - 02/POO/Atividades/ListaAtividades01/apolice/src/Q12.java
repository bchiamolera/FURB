public class Q12 {
    public static void main(String[] args) throws Exception {
        try {
            Apolice umaApolice = new Apolice("Joao da Silva", 27, 900);
            System.out.println(umaApolice.imprimir());
            
            umaApolice.calcularPremio();
            System.out.println(umaApolice.imprimir());
    
            umaApolice.oferecerDesconto("blumenau");
            System.out.println(umaApolice.imprimir());
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
        
    }
}