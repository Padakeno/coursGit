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
    	Son son1 = new Son("/ressources/BERNARD_C_39_EST_QUI_LE_PATRON_.wav");
        Son son2 = new Son("/ressources/Grand_Chariot_Transformation.wav");
        Son son3 = new Son("/ressources/J_39_aime_les_licornes_featuring_Orelsan_.wav");
        Son son4 = new Son("/ressources/SSJ_Goku_39_s_Kamehameha_Vs_LSSJ_Broly_1080p_HD_.wav");
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