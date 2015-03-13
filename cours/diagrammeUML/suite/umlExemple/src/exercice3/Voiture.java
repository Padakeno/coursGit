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
public class Voiture extends Vehicule {
    private int volumeCoffre;
    
    public Voiture(String nom, String marque, Proprietaire proprietaire, int volumeCoffre) {
        super(nom, marque, proprietaire);
        this.volumeCoffre = volumeCoffre;
    }
}
