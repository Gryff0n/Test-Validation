package Horloge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HorlogeTest {

    private void assertHeure(Horloge h, int heures, int minutes, int secondes) {
        assertEquals(heures, h.getHeures(), "heures");
        assertEquals(minutes, h.getMinutes(), "minutes");
        assertEquals(secondes, h.getSecondes(), "secondes");
    }

    @Test
    void testConstructeurEtGetters() {
        Horloge h = new Horloge(10, 20, 30);
        assertHeure(h, 10, 20, 30);
    }

    @Test
    void testAjoutZeroSeconde() {
        Horloge h = new Horloge(10, 20, 30);
        h.addSecondes(0);
        assertHeure(h, 10, 20, 30);
    }

    @Test
    void testAjoutSansRetenue() {
        Horloge h = new Horloge(10, 20, 30);
        h.addSecondes(15);
        assertHeure(h, 10, 20, 45);
    }

    @Test
    void testRetenueSecondesVersMinutes() {
        Horloge h = new Horloge(10, 20, 30);
        h.addSecondes(30);
        assertHeure(h, 10, 21, 0);
    }

    @Test
    void testRetenueMinutesVersHeures() {
        Horloge h = new Horloge(10, 59, 59);
        h.addSecondes(1);
        assertHeure(h, 11, 0, 0);
    }

    @Test
    void testAjoutUneHeure() {
        Horloge h = new Horloge(10, 20, 30);
        h.addSecondes(3600);
        assertHeure(h, 11, 20, 30);
    }

    @Test
    void testAjoutPlusieursHeuresMinutesSecondes() {
        Horloge h = new Horloge(1, 2, 3);
        h.addSecondes(3600 + 120 + 5); // 1h 2min 5s
        assertHeure(h, 2, 4, 8);
    }

    @Test
    void testPassageMinuit() {
        Horloge h = new Horloge(23, 59, 59);
        h.addSecondes(1);
        assertHeure(h, 0, 0, 0);
    }

    @Test
    void testAjoutUneJourneeComplete() {
        Horloge h = new Horloge(10, 20, 30);
        h.addSecondes(24 * 3600);
        assertHeure(h, 10, 20, 30);
    }

    @Test
    void testAjoutPlusieursJournees() {
        Horloge h = new Horloge(10, 20, 30);
        h.addSecondes(2 * 24 * 3600 + 10);
        assertHeure(h, 10, 20, 40);
    }

    @Test
    void testAjoutsSuccessifs() {
        Horloge h = new Horloge(0, 0, 0);
        h.addSecondes(59);
        h.addSecondes(1);
        assertHeure(h, 0, 1, 0);
    }

    // Pour aller plus loin : arguments négatifs

    @Test
    void testAjoutNegatifUneHeure() {
        Horloge h = new Horloge(10, 0, 0);
        h.addSecondes(-3600);
        assertHeure(h, 9, 0, 0);
    }

    @Test
    void testAjoutNegatifAvecEmprunt() {
        Horloge h = new Horloge(10, 0, 0);
        h.addSecondes(-1);
        assertHeure(h, 9, 59, 59);
    }

    @Test
    void testAjoutNegatifPassageMinuitEnArriere() {
        Horloge h = new Horloge(0, 0, 0);
        h.addSecondes(-1);
        assertHeure(h, 23, 59, 59);
    }

    @Test
    void testAjoutNegatifPlusieursJournees() {
        Horloge h = new Horloge(10, 20, 30);
        h.addSecondes(-2 * 24 * 3600 - 30);
        assertHeure(h, 10, 20, 0);
    }
}