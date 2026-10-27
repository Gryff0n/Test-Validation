package exo2;

import exo1.CalculImpl2;
import org.junit.jupiter.api.*;

public class TestValidateFibo {

    @Test
    public void testFibo1() {
        int resultat = FiboImpl.Fibonacci(0);
        Assertions.assertEquals(0, resultat);
    }

    @Test
    public void testFibo2() {
        int resultat = FiboImpl.Fibonacci(1);
        Assertions.assertEquals(1, resultat);
    }

    @Test
    public void testFibo3() {
        int resultat = FiboImpl.Fibonacci(2);
        Assertions.assertEquals(1, resultat);
    }

    @Test
    public void testFibo4() {
        int resultat = FiboImpl.Fibonacci(3);
        Assertions.assertEquals(2, resultat);
    }

    @Test
    public void testFibo5() {
        Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> FiboImpl.Fibonacci(-1));
        Assertions.assertEquals("n<0", e.getMessage());
    }

    @Test
    public void testFiboX() {
        int resultat = FiboImpl.Fibonacci(46);
        Assertions.assertEquals(1836311903, resultat);
    }
}
