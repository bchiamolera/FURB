public class Ponto {
    // Atributos
    private double X;
    private double Y;

    // Construtores
    public Ponto() {
        this.X = 0;
        this.Y = 0;
    }

    public Ponto(double x, double y) {
        setX(x);
        setY(y);
    }

    // Getters e Setters
    public double getX() {
        return this.X;
    }

    public void setX(double x) {
        this.X = x;
    }

    public double getY() {
        return this.Y;
    }

    public void setY(double y) {
        this.Y = y;
    }

    // Métodos
    private int verificarQuadrante() {
        if (getX() >= 0 && getY() >= 0)
            return 1;
        if (getX() < 0 && getY() >= 0)
            return 2;
        if (getX() < 0 && getY() < 0)
            return 3;
        return 4;
    }

    public String imprimir() {
        return "O ponto da coordenada (" + getX() + ", " + getY() + ") está localizado no quadrante "
                + verificarQuadrante();
    }
}
