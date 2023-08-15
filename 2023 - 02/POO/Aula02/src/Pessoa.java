public class Pessoa {
    private String Nome;
    private int Idade;
    private char Sexo;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int idade) {
        if (idade >= 0) {
            this.Idade = idade;
        } else {
            System.err.println("Idade " + idade + " inválida!");
            this.Idade = 0;
        }
    }

    public char getSexo() {
        return Sexo;
    }

    public void setSexo(char sexo) {
        if (sexo == 'm' || sexo == 'f') {
            this.Sexo = sexo;
        } else {
            this.Sexo = 'n';
        }
    }
}
