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
    private float prix;
    private float codeBarre;
    
    public Produit(int numero, String nomProduit, float prix) {
        this.numero = numero;
        this.nomProduit = nomProduit;
        this.prix = prix;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public float getCodeBarre() {
        return codeBarre;
    }
    
    public String getNom(){
        return nomProduit;
    }
    
    public float getPrix() {
        return prix;
    }
}
