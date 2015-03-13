package demo_produit;

import java.util.Locale;

public class Produit {
    public static final double TVA = 0.196;
    public static final double TVA_REDUITE = 0.055;
    public static final double TIPP = 0.60;

    private String libelle;
    private double prixHT;
    // le type "double" consomme plus de mémoire que
    // le type "float" car il est plus précis
    // par commodité, nous utiliserons le type double
    public Produit(String libelle, double prixHT) {
        this.libelle = libelle;
        this.prixHT = prixHT;
    }

    public double calculerPrixTTC() {
           return this.prixHT*this.TVA+this.prixHT;
    }

    @Override
    public String toString(){
        return "Nom du produit: " + this.libelle+" Prix HT: " + String.format(Locale.FRENCH, "%,.2f", this.prixHT) + " €   Prix TTC: " + String.format(Locale.FRENCH, "%,.2f", calculerPrixTTC()) + " €";
    }

    public double getPrixHT() {
        return this.prixHT;
    }

    public String getLibelle() {
        return this.libelle;
    }
}