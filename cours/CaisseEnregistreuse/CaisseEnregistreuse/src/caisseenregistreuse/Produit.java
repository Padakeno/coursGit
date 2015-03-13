/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caisseenregistreuse;

/**
 *
 * @author slam
 */
public class Produit {
    private int numero;
    private String nomProduit;
    private double prix;
    private String codeBarre;
    
    public Produit(int numero, String nomProduit, double prix) {
        this.numero = numero;
        this.nomProduit = nomProduit;
        this.prix = prix;
    }
    
    public int getNumero() {
        return this.numero;
    }
    
    public String getCodeBarre() {
        return codeBarre;
    }
    
    public String getNom(){
        return nomProduit;
    }
    
    public double getPrix() {
        return prix;
    }
}
