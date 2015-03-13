/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_collection;

import java.util.Scanner;

/**
 *
 * @author Mohamed Bamba
 */
public class Menu {
    // variable d'instance 
    private String[] items;
    
    public Menu(String[] items) {
        this.items = items;
    }
    
    /**
        * renvoyer le choix de l'utilisateur 
    */
    
    public int gerer() {
        int resultat = 0;
        
        //afficher
        for(int i=0; i<items.length; i++) {
            System.out.println((i+1) + " - " + items[i]);
        }
        System.out.println("0 - Quitter");
        
        //saisir
        System.out.println("Choix : ?");
        Scanner scanner = new Scanner(System.in);
        do {
            resultat = scanner.nextInt();
        } while(resultat < 0 || resultat > items.length);
        
        return resultat;
    }
}
