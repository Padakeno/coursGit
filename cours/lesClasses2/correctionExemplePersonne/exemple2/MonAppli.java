package exemple2;

public class MonAppli {
  /*
   * point d'entrée de l'application
  */
  public static void main(String[] args) {
    MonAppli monAppli = new MonAppli(); // on crée l'objet représentant l'application
    monAppli.demarrer();
  }

  /**
   * constructeur
  */
  public MonAppli() {
  }


  private void demarrer() {
    Personne p1 = new Personne("MARTIN", "Paul");
    p1.setAdresse("5", "rue des Alouettes", "REIMS");

    Personne p2 = new Personne("MERCIER", "Anne");
    p2.setAdresse("8", "avenue Robespierre", "EPERNAY");

    Personne p3 = p2;

    p1.afficher();
    p2.afficher();
    p3.afficher();
    System.out.println("-----------------");

    p2.setNom("BOUCHOT");
    // que vaut p1 ?
    p1.afficher();
    p2.afficher();
    p3.afficher();
  }

}
