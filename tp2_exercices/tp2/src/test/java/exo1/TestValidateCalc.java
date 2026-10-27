package exo1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestValidateCalc {

    @Test
    public void testCalcImpl1() {
        double resultat = CalculImpl.Calculer(1);
        Assertions.assertTrue(Double.isInfinite(resultat));
    }

    @Test
    public void testCalcImpl2() {
        double resultat = CalculImpl.Calculer(-1);
        Assertions.assertTrue(Double.isInfinite(resultat));
    }

    @Test
    public void testCalcImpl3() {
        double resultat = CalculImpl.Calculer(2);
        Assertions.assertEquals(0.57735026, resultat, 0.00000001);
    }

    @Test
    public void testCalcImpl4() {
        double resultat = CalculImpl.Calculer(-2);
        Assertions.assertEquals(0.57735026, resultat, 0.00000001);
    }

    @Test
    public void testCalcImpl5() {

    }
}
