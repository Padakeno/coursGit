/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demotestsunitaires2;

/**
 *
 * @author A. F
 */
public class Outils {  

    /**
     * Cette fonction inverse une chaîne de caractères : le premier caractère devient le dernier, le deuxième devient l'avant-dernier, etc.
     * @param chaine la chaîne à inverser
     * @return la chaîne inversée
     */
    public String inverser(String chaine) {
        // cette fonction ne fonctionne pas bien !
        String resultat = null;

        for (int i = chaine.length() - 1; i >= 1; i--) {
            resultat += chaine.substring(i - 1, i);
        }

        return resultat;
    }
}
