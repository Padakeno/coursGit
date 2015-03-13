package demo_son;

import javax.swing.SwingUtilities;

/**
 * voir le site http://xpose.avenir.asso.fr/viewxpose.php?site=8&subpage=/javasound/format.html
 *
 * @author Arnaud FRANCOIS
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.demarrer();
    }

    private void demarrer() {
    	Son son1 = new Son("/ressources/Roland-D-20-Sax-C5.wav");
        Son son2 = new Son("/ressources/Shamisen-C4.wav");
        Son son3 = new Son("/ressources/Roland-GR-1-12-String-Guitar-C4.wav");
        Son son4 = new Son("/ressources/Roland-GR-1-Pick-Bass-2-C4.wav");
    	Son son5 = new Son("/ressources/Doumbek-Tek.wav");

        // lancement de l'interface graphique
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                // affichage de l'interface graphique
                Fenetre fenetre = new Fenetre();
                fenetre.setLocationRelativeTo(null);       // permet de centrer le cadrefenetre.setVisible(true);
                fenetre.setVisible(true);
            }
        });
    }

    
    
}