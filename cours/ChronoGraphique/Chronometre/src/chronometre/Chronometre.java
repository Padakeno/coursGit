/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chronometre;

/**
 * @params champs
 * @author slam
 */
public class Chronometre {
    private long debut;
    private long tempsEcoule;
    private boolean demarre;
    
    public Chronometre() {
        this.tempsEcoule = 0;
        this.demarre = false;
    }
    
    public void demarrer() {
        this.demarre = true;
        this.debut = System.currentTimeMillis();
        
    }
    
    public void arreter() {        
        if (this.demarre) {
            this.tempsEcoule = this.tempsEcoule + System.currentTimeMillis() - this.debut;
            this.demarre = false;
        }
    }
    
    public void mettreAZero() {
        this.tempsEcoule = 0;
        this.demarre = false;
    }
    
    public long getTempsEcoule() {
        long resultat; // variable locale

        if (this.demarre) {
            resultat = this.tempsEcoule + System.currentTimeMillis() - this.debut;
        } else {
            resultat = this.tempsEcoule;
        }

        return resultat;
    }
    
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
