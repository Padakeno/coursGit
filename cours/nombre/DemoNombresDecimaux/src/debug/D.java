package debug;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 * Cette classe facilite l'écriture des messages de débogage.
 *
 * @author A. FRANÇOIS
 */
public class D {

    private static final String NOM_FICHIER_DEBUG = "debug_log.txt";
    private static PrintWriter sortie = null;

    /**
     * écrit sur la sortie erreur standard la chaîne associée à un objet
     *
     * @param objet
     */
    public static void p(Object objet) {
        System.err.println(objet);
    }

    /**
     * écrit un message passé en paramètre dans le fichier de debug
     *
     * @param message
     */
    public static void f(String message) {
        if (sortie == null) {
            try {
                sortie = new PrintWriter(new FileOutputStream(NOM_FICHIER_DEBUG));
            } catch (FileNotFoundException ex) {
                System.err.println("erreur au moment de l'écriture dans le fichier de log");
            }
        }
        sortie.println(message);
        sortie.flush();
    }

    /**
     * affiche un message de débogage avec une fenêtre graphique (Swing)
     *
     * @param message
     */
    public static void m(String message) {
        JOptionPane.showMessageDialog(null, message, "Debug message", JOptionPane.INFORMATION_MESSAGE);
    }
}
