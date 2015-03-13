/**
 * Cette classe représente un chronomètre
 *
 * @author Arnaud FRANCOIS
 */
public class Chrono {
    // variables d'instance ou attributs
    private long debut;
    private long tempsEcoule;
    private boolean demarre;

    /**
     * constructeur par défaut
     */
    public Chrono() {
        this.tempsEcoule = 0;
        this.demarre = false;
    }

    /**
     * démarre le chrono
     */
    public void demarrer() {
        this.demarre = true;
        this.debut = System.currentTimeMillis();
    }

    /**
     * arrête le chrono
     */
    public void arreter() {        
        if (this.demarre) {
            this.tempsEcoule = this.tempsEcoule + System.currentTimeMillis() - this.debut;
            this.demarre = false;
        }
    }

    /**
     * remet le chrono à zéro
     */
    public void mettreAZero() {
        this.tempsEcoule = 0;
        this.demarre = false;
    }

    /**
     * donne le temps écoulé (en ms)
     */
    public long getTempsEcoule() {
        long resultat; // variable locale

        if (this.demarre) {
            resultat = this.tempsEcoule + System.currentTimeMillis() - this.debut;
        } else {
            resultat = this.tempsEcoule;
        }

        return resultat;
    }
    
    /**
     * renvoie le temps écoulé sous la forme jours, heures, minutes, secondes, millisecondes
     */
    public String getTempsEcouleFormate() {
        String resultat;
        long tempsEcoule;
        
        if (this.demarre) {
            tempsEcoule = this.tempsEcoule + System.currentTimeMillis() - this.debut;
        } else {
            tempsEcoule = this.tempsEcoule;
        }

        // calcul des jours
        long nbJours = tempsEcoule / (24*60*60*1000);
        long reste = tempsEcoule % (24*60*60*1000);
        
        // calcul des heures
        long nbHeures = reste / (60*60*1000);
        reste = reste % (60*60*1000);

        // calcul des minutes
        long nbMinutes = reste / (60*1000);
        reste = reste % (60*1000);

        // calcul des secondes
        long nbSecondes = reste / 1000;
        reste = reste % 1000; // le reste représente ici les millisecondes

        
        resultat = nbJours + "j " + nbHeures + "h " + nbMinutes + "min " + nbSecondes + "s " + reste + "ms"; 
        
        return resultat;
    }
    
}
