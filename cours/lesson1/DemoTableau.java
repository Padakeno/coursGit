import java.util.Scanner; // on peut maintenant utiliser le clavier

public class DemoTableau {

  //methode main : point d'entrée du programme
  public static void main(String[] args) {
    
    //definition d'un tableau d'entiers
    // avec initialisation
    int[] nombres = {5, 6, 3, 12, 4, 16, 11};
    
    //longueur du tableau
    System.out.println("lg tableau nombres" + nombres.length);
    
    // parcours du tableau
    for(int i=0; i<nombres.length; i++) {
      System.out.print(nombres[i]+ " "); 
    }
    
    for(int nombre: nombres) {
      System.out.print(nombre+ " ");
    }
    
    //on définit un tableau de 50 chaines. Le tableau est vide, on ne peut pas mettre plus de 50 chaines dans le tableau
    String[] chaines = new String[50];
    
    //on définit un tableau de chaines qui contient 3 chaines 
    String[] chaines2 = {"toto", "titi", "tutu"};
    
    chaines[0] = "tutu";
    chaines[1] = "titi";
    chaines[2] = "toto";
    chaines[49] = chaines2[1];
    
    // récupération des arguments de la ligne de commande
    // exemple : java DemoTableau gffdgd 45 -uiui jkkt trretre
    for(int i=0; i<args.length; i++) {
      
      System.out.println(args[i]);
    
    }
  }

}