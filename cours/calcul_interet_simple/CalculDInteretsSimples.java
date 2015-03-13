import java.util.Scanner;

public class CalculDInteretsSimples {
  
  /* Exercice : calcul d'interets simples

  il faut saisir :

      -la somme d'argent
      -le taux d'intérêts
      -le nombre d'année pendant lesquelles la somme d'argent est placée
      
  Le total des intérêts générés sera affiché à l'écran.

  Exemple : 1 000 € placé pendant 3ans  à un taux de 2.5% nous donne un total  €
  */
  
   // point d'entrée du programme
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in); // System.in représente l'entrée standard (par défaut, le clavier)

       // System.out représente la sortie standard (par défaut, l'écran)
       System.out.println("Saisissez la somme d'argent : ");
       float somme = scanner.nextFloat();
       
       System.out.println("Saisissez le taux d'interets : ");
       float interets = scanner.nextFloat();
       
       System.out.println("Saisissez le nombre d'année");
       int nbAnnee = scanner.nextInt();
       
       System.out.println ("le prix total est : "+ somme*interets*nbAnnee/100 + " €");
       
   }

}



