package exemple3;

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
    p1.afficher();
  }

}
