package demonombres;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author A. FRANÇOIS
 */
public class DemoNombres {
    public static void main(String[] args) {
        // écriture des nombres
        double n1 = 10.0; // 10.0 : 10 en double
        double n2 = 10.0d;  // 10.0d : 10 en double
        float n3 = 10.0f; // 10.0f : 10 en float
        int n4 = 10; // 10 : 10 en int
        long n5 = 10L; // 10L : 10 en long        
        
        // pour faciliter la lecture des nombres, il est possible d'utiliser le caractère "_"
        // par exemple 10000000 est équivalent à 10_000_000
        int n6 = 10_000_000;
        double n7 = 0.123_456;
                
                
        int n8 = 0x41; // nombre codé en hexadécimal
        System.out.println("" + n8);
        int n9 = 0b0100_0001; // nombre codé en binaire
        System.out.println("" + n9);
        
        double n10 = 1.2e3; // notation scientifique : 1.2e3 équivaut à 1.2*10^3 soit 1200
        System.out.println("" + n10); 
             
        
        // problème du codage des nombres
        double n11 = 4735.67; // 4735.67 n'est pas mémorisé sous sa forme exacte
        System.out.println(n11); // l'affichage nous trompe 
        BigDecimal n12 = new BigDecimal(n11); // BigDecimal va nous permettre d'afficher la valeur exacte du nombre
        // en réalité, en machine, 4735.67 est représenté approximativement avec un double (même si l'approximation est très précise)
        System.out.println(n12); // on voit ici la vraie valeur de n11
        
        // si on veut mémoriser 4735.67 sous sa forme exacte
        // il faut utiliser BigDecimal et une chaine de caractères 
        BigDecimal n13 = new BigDecimal("4735.67"); 
        System.out.println(n13); // 4735.67, valeur exacte cette fois
        
        
        // formatage des nombres
        NumberFormat formatage1 = NumberFormat.getInstance(Locale.FRANCE);
        String chaine = formatage1.format(n13);
        System.out.println(chaine);

        NumberFormat formatage2 = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        chaine = formatage2.format(n13);
        System.out.println(chaine);        
    }
}