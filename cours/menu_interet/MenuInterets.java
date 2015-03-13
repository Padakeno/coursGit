/*Exercice 4 : ecrire un programme qui permet de calculer les interet simples ou composes. Le choix se fait à l'aide d'un menu qui propose : 

1 - interet simple 
2 - interet composés
3 - quitter

on peut avoir une présentation comme ceci : 
interet [s]imples
interet [c]omposé
[q]uitter
*/

import java.util.Scanner;

public class MenuInteret {

  public static void main (String[] args) {
  
    Scanner scanner = new Scanner(System.in);
    String choix = scanner.next();
    
    while (choix != "q") {
      System.out.println("interet[s]imple\ninteret [c]ompose\n[q]uitter");
      if (choix == "s") {
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
  
  }

}