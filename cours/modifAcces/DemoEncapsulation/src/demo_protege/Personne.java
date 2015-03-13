package demo_protege;

public class Personne {
    private String nom;
    protected int taille; // en cm 
    // taille est visible depuis les sous-classes de Personne
    
    public Personne(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }    
}
