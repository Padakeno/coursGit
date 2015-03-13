package demo_heritage.exemple2;


public class Personne {

    private String nom;

    public Personne() {
        nom = "INCONNU";
    }

    public Personne(String nom) {
        this.nom = nom;
    }

    public void afficher() {
        System.out.println(nom);
    }
}
