package exo2;

import exo1.Occurrence;
import exo1.ValueNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Liste d'entiers offrant des opérations de gestion des occurrences
 * d'une valeur (comptage, suppression, remplacement, etc.).
 * <p>
 * Les éléments sont stockés dans l'attribut {@link #liste}, sur lequel
 * s'appliquent toutes les opérations définies par l'interface
 * {@link exo1.Occurrence}.
 * </p>
 *
 * @see exo1.Occurrence
 * @see exo1.ValueNotFoundException
 */
public class OccurrenceList extends ArrayList<Integer> implements Occurrence {
    private Average average;

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
     * Construit une {@code OccurrenceList} à partir d'un tableau d'entiers.
     * Les éléments du tableau sont copiés dans la liste interne.
     *
     * @param t le tableau d'entiers servant à initialiser la liste
     * @throws NullPointerException si {@code t} est {@code null}
     */
    public OccurrenceList(Average avg, Integer[] t) {
        this.average = avg;
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
     * @throws exo1.ValueNotFoundException si la valeur {@code i} n'apparaît
     *                                pas dans la liste
     */
    @Override
    public void removeAllOccurrences(int i) throws exo1.ValueNotFoundException {
        boolean delete = liste.removeIf(e -> e.equals(i));
        if(!delete) throw new exo1.ValueNotFoundException("Aucune Occurrences");
    }

    /**
     * Calcule la moyenne de la sous-liste ne contenant aucune occurrence de {@code i},
     * en utilisant la méthode {@link Average#compute(List)}.
     *
     * @param i la valeur à exclure avant le calcul de la moyenne
     * @return la moyenne de la sous-liste sans aucune occurrence de {@code i}
     * @throws ValueNotFoundException si {@code i} n'apparaît pas dans la liste
     * @throws IllegalStateException  si aucun objet {@link Average} n'a été fourni
     */
    public float avgWithoutOccurrence(int i) throws ValueNotFoundException {
        if (average == null) {
            throw new IllegalStateException("Aucun calculateur de moyenne n'a été fourni");
        }
        List<Integer> sub = subListWithoutOccurrences(i);
        return average.compute(sub);
    }

    /**
     * Remplace toutes les occurrences d'une valeur par une nouvelle valeur.
     *
     * @param oldValue la valeur à remplacer
     * @param newValue la valeur de remplacement
     * @throws exo1.ValueNotFoundException si {@code oldValue} n'apparaît
     * pas dans la liste
     */
    @Override
    public void replaceAllOccurrences(int oldValue, int newValue) throws exo1.ValueNotFoundException {
        boolean found = false;
        for (int j = 0; j < liste.size(); j++) {
            if (liste.get(j).equals(oldValue)) {
                liste.set(j, newValue);
                found = true;
            }
        }
        if (!found) {
            throw new exo1.ValueNotFoundException();
        }
    }


    /**
     * Retourne une copie de la liste dans laquelle toutes les occurrences
     * d'une valeur ont été retirées. La liste d'origine n'est pas modifiée.
     *
     * @param i la valeur à exclure de la liste retournée
     * @return une nouvelle liste ne contenant plus aucune occurrence de {@code i}
     * @throws exo1.ValueNotFoundException si la valeur {@code i} n'apparaît
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