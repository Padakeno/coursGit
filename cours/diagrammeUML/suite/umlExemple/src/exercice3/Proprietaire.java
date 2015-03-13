/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercice3;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author slam
 */
public class Proprietaire {
    private String nom;
    private Date dateNaissance;
    private ArrayList<Vehicule> vehicules;
    
    public Proprietaire(String nom, Date dateNaissance) {
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.vehicules = new ArrayList();
    }
    
    public void ajouter(Vehicule v) {
        vehicules.add(v);
    }
    
    public void supprimer(Vehicule v) {
        vehicules.remove(v);
    }
}
