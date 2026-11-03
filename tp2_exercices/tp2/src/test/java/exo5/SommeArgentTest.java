package exo5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testImpot.CalculImpot;
import testImpot.ExceptionRevenuNegatif;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SommeArgentTest {

    // Compteurs statiques pour numéroter les passages (questions 3 et 4)
    private static int passageAvant = 0;
    private static int passageApres = 0;

    // Initialisations communes (question 3)
    private SommeArgent f12CHF;
    private SommeArgent f14CHF;
    private SommeArgent f12EUR;

    @BeforeEach
    public void setUp() {
        passageAvant++;
        System.out.println(passageAvant + "ème passage avant exécution d'une méthode de test");
        f12CHF = new SommeArgent(12, "CHF");
        f14CHF = new SommeArgent(14, "CHF");
        f12EUR = new SommeArgent(12, "EUR");
    }

    // Code exécuté après chaque test (question 4)
    @AfterEach
    public void tearDown() {
        passageApres++;
        System.out.println(passageApres + "ème passage APRES exécution d'une méthode de test");
        f12CHF = null;
        f14CHF = null;
        f12EUR = null;
    }

    @Test
    public void testAdd() throws UniteDistincteException {
        SommeArgent attendu = new SommeArgent(26, "CHF");
        SommeArgent resultat = f12CHF.add(f14CHF);
        assertTrue(attendu.equals(resultat));
    }

    @Test
    public void testEqualsNonNull() {
        assertFalse(f12CHF.equals(null));
    }

    @Test
    public void testEqualsUnitesDifferentes() {
        assertFalse(f12CHF.equals(f12EUR));
    }

    @Test
    public void testEqualsQuantitesDifferentes() {
        assertFalse(f12CHF.equals(f14CHF));
    }

    @Test
    public void testEqualsReflexive() {
        assertTrue(f12CHF.equals(f12CHF));
    }


    @Test
    public void testAddUnitesDistinctes() throws UniteDistincteException {
        Exception e = Assertions.assertThrows(UniteDistincteException.class, () -> f12CHF.add(f12EUR));
        Assertions.assertEquals("Unités distinctes", e.getMessage());
    }
}
