package demo_classe_abstraite;

public class SalarieCDD extends Personne {

    public SalarieCDD(String nom, String prenom) {
        super(nom, prenom);
    }

    @Override
    public void afficher() {
        System.out.println(getNom() + " " + getPrenom());
    }
}
