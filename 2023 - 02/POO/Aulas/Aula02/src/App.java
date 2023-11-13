public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("----------------------");

        Pessoa pessoa01 = new Pessoa();
        pessoa01.setNome("Joao");
        pessoa01.setIdade(21);
        pessoa01.setSexo('m');

        System.out.println("Nome: " + pessoa01.getNome());
        System.out.println("Idade: " + pessoa01.getIdade());
        System.out.println("Sexo: " + pessoa01.getSexo());

        System.out.println("----------------------");
        
        Pessoa pessoa02 = new Pessoa();
        pessoa02.setNome("Maria");
        pessoa02.setIdade(-56);
        pessoa02.setSexo('f');

        System.out.println("Nome: " + pessoa02.getNome());
        System.out.println("Idade: " + pessoa02.getIdade());
        System.out.println("Sexo: " + pessoa02.getSexo());
        

        System.out.println("----------------------");


        // Pessoa pessoa02 = null;
        // pessoa02 = new Pessoa();
        // pessoa02.setNome("Maria");

        // Pessoa pessoa03 = pessoa01;

        // Pessoa pessoa04 = new Pessoa();
        // Pessoa pessoa05 = pessoa02;
        // pessoa05.setNome("Pedro");
        // pessoa04.setNome("Jose");

        // System.out.println(pessoa01.getNome()); // Joao
        // System.out.println(pessoa02.getNome()); // Pedro
        // System.out.println(pessoa03.getNome()); // Joao
        // System.out.println(pessoa04.getNome()); // Jose
        // System.out.println(pessoa05.getNome()); // Pedro
    }
}