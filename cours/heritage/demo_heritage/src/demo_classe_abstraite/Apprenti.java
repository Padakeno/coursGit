package demo_classe_abstraite;

public class Apprenti extends Personne {

    public Apprenti(String nom, String prenom) {
        super(nom, prenom);
    }

    @Override
    public void afficher() {
        System.out.println(getNom() + " " + getPrenom());
    }
}
