package exemple3;

import java.util.Date;
import java.text.DateFormat;

// la classe Personne a été modifiée pour utiliser la classe Adresse
// la classe MonAplli n'est pas impactée par cette modification
public class Personne {
  private String nom;
  private String prenom;
  private Adresse adresse;

  /**
   * constructeur
  */
  public Personne(String pNom, String pPrenom) {
    nom = pNom;
    prenom = pPrenom;
    adresse = null;
  }

  public void afficher() {
    System.out.print(nom + " " + prenom + " ");
    adresse.afficher();
    System.out.println();
  }



  /**
   * méthode de modification ou modificateur (setter)
  */
  public void setAdresse(String pNumero, String pVoie, String pVille) {
    adresse = new Adresse(pNumero, pVoie, pVille);
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
