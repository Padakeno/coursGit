import java.util.Scanner; // on peut maintenant utiliser Scanner

public class FifthProgram {
  //methode main : point d'entrée du programme
  public static void main(String[] args) {
    String res = formate("ghghg", 11); //appel de la methode avec 2 argument : "abc" et 11 qui est le nombre de caractère
    System.out.println("resultat:" + res);
  }
  
  //definition de la méthode qui est une fonction associé à une classe
  public static String formate(String chaine, int longueur) {
  
    String resultat = chaine;
    
    //System.out.println("lg"+chaine.length());
    for (int i=0; i < longueur-chaine.length(); i++) {
    //on rajoute une espace à gauche
      resultat = " " + resultat;
    }
    
    
    return resultat;
  }
  
}