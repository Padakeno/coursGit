package demo_classe_abstraite;

public class Intervenant extends Personne {

    public Intervenant(String nom, String prenom) {
        super(nom, prenom);
    }

    @Override
    public void afficher() {
        System.out.println(getNom() + " " + getPrenom());
    }
}