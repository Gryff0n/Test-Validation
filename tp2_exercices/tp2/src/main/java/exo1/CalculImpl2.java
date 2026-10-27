package exo1;



public class CalculImpl2 implements CalculInterface{

    public static double Calculer(double... args) {
        double x = args[0];
        double y = args[1];
        double z = args[2];

        return Math.sqrt((y*(z-1))/(Math.pow(x,2)-1));
    }
}
