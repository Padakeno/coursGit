/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exoheritage;

/**
 * Constructeur
 * @params nom
 * @params prixBase
 * @params prixHT
 * 
 * @author Bamba Mohamed
 */
public class Produit {
    public double TVA = 0.20;
    
    private String nom;
    double prixHT;
    
    public Produit(String nom, double prixHT) {
        this.nom = nom;
        this.prixHT = prixHT;
    }
    
     public double calculerPrixTaxe() {
        return this.prixHT + (this.prixHT * TVA);        
     }
     
     public double getPrixHT() {
         return prixHT;
     }
     
     public String ToString() {
         return "PrixHT : " + prixHT;
     } 
}
