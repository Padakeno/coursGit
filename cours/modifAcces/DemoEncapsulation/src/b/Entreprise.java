package b;

import a.Client;
// import a.Produit; // Produit n'est pas visible hors du paquet a : erreur de compilation

public class Entreprise {

    public static void main(String args[]) {
        Client c = new Client();
        //Produit p = new Produit(); // impossible
    }
}
