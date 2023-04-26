public class teste {
    public static void main(String[] args) {
        int contador, num2;
        num2 = 2;
        int somaPar = 4;
        for (contador = 1; contador <= 20; contador++) {
            System.out.println(contador + "º " + num2);
            num2 = num2 + somaPar;
            somaPar += 2;
        }
    }
}
