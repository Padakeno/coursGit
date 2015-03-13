package exemple3;


public class Adresse {
  private String numero;
  private String voie;
  private String ville;

  /**
   * constructeur
  */
  public Adresse(String pNumero, String pVoie, String pVille) {
    numero = pNumero;
    voie = pVoie;
    ville = pVille;
  }

  public void afficher() {
    System.out.print(numero + ", " + voie + " " + ville);
  }
}
