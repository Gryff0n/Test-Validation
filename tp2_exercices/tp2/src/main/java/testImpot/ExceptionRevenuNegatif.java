package testImpot;

public class ExceptionRevenuNegatif extends Exception { // ou RuntimeException
    // Constructeur par défaut
    public ExceptionRevenuNegatif() {
        super();
    }

    // Constructeur avec un message explicite
    public ExceptionRevenuNegatif(String message) {
        super(message);
    }
}
