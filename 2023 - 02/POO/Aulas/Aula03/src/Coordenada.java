public class Coordenada {
    private double x;
    private double y;

    public double getX() {
        return x;
    }
    private void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }
    private void setY(double y) {
        this.y = y;
    }

    public Coordenada(double x, double y) {
        setX(x);
        setY(y);
    }
}
