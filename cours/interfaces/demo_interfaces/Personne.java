package demo_interfaces;

public class Personne implements Etudiant, Affichable {

    private String nom;
    private String prenom;
    private int[] notes;

    Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        notes = new int[20];
    }

    @Override
    public void afficher() {
        System.out.println(prenom + " " + nom);
    }
    
    @Override
    public int[] getNotes() {
        return notes;
    }
}
 
