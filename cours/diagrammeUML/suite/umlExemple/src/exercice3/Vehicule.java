/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercice3;

/**
 *
 * @author slam
 */
public class Vehicule {
    private String nom;
    private String marque;
    private Proprietaire proprietaire;
    
    public Vehicule(String nom, String marque, Proprietaire proprietaire) {
        this.nom = nom;
        this.marque = marque;
        this.proprietaire = proprietaire;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public String getMarque() {
        return this.marque;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setMarque(String marque) {
        this.marque = marque;
    }
}
