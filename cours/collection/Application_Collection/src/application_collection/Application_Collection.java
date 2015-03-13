/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_collection;

/**
 *
 * @author slam
 */
public class Application_Collection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] items = {"Ajouer", "Mettre à jour", "Supprimer", "Consulter"};
        Menu menu = new Menu(items);
        
        int choix = menu.gerer();
        
    }
    
}
