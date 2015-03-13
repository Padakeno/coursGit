/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exoheritage;

/**
 *
 * @author slam
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Produit p1 = new Produit("Coque", 14.5);
        p1.calculerPrixTaxe();
        
        Produit p2 = new ProduitPetrolier("SP95", 14.5);
        p2.calculerPrixTaxe();
        
        Produit p3 = new ProduitTVAReduite("carte de cantine", 14.5);
        p3.calculerPrixTaxe();
        
        p1.ToString();
        p2.ToString();
        p3.ToString();
        
    }
    
}
