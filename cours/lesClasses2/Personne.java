import java.util.Date;
import java.text.DateFormat;

//la classe Personne a été modifiée pour utiliser la classe Adresse
// la classe MonAppli n'est pas impactée par cette modification 
public class Personne {
    private String nom; // champ nom 
    private String prenom; // champ prenom 
    private Adresse adresse; // champ adresse
  

  /**
    * constructeur
    *
  */
  
  public Personne (String nom, String prenom, String adresse) {
    this.nom = nom;
    this.prenom = prenom;
    
    //this fais référence à l'objet courant
    // un constructeur à pour fonction principal d'initialiser l'objet en cours de création. Il donne donc des valeurs (en général passées en arguments) aux différentes variables d'instance (champs ou attributs)
  }
  
  public class Adresse {
    private String numero;
    private String voie;
    private String ville;
  }
  
  /**
     * affiche les informations du client
     *
   */
  public Adresse(String pNumero, String pVoie, String pVille) {
    numero = pNumero;
    voie =  pVoie;
    ville = pVille;
  }
   
  public void afficher() {
    System.out.println(this.nom + "  " + this.prenom + "  " + this.adresse); // on aurait pu mettre nom au lieu de  this.point nom puisque il n'y a rien dans afficher
  }
  
  /**
    * méthode d'accès ou acccesseur (ou getter)
    * par convention les getters commencent par get
  */
  
  public String getNom() {
    return this.nom;
  }
  
  public String getPrenom() {
    return this.prenom;

  }
  
  public String getAdresse() {
    return this.adresse;
  }
  
  /**
    * methode de modification ou modificateur (setter)
    * par convention les settes commencent par set
  */
  
  public void setAdresse(String pNumero, String pVoie, String pVille) {
    Adresse = pNumero + ", " + pVoie + ", " + pVille;
  }
  
  public void setNom(String nom) {
    this.nom = nom;
  }
  
  /**
    * un autre constructeur
  */
  public Personne(String nom, String prenom) {
    this.nom = nom;
    this.prenom = prenom;
    this.adresse = null;
  }
}// fin de la classe