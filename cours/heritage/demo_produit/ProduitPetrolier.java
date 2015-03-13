package demo_produit;

import java.util.Locale;

public class ProduitPetrolier extends Produit {

/*    public ProduitTVAReduite() {

    }
*/
    public ProduitPetrolier (String libelle, double prixHT) {
        super(libelle, prixHT); // appel du constructeur de la classe mere

    }

    @Override
    public double calculerPrixTTC() {
        double resultat = getPrixHT()*Produit.TIPP + getPrixHT();
        resultat = resultat * Produit.TVA + resultat;
        return resultat;

    }

    @Override
    public String toString(){
        return "Nom du produit (pétrolier) : " + getLibelle()+" Prix HT: " + String.format(Locale.FRENCH, "%,.2f", getPrixHT()) + " €   Prix TTC: " + String.format(Locale.FRENCH, "%,.2f", calculerPrixTTC()) + " €";
    }

}