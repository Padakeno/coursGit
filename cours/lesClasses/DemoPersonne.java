public class DemoPersonne {
  //point d'entrée du programme
  public static void main(String[] args) {
    
    Personne alcon = new Personne("ALCON", "Jordan", "Reims");
    
    alcon.afficher();
    System.out.println("nom:"+ alcon.getNom());
    System.out.println("prenom:"+ alcon.getPrenom());
    System.out.println("adresse:"+ alcon.getAdresse());
    
    Personne joris = new Personne("Fonck", "Joris");
    joris.setAdresse("Reims");
    joris.afficher();
    
    alcon = null; // l'instance
    alcon.afficher(); // => problème
  }
}