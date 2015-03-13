package demonombresdecimaux;

import chronometer.Chrono;
import java.math.BigDecimal;

/**
 *
 * @author A. FRANÇOIS
 */
public class DemoNombresDecimaux {

    private static final int NOMBRES_A_TRAITER = 10_000_000;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DemoNombresDecimaux dbd = new DemoNombresDecimaux();
        dbd.demarrer();
    }

    private void demarrer() {
        float[] nbFloat = new float[NOMBRES_A_TRAITER];
        double[] nbDouble = new double[NOMBRES_A_TRAITER];
        BigDecimal[] decimaux = new BigDecimal[NOMBRES_A_TRAITER];

        Chrono chrono = new Chrono();

        /* calculs avec des doubles */
        chrono.start();

        // tirage des nombres
        for (int i = 0; i < NOMBRES_A_TRAITER; i++) {
            nbDouble[i] = Math.random();
        }

        // calcul de la somme
        double somme = 0;
        for (int i = 0; i < NOMBRES_A_TRAITER; i++) {
            somme += nbDouble[i];
        }
        chrono.stop();

        System.out.println("somme (avec des doubles):" + somme + "   (" + chrono.getElapsedTime() + " ms)");

        /* calculs avec des float */
        chrono.reset();
        chrono.start();
        // utilisation des nombres précédement tirés pour les doubles
        for (int i = 0; i < NOMBRES_A_TRAITER; i++) {
            nbFloat[i] = (float) nbDouble[i]; // perte de précision : on force la conversion d'un double en float
        }

        // calcul de la somme
        float sommeFloat = 0;
        for (int i = 0; i < NOMBRES_A_TRAITER; i++) {
            sommeFloat += nbFloat[i];
        }
        chrono.stop();
        System.out.println("somme (avec des floats) :" + sommeFloat + "   (" + chrono.getElapsedTime() + " ms)");

        /* calculs avec des BigDecimal */
        chrono.reset();
        chrono.start();

        // tirage des nombres        
        for (int i = 0; i < NOMBRES_A_TRAITER; i++) {
            // construction d'un BigDecimal à partir d'un String
            // le nombre est compris entre 0 et 1 et comporte 2 chiffres
            // après la virgule
            decimaux[i] = new BigDecimal("0." + nb() + nb());
            // il est préférable d'utiliser le constructeur qui prend
            // en paramètre un String
        }

        // calcul de la somme
        BigDecimal sommeBig = new BigDecimal(0);
        for (int i = 0; i < NOMBRES_A_TRAITER; i++) {
            sommeBig = sommeBig.add(decimaux[i]);
        }
        chrono.stop();
        // la somme est calculée avec 2 décimales (avec la règle d'arrondi classique)
        System.out.println("somme (avec des BigDecimal):" + sommeBig + "   (" + chrono.getElapsedTime() + " ms)");
    }

    /**
     *
     * @return un nombre compris entre 0 et 9
     */
    private int nb() {
        return (int) Math.round(Math.random() * 9);
    }
}
