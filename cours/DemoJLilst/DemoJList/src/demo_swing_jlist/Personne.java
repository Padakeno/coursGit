package demo_swing_jlist;

/**
 *
 * @author A. FRANÇOIS
 */
public class Personne implements Comparable<Personne> {

    private String nom;
    private String prenom;

    Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public void afficher() {
        System.out.print(prenom + " " + nom);
    }

    @Override
    public int compareTo(Personne p) {
        int resultat = 0;

        if (nom.compareTo(p.nom) == 0) {
            // les noms sont identiques, on fait la comparaison sur le prénom
            resultat = prenom.compareTo(p.prenom);
        } else {
            resultat = nom.compareTo(p.nom);
        }

        return resultat;
    }

    @Override
    public String toString() {
        return nom + " " + prenom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}
