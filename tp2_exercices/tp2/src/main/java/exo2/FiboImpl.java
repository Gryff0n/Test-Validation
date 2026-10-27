package exo2;

public class FiboImpl {

    public static int Fibonacci(int n) {
        if(n<0) throw new IllegalArgumentException("n<0");
        if(n==0 | n==1) return n;
        int n0 = 0;
        int n1 = 1;
        for(int i=2; i<=n; i++) {
            int temp = n1;
            n1 = n0+n1;
            n0 = temp;
        }
        return n1;
    }
}
