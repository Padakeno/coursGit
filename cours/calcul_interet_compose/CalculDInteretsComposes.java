import java.util.Scanner;
public class CalculDInteretsComposes {

/*
Exercice 2 : clacul d'interet composes
Le total des interets generes sera affiché à l'écran.

Exercice 3 : calcul d'interet composés affichage sous de tableau avec de la couleur
*/
  
  public static void main (String[] args) {
  
    Scanner scanner = new Scanner(System.in);
  
    System.out.println("Saississez la somme d'argent : ");
    float somme = scanner.nextFloat();
       
    System.out.println("Saississez le taux d'interets : ");
    float interets = scanner.nextFloat();
       
    System.out.println("Saississez le nombre d'année");
    int nbAnnee = scanner.nextInt();
    

    float total = 0; // déclaration et initialisation
    int i = 1;
    while (i<nbAnnee) {
    //for(int i=0; i<nbAnnee; i++) {
	float  interetDUneAnnee = somme*interets/100;
	somme = somme + interetDUneAnnee;
	
	System.out.println("la somme est "+ somme + "€ pour l'annee "+i);
	
	total = total + interetDUneAnnee;
	
	i++;
    }
      
    System.out.println("l'interet total est : "+ total + " €");	  
 
  }
}