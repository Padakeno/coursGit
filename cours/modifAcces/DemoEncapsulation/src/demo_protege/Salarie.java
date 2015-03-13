package demo_protege;

public class Salarie extends Personne {
    private double salaire;
    
    public Salarie(String nom, int taille, double salaire) {
        super(nom); // on ne peut accéder au champ nom directement (il est privé)
                    // on passe alors par le constructeur de la super classe
        this.taille = taille; // on peut utiliser taille directement ici
        this.salaire = salaire;
    }
    
    public void afficher() {
        System.out.println(this.getNom() + " " + taille + " " + salaire);
    }
}
