package testImpot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestCalculImpot {

    @Test
    public void testImpot1() throws ExceptionRevenuNegatif {
        double resultat = CalculImpot.calculerImpot(1.0);
        Assertions.assertEquals(0.1, resultat);
    }

    @Test
    public void testImpot2() throws ExceptionRevenuNegatif {
        double resultat = CalculImpot.calculerImpot(19999.0);
        Assertions.assertEquals(1999.9, resultat);
    }

    @Test
    public void testImpot3() throws ExceptionRevenuNegatif {
        double resultat = CalculImpot.calculerImpot(20000.0);
        Assertions.assertEquals(2000.0, resultat);
    }

    @Test
    public void testImpot4() throws ExceptionRevenuNegatif {
        double resultat = CalculImpot.calculerImpot(20001.0);
        Assertions.assertEquals(2000.3, resultat, 0.01);
    }

    @Test
    public void testImpot5() throws ExceptionRevenuNegatif {
        double resultat = CalculImpot.calculerImpot(99999.0);
        Assertions.assertEquals(25999.7, resultat, 0.01);
    }

    @Test
    public void testImpot6() throws ExceptionRevenuNegatif {
        double resultat = CalculImpot.calculerImpot(100000.0);
        Assertions.assertEquals(26000.0, resultat, 0.01);
    }

    @Test
    public void testImpot7() throws ExceptionRevenuNegatif {
        double resultat = CalculImpot.calculerImpot(150000.0);
        Assertions.assertEquals(56000.0, resultat, 0.01);
    }

    @Test
    public void testImpot8() {
        Exception e = Assertions.assertThrows(ExceptionRevenuNegatif.class, () -> CalculImpot.calculerImpot(-100000.0));
        Assertions.assertEquals("negative money", e.getMessage());
    }


}
