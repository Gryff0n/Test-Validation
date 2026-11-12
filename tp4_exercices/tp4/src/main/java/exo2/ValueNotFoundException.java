package exo2;

public class ValueNotFoundException extends Exception {
    public ValueNotFoundException(String aucuneOccurrences) {
        super(aucuneOccurrences);
    }

    public ValueNotFoundException(){super();}
}
