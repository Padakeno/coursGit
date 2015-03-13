package demo_collections;

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
    
    public String getNom() {
        return nom;
    }
    
    public String getPrenom() {
        return prenom;
    }

    /**
     * cette méthode permet de comparer deux personnes
     */
    @Override
    public int compareTo(Personne p) {
        int resultat = 0;
        
        if (nom.compareTo(p.nom) == 0) {
            // les noms sont identiques, on fait donc la comparaison sur le prénom
            resultat = prenom.compareTo(p.prenom);
        }
        else {
            resultat = nom.compareTo(p.nom);
        }
        
        return resultat;
    }
    
}
