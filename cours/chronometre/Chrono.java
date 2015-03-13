public class Chrono {
  //private Date currentTime = new System.currentTimeMillis();
  private long t1;
  private long t2;
  
  private String tempsEcoule; // cette variable va servir pour calculer le temps ecouler
  private boolean etat; // variable d'instance qui permet de savoir si le chrono est démarrer ou arreter
  
  
  /**
    * initialiser la date
  */
  
  public Chrono() {
  }
 
  /**
   * démarrer le chrono, l'arreter, et donner le Temps 
   */
  public void demarrer() {
    this.t1 = System.currentTimeMillis() + 2000;
  }

  
  public void arreter() {
    this.t2 = System.currentTimeMillis();
  }

  
  public long donnerTemps() {
    return (t2-t1);
  }
  
  /**
    * réinitialiser
    
  public void reinitialiser() {
  
  }*/
}

