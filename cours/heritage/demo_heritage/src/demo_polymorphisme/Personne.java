package demo_polymorphisme;

public class Personne {

    private String nom;

    public Personne() {
        nom = "INCONNU";
    }

    public Personne(String nom) {
        this.nom = nom; // this.nom représente l'attribut nom alors que nom représente le paramètre nom
    }

    public void afficher() {
        System.out.println(nom);
    }
}
