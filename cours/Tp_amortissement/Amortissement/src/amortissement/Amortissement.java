/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amortissement;

import java.util.Date;

/**
 * @author Mohamed Bamba
 */
public class Amortissement {
    private int dureeAmortissement;
    private double montantEmprunt; // valeur d'aquisission
    private int dateDepart;
    private double dotation = montantEmprunt*1/dureeAmortissement;
    private int tauxAmortissement;
    
    /**
     *Constructeur
     * @param montantEmprunt
     * @param dureeAmortissement
     * @param dateDepart
     */
    
    public Amortissement(double montantEmprunt, int dureeAmortissement, int dateDepart) {
        this.montantEmprunt = montantEmprunt;
        this.dureeAmortissement = dureeAmortissement;
        this.dateDepart = dateDepart;
        this.tauxAmortissement = 100/dureeAmortissement;
    }   
    
        
    
    /*public double[] AmortissementCumule() {
        double[] Cumule = null;
        double amortissementCumule = 0;
        for(int i = 0; i<= dureeAmortissement; i++) {
            Cumule[i] = amortissementCumule + montantEmprunt*1/dureeAmortissement; 
        }
        
        return Cumule;
    }*/
    
    public String toString() {
        return dureeAmortissement + "  " + montantEmprunt + "  " + tauxAmortissement; 
    }
}