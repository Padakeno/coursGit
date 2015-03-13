package demo_produit;

import java.util.Locale;

public class ProduitTVAReduite extends Produit {

/*    public ProduitTVAReduite() {

    }
*/
    public ProduitTVAReduite (String libelle, double prixHT) {
        super(libelle, prixHT); // appel du constructeur de la classe mere

    }

    @Override
    public double calculerPrixTTC() {
        return getPrixHT()*Produit.TVA_REDUITE+getPrixHT();

    }

    @Override
    public String toString(){
        return "Nom du produit (à TVA réduite) : " + getLibelle()+" Prix HT: " + String.format(Locale.FRENCH, "%,.2f", getPrixHT()) + " €   Prix TTC: " + String.format(Locale.FRENCH, "%,.2f", calculerPrixTTC()) + " €";
    }

}