package exo1;



public class CalculImpl implements CalculInterface{

    public static double Calculer(double... x) {
        return Math.sqrt(1/(Math.pow(x[0],2)-1));
    }
}
