package exo2;

import java.util.List;

public interface Occurrence {
    Integer computeOccurrence(int i);
    Boolean containsNOccurrences(int i, int occ);
    void removeAllOccurrences(int i) throws ValueNotFoundException;
    void replaceAllOccurrences(int oldValue, int newValue) throws ValueNotFoundException;
    List<Integer> subListWithoutOccurrences(int i) throws ValueNotFoundException;
}

