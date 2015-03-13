package demo_classe_abstraite;

public class SalarieCDI extends Personne {

    public SalarieCDI(String nom, String prenom) {
        super(nom, prenom);
    }

    @Override
    public void afficher() {
        System.out.println(getNom() + " " + getPrenom());
    }
}
