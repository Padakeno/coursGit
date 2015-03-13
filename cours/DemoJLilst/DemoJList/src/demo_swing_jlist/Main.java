package demo_swing_jlist;


import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.PlasticLookAndFeel;
import com.jgoodies.looks.plastic.theme.DesertBluer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.UIManager;

/**
 *
 * @author A. FRANÇOIS
 */
public class Main {

    /**
     * point d'entrée du programme
     * @param args les arguments de la ligne de commande
     */
    public static void main(String[] args) {
        Main m = new Main();
        m.demarrer();
    }

    private void demarrer() {
        // mise en place du look and fell
        PlasticLookAndFeel.setPlasticTheme(new DesertBluer());
        try {
            UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
        } catch (Exception e) {
            System.err.println("Problème avec le look & feel");
        }

        // jeu d'essai
        List<Personne> personnes = new ArrayList<Personne>();
        personnes.add(new Personne("MARTIN", "Paul"));
        personnes.add(new Personne("DURAND", "Anne"));
        personnes.add(new Personne("RICHARD", "Fabrice"));
        personnes.add(new Personne("DUPONT", "Marie"));
        personnes.add(new Personne("PERRON", "Jean"));


        // affichage de la fenêtre principale
        FenetrePrincipale fp = new FenetrePrincipale(personnes);
        fp.setLocationRelativeTo(null); // permet de placer la fenêtre au centre de l'écran
        fp.setVisible(true);
    }
}
