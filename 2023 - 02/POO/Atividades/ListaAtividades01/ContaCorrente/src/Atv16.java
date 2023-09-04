public class Atv16 {
    public static void main(String[] args) throws Exception {
        try {

            ContaCorrente cc = new ContaCorrente("Joao", 950);

            cc.fazerDeposito(1000);
            System.out.println(cc.getStatusContaCorrente());

            cc.fazerSaque(50);
            System.out.println(cc.getStatusContaCorrente());

            ContaCorrente cc2 = new ContaCorrente("Maria", 100);

            cc.fazerTransferencia(cc2, 900);
            System.out.println(cc.getStatusContaCorrente());
            System.out.println(cc2.getStatusContaCorrente());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
