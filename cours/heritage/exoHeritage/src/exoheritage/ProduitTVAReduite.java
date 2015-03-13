/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exoheritage;

/**
 *Constructeur
 * @params prixTaxeReduite
 * 
 * @author Bamba Mohamed
 */
public class ProduitTVAReduite extends Produit {
    private double prixTaxeReduite;
    
    public ProduitTVAReduite(String nom, double prixHT) {
        super(nom, prixHT);
    }
    
    @Override
    public double calculerPrixTaxe() {
        super.calculerPrixTaxe();
        getPrixHT();
        prixTaxeReduite = prixHT + (prixHT*5.5/100);
        return Math.round(prixTaxeReduite);
    }
    
    @Override
    public String ToString() {
         return "PrixHT : " + prixHT + ", Prix avec taxe réduite : " + prixTaxeReduite;
     }
}
