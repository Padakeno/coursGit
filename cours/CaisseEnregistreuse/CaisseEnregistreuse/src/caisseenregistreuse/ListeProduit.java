/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caisseenregistreuse;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author Bamba Mohamed
 * 
 * description :
 * 
 * ici c'est la liste de prooduit qui va permettre de stocké les produits passés en caisse
 */
public class ListeProduit extends AbstractListModel<Produit>{
    private ArrayList<Produit> produits;
    
    public ListeProduit(ArrayList<Produit> produits) {
        this.produits = produits;
    }
    
    public float prixTotal() {
        float total = 0;
        
        for (Produit produit : produits) {
            float prix = produit.getPrix();
        }
        
        return total;
    }
    
    public void ajouter(Produit p) {
        produits.add(p);
        int index = produits.indexOf(p);
        fireContentsChanged(this, index, index); // la JList est prévenue du changement pour qu'elle se mette à jour
    }

    public void supprimer(Produit p) {
        int index = produits.indexOf(p);
        produits.remove(p);
        fireIntervalRemoved(this, index, index); // la JList est prévenue du changement pour qu'elle se mette à jour
    }

    public void modifier(Produit p) {
        int index = produits.indexOf(p);
        fireContentsChanged(this, index, index); // la JList est prévenue du changement pour qu'elle se mette à jour
    }

    @Override
    public int getSize() {
        return produits.size();
    }

    @Override
    public Produit getElementAt(int index) {
        return produits.get(index);
    }
    
}