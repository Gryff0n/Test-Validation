package exo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Liste d'entiers offrant des opérations de gestion des occurrences
 * d'une valeur (comptage, suppression, remplacement, etc.).
 * <p>
 * Les éléments sont stockés dans l'attribut {@link #liste}, sur lequel
 * s'appliquent toutes les opérations définies par l'interface
 * {@link Occurrence}.
 * </p>
 *
 * @see Occurrence
 * @see ValueNotFoundException
 */
public class OccurrenceList extends ArrayList<Integer> implements Occurrence {

    /** Liste interne contenant les éléments sur lesquels portent les opérations. */
    private ArrayList<Integer> liste;

    /**
     * Construit une {@code OccurrenceList} à partir d'un tableau d'entiers.
     * Les éléments du tableau sont copiés dans la liste interne.
     *
     * @param t le tableau d'entiers servant à initialiser la liste
     * @throws NullPointerException si {@code t} est {@code null}
     */
    public OccurrenceList(Integer[] t) {
        this.liste = new ArrayList<>(Arrays.asList(t));
    }

    /**
     * Construit une {@code OccurrenceList} vide.
     */
    public OccurrenceList() {
        super();
    }

    /**
     * Calcule le nombre d'occurrences d'une valeur dans la liste.
     *
     * @param i la valeur dont on veut compter les occurrences
     * @return le nombre de fois où {@code i} apparaît dans la liste
     * (0 si la valeur est absente)
     */
    @Override
    public Integer computeOccurrence(int i) {
        int count = 0;
        for(int j=0; j<liste.size(); j++) {
            if(liste.get(j).equals(i)) count++;
        }
        return count;
    }

    /**
     * Indique si une valeur apparaît au moins un certain nombre de fois
     * dans la liste.
     *
     * @param i   la valeur recherchée
     * @param occ le nombre minimal d'occurrences attendu
     * @return {@code true} si {@code i} apparaît au moins {@code occ} fois,
     * {@code false} sinon
     */
    @Override
    public Boolean containsNOccurrences(int i, int occ) {
        return computeOccurrence(i)>=occ;
    }

    /**
     * Supprime toutes les occurrences d'une valeur de la liste.
     *
     * @param i la valeur à supprimer
     * @throws ValueNotFoundException si la valeur {@code i} n'apparaît
     *                                pas dans la liste
     */
    @Override
    public void removeAllOccurrences(int i) throws ValueNotFoundException {
        boolean delete = liste.removeIf(e -> e.equals(i));
        if(!delete) throw new ValueNotFoundException("Aucune Occurrences");
    }

    /**
     * Remplace toutes les occurrences d'une valeur par une nouvelle valeur.
     *
     * @param oldValue la valeur à remplacer
     * @param newValue la valeur de remplacement
     * @throws ValueNotFoundException si {@code oldValue} n'apparaît
     * pas dans la liste
     */
    @Override
    public void replaceAllOccurrences(int oldValue, int newValue) throws ValueNotFoundException {
        boolean found = false;
        for (int j = 0; j < liste.size(); j++) {
            if (liste.get(j).equals(oldValue)) {
                liste.set(j, newValue);
                found = true;
            }
        }
        if (!found) {
            throw new ValueNotFoundException();
        }
    }


    /**
     * Retourne une copie de la liste dans laquelle toutes les occurrences
     * d'une valeur ont été retirées. La liste d'origine n'est pas modifiée.
     *
     * @param i la valeur à exclure de la liste retournée
     * @return une nouvelle liste ne contenant plus aucune occurrence de {@code i}
     * @throws ValueNotFoundException si la valeur {@code i} n'apparaît
     * pas dans la liste
     */
    @Override
    public List<Integer> subListWithoutOccurrences(int i) throws ValueNotFoundException {
        List<Integer> copy = new ArrayList<>(liste);
        OccurrenceList temp = new OccurrenceList(copy.toArray(new Integer[0]));
        temp.removeAllOccurrences(i);
        return temp;
    }
}