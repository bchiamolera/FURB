public class App {
    public static void main(String[] args) throws Exception {
        Pessoa pessoa1 = new Pessoa();

        pessoa1.Nome = "Joao";
        pessoa1.Idade = 14;
        pessoa1.Sexo = 'm';

        System.out.println("Nome: " + pessoa1.Nome);
        System.out.println("Idade: " + pessoa1.Idade);
        System.out.println("Sexo: " + pessoa1.Sexo);
    }
}
