/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouquin;

/**
 *
 * @author slam
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Editeur editeur = new Editeur("livre de poche");
        Livre livre = new Livre("Le Parfum", "Patrick Süskind", editeur);
        editeur.ajouter(livre);
        /*public creationLivre() {
            
        }*/
    }
}
