package demo_encapsulation;

public class Personne2 {

    private String nom;
    private int t; // taille en cm
    // le nom de cette varialbe d'instance est volontairement peu explicite
    
    public Personne2() {
    }    

    // les getters et les setters ci-dessous
    // ont été générées automatiquement par NetBeans
    // (clic droit > Insert code ...)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTaille() {
        return t;
    }

    public void setTaille(int taille) {
        // ici, on peut mieux contrôler la valeur de la taille
        if (taille < 0 || taille > 250) {
            this.t = 0;
        } else {
            this.t = taille;
        }
    }
}
