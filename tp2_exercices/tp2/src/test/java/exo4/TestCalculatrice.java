package exo4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCalculatrice {

    @Test
    void testConstructeur() {
        // donnée d'entrée
        Calculatrice calc = new Calculatrice(4, 5);
        // résultat attendu
        String resultatAttendu = "x = 4; y = 5";
        // résultat effectif
        String resultatEffectif = calc.toString();
        // vérification
        Assertions.assertEquals(resultatAttendu, resultatEffectif, "constructionsimple");
    }

    @Test
    void testAjouter() {
        Calculatrice calc = new Calculatrice(4, 5);
        System.out.println(calc.toString());
        Calculatrice calcBis = new Calculatrice(calc.ajouter(), calc.getY());
        String resultatAttendu = "x = 9; y = 5";
        String resultatEffectif = calcBis.toString();
        Assertions.assertEquals(resultatAttendu, resultatEffectif, "test ajouter");
    }

}
