package demoimages;

import javax.swing.SwingUtilities;

/**
 *
 * @author A. FRANÇOIS
 */
public class DemoImages {

    /**
     * @param args les arguments de la ligne de commandes
     */
    public static void main(String[] args) {
     SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // affichage de l'interface graphique                
                FenetrePrincipale fp = new FenetrePrincipale();
                fp.setLocationRelativeTo(null);  // centrage de la fenêtre
                fp.setVisible(true);
            }
        });   
    }

}
