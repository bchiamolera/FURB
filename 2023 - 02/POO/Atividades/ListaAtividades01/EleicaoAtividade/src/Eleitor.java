public class Eleitor {
    private String Name;
    private int Age;

    // Get's e Set's
    private String getName() {
        return Name;
    }
    private void setName(String name) {
        Name = name;
    }

    private int getAge() {
        return Age;
    }
    private void setAge(int age) {
        Age = age;
    }

    // Construtor
    public Eleitor(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    // Métodos
    private String verificar() {
        if (getAge() < 16) {
            return "Eleitor não pode votar";
        } else if (getAge() <= 65) {
            return "Eleitor deve votar";
        }
        return "Voto facultativo";
    }

    public String imprimir() {
        return "Nome: " + getName() + "\nIdade: " + getAge() + "\n" + verificar();
    }
}