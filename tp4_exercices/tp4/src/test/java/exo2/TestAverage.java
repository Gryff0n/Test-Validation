package exo2;

import exo2.OccurrenceList;
import exo2.ValueNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class TestOccurrenceList {

    private exo2.OccurrenceList list;

    @BeforeEach
    void setUp() {
        list = new OccurrenceList(new Integer[]{1, 2, 3, 2, 3, 3});
    }

    @RepeatedTest(3)
    void testContainsNOccurrences(RepetitionInfo info) {
        int value = info.getCurrentRepetition();
        assertTrue(list.containsNOccurrences(value, value));
        assertTrue(list.containsNOccurrences(value, 1));
        assertFalse(list.containsNOccurrences(value, value + 1));
    }

    @Test
    void testContainsNOccurrencesAbsentValue() {
        assertFalse(list.containsNOccurrences(4, 1));
        assertTrue(list.containsNOccurrences(4, 0));
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testComputeOccurrence(int value) {
        assertEquals(value, list.computeOccurrence(value));
    }

    @Test
    void testComputeOccurrenceAbsentValue() {
        assertEquals(0, list.computeOccurrence(42));
    }

    @Test
    void testRemoveAllOccurrences() throws exo1.ValueNotFoundException {
        list.removeAllOccurrences(3);
        assertEquals(0, list.computeOccurrence(3));
        assertEquals(1, list.computeOccurrence(1));
        assertEquals(2, list.computeOccurrence(2));
    }

    @Test
    void testRemoveAllOccurrencesNotFound() {
        assertThrows(exo1.ValueNotFoundException.class, () -> list.removeAllOccurrences(4));
    }


    @Test
    void testReplaceAllOccurrences() throws exo1.ValueNotFoundException {
        list.replaceAllOccurrences(2, 5);
        assertEquals(0, list.computeOccurrence(2));
        assertEquals(2, list.computeOccurrence(5));
        assertEquals(3, list.computeOccurrence(3));
    }

    @Test
    void testReplaceAllOccurrencesNotFound() {
        assertThrows(ValueNotFoundException.class, () -> list.replaceAllOccurrences(9, 1));
    }

    void testAvgWithoutOccurrences() {

    }
}

public class TestAverage {
    public static void main(String[] args) {

        // Classe anonyme implémentant Average
        Average avg = new Average() {
            @Override
            public float compute(List<Integer> l) {
                if (l.isEmpty()) return 0f;
                float sum = 0;
                for (int x : l) sum += x;
                return sum / l.size();
            }
        };

        OccurrenceList ol = new OccurrenceList(avg, new Integer[]{1, 2, 3, 2, 4});

        // Cas normal : (1 + 3 + 4) / 3 = 2.6666667
        try {
            System.out.println(ol.avgWithoutOccurrence(2));
        } catch (exo1.ValueNotFoundException e) {
            System.out.println("Erreur inattendue : " + e.getMessage());
        }

        // Valeur absente : doit lever ValueNotFoundException
        try {
            System.out.println(ol.avgWithoutOccurrence(99));
        } catch (exo1.ValueNotFoundException e) {
            System.out.println("OK, exception levée : " + e.getMessage());
        }

        // Toutes les valeurs retirées : sous-liste vide, compute renvoie 0
        try {
            OccurrenceList same = new OccurrenceList(avg, new Integer[]{5, 5, 5});
            System.out.println(same.avgWithoutOccurrence(5)); // 0.0
        } catch (exo1.ValueNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

