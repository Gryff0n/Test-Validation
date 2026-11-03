package exo5;

import java.util.Objects;

public class SommeArgent {
    private int quantite;
    private String unite;
    public SommeArgent(int amount, String currency) {
        quantite = amount;
        unite = currency;
    }
    public int getQuantite() {
        return quantite;
    }
    public String getUnite() {
        return unite;
    }
    public SommeArgent add(SommeArgent m) throws UniteDistincteException {
        if (!Objects.equals(unite, m.getUnite())) {
            throw new UniteDistincteException("Unités distinctes");
        }
        return new SommeArgent(getQuantite()+m.getQuantite(), getUnite());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SommeArgent)) return false;
        SommeArgent that = (SommeArgent) o;
        return quantite == that.quantite && Objects.equals(unite, that.unite);
    }
}