package exo4;

public class Calculatrice {
    private int x;
    private int y;

    public Calculatrice(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /*
    public int ajouter() {
        x -= y;
        return x;
    }
     */

    public int ajouter() {
        x += y;
        return x;
    }

    @Override
    public String toString() {
        return "x = " + x + "; y = " + y;
    }

    public int getY() {
        return y;
    }
}
