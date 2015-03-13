package demo_classe_abstraite;

public abstract class Personne {

    private String nom;
    private String prenom;

    public Personne() {
        nom = "INCONNU";
    }

    public Personne(String nom, String prenom) {
        this.nom = nom; // this.nom représente l'attribut nom alors que nom représente le paramètre nom
        this.prenom = prenom;
    }

    public abstract void afficher(); // les classes qui hérite de Personne devront implémenter (donner un corps à) afficher
    // si elles sont concrètes

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
