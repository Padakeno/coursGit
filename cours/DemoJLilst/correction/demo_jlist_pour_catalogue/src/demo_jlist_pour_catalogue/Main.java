package demo_jlist_pour_catalogue;

import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;

/**
 *  
 * @author A. FRANÇOIS
 */
public class Main {

    /**
     * point d'entrée de l'application
     * 
     * @param args les arguments de la ligne de commandes
     */
    public static void main(String[] args) {
                Main m = new Main();
        m.demarrer();
    }
    
    private void demarrer() {
        // mise en place du look and fell
        /*PlasticLookAndFeel.setPlasticTheme(new DesertBluer());
        try {
            UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
        } catch (Exception e) {
            System.err.println("Problème avec le look & feel");
        }*/

        // jeu d'essai
        List<Snippet> snippets = new ArrayList<>();
        snippets.add(new Snippet("A"));
        snippets.add(new Snippet("B"));
        snippets.add(new Snippet("C"));
        snippets.add(new Snippet("D"));
        snippets.add(new Snippet("E"));
        

        // affichage de la fenêtre principale
        /*FenetrePrincipale fp = new FenetrePrincipale(personnes);
        fp.setLocationRelativeTo(null); // permet de placer la fenêtre au centre de l'écran
        fp.setVisible(true);
        */
        
        // affichage de la fenêtre principale en utilisant Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // affichage de l'interface graphique                
                FenetrePrincipale fp = new FenetrePrincipale(snippets);
                fp.setLocationRelativeTo(null);  // centrage de la fenêtre
                fp.setVisible(true);
            }
        });
    }
}
