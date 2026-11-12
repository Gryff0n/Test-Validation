package exo1;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


class TestOccurrenceList {

    private OccurrenceList list;

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
    void testRemoveAllOccurrences() throws ValueNotFoundException {
        list.removeAllOccurrences(3);
        assertEquals(0, list.computeOccurrence(3));
        assertEquals(1, list.computeOccurrence(1));
        assertEquals(2, list.computeOccurrence(2));
    }

    @Test
    void testRemoveAllOccurrencesNotFound() {
        assertThrows(ValueNotFoundException.class, () -> list.removeAllOccurrences(4));
    }


    @Test
    void testReplaceAllOccurrences() throws ValueNotFoundException {
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

