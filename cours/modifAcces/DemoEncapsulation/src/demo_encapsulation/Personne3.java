package demo_encapsulation;

public class Personne3 {

    private String nom;
    private int taille; // en cm
    // le nom de la variable d'instance "t" est modfiée en "taille"
    // la partie publique n'est pas modifiée (donc cette modification
    // n'entraîne pas de modification dans les classes qui utilisent
    // la classe Personne3)
    private boolean tailleValide;
    
    public Personne3() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        // ici, on peut mieux contrôler la valeur de la taille
        if (taille < 0 || taille > 250) {
            tailleValide = false;
        } else {
            tailleValide = true;
            this.taille = taille;
        }
    }
    
    // si un getter renvoie un booléen, "is" est employé au lieu de "get"
    public boolean isTailleValide() {
        return tailleValide;
    } 
}
