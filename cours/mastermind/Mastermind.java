/*
    - classe Combinaison
        represente 4 pions avec un ordre
    
    - saisir
        l'utilisateur saisie 4 couleur au clavier
    
    - générer aléatoirement 
    
    - afficher 
    
    - estEfale (combinaison c)
    
    - nbPionBienPlacé (combinaison c)
    
    - nbPionsMalPlacé<
    
    boucle for qu'on execute 10 fois
*/

import java.lang.Math;
public class Mastermind {
    //variables d'instances
    private String[] tableau;
    private String[] bonneReponse;
    private boolean vraiOuFaux;
    
    public bonneReponse(String[] bonneReponse) {
        this.bonneReponse = bonneReponse;
        this.vraiOuFaux = vraiOuFaux;
    }
    
    /**
        * Generer une série aléatoirement, elle sera la reponse qu'on cherche
    */
    
    public tableau() {
        combinaison();
        for(int i=0; i<4; i++) {
            bonneReponse[i] = (int)(Math.random()*8)+1;
        }
        //afficher (le temps de voir si le programme fonctionne)
        for(int i=0; i<bonneReponse.length; i++) {
            System.out.println(bonneReponse[i]);
        }
         do {
            choix();
        } while (combinaison != bonneReponse);
        
        
    }
}