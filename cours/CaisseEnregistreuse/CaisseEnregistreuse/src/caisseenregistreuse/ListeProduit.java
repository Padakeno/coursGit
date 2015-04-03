/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caisseenregistreuse;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bamba Mohamed
 * 
 * description :
 * 
 * ici c'est la liste de prooduit qui va permettre de stocké les produits passés en caisse
 */
public class ListeProduit extends AbstractTableModel{
    private ArrayList<Produit> produits;
    private Produit produit;
    private final String[] entetes = {"N° du Produit", "Nom du produit", "Prix", "Réduction"};
    public ListeProduit() {}
    
    public ArrayList<Produit> getListProduit() {
        return produits;
    }
    
    public double prixTotal() {
        double total = 0;
        
        for (Produit produit : produits) {
            double prix = produit.getPrix();
            total = prix+total;
        }
        
        return total;
    }

    public String getColumnName(int col) {
        return entetes[col];
    }
    
    @Override
    public int getRowCount() {
        return produits.size();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                // Numero produit
                return produits.get(rowIndex).getNumero();
            
            case 1:
                // Nom produit
                 return produits.get(rowIndex).getNom();

            case 2:
                // Prix
                return produits.get(rowIndex).getPrix();

            case 3:
                // Reduction
                return produits.get(rowIndex).getReduction();

            default:
                    throw new IllegalArgumentException();
            }
        }
    }