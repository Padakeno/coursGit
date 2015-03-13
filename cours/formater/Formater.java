//morceau de code
/*
double nombre = 2541836.74696;

System.out.println(String;format(Locate.FRENCH, "%,.1f" ,nombre)); //signifie utiliser le séparateur de milliers (qui est la virgule pour les anglais et l'espace pour les français) 
// .1f signifie un chiffre après la virgule (la partie décimale est marquée par le point pour les anglais et par une virgule pour les français)

System.out.println(String.format(Locale.ENGLISH,"%,.1f", nombre))
*/
import java.util.Locale;

public class Formater {

    public static void main(String[] args) {
      double nb = 2541836.74696;
      System.out.println(String.format(Locale.FRENCH, "%,.1f",nb));
      System.out.println(String.format(Locale.ENGLISH, "%,.1f", nb));
    }
}