/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exoheritage;

/**
 *Constructeur
 * @params PrixTaxe
 * 
 * @author Bamba Mohamed
 */
public class ProduitPetrolier extends Produit {
    private double prixTaxe;
    
    public ProduitPetrolier(String nom, double prixHT) {
        super(nom, prixHT);
    }
    
    @Override
    public double calculerPrixTaxe() {
        super.calculerPrixTaxe();
        getPrixHT();
        prixTaxe = prixHT + (prixHT*60/100);
        return prixTaxe;
    }
    
    @Override
    public String ToString() {
         return "PrixHT : " + prixHT + ", Prix avec taxe : " + prixTaxe;
     } 
}
