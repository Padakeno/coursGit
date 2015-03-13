package demo_classe_abstraite;

public class Stagiaire extends Personne {

    public Stagiaire(String nom, String prenom) {
        super(nom, prenom);
    }

    @Override
    public void afficher() {
        System.out.println(getNom() + " " + getPrenom());
    }
}