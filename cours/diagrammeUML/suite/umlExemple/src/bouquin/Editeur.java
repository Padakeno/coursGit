/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouquin;

import java.util.ArrayList;

/**
 *
 * @author slam
 */
public class Editeur {
    private String nom;
    private ArrayList<Livre> livres;
    
    public Editeur(String nom) {
        this.nom = nom;
        this.livres = new ArrayList();
    }
    
    public void ajouter(Livre l) {
        livres.add(l);
    }
    
    public void supprimer(Livre l) {
        livres.remove(l);
    }
    
    public void modifier(Livre l) {
        int index = livres.indexOf(l);
    }
    
    public void edition(Livre l) {
        System.out.println();
    }
}
