package exemple2;

public class Personne {
  private String nom;
  private String prenom;
  private String adresse;

  /**
   * constructeur
  */
  public Personne(String pNom, String pPrenom) {
    nom = pNom;
    prenom = pPrenom;
    adresse = null; // pas de valeur connue
  }

  public void afficher() {
    System.out.println(nom + " " + prenom + " " + adresse);
  }



  /**
   * méthode de modification ou modificateur (setter)
  */
  public void setAdresse(String pNumero, String pVoie, String pVille) {
    adresse = pNumero + ", " + pVoie + " " + pVille;
  }


  /**
   * méthode d'accès ou accesseur (getter)
  */
  public String getNom() {
    return nom;
  }

  public void setNom(String pNom) {
    nom = pNom;
  }

}
