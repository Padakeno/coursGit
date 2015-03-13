/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caisseenregistreuse;

import java.sql.Date;

/**
 *
 * @author slam
 */
public class Client {
    private String nom;
    private ListeProduit produitAchete;
    private Date tempsFidelite;
    
    // on met ici une liste de produit en parametre, cela implique que dans le main il faudra d'abord initialiser une liste de produit avant de creer le client
    public Client(ListeProduit produitAchete) {
        this.produitAchete = produitAchete;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public Date getFidelite() {
        return this.tempsFidelite;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setFidelite(Date f) {
        this.tempsFidelite = f;
    }
}
