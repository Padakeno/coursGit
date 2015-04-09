package demotestsunitaires2;

/**
 *
 * @author A. F
 */
public class Calcul {

    public int inc(int entier) {
        return entier + 1;
    }

    public int additionner(int... nombres) {
        int resultat = 0;

        for (int n : nombres) {
            resultat += n;
        }

        return resultat;
    }
}
