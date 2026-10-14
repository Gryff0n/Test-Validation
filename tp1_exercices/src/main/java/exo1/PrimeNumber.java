package exo1;

public class PrimeNumber {
    public static Boolean validateNumber(final Integer primeNumber) throws IllegalArgumentException{
        if(primeNumber<0) throw new IllegalArgumentException("negative numbers");
        if(primeNumber==0) throw new IllegalArgumentException("zero");
        for (int i = 2; i <= (primeNumber / 2); i++) {
            if (primeNumber % i == 0) return false;
        }

        return true;
    }

}
