package demo_interfaces;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.demarrer();
    }
    
    private void demarrer() {
        Etudiant e = new Personne("MARTIN", "Paul");
        Affichable a = new Personne("DUPONT", "Marie");
        a.afficher();
    }
}
 
