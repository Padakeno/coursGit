/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amortissement;

import java.util.Scanner;
import java.lang.Integer;

/**
 *
 * @author mohamed Bamba
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Montant Emprunt : ");
        double montantEmprunt = scanner.nextDouble();
        System.out.println("Duree Amortissement : ");
        int dureeAmortissement = scanner.nextInt();
        System.out.println("Date Depart : ");
        int dateDepart = scanner.nextInt();
        
        Amortissement a = new Amortissement(montantEmprunt, dureeAmortissement, dateDepart);
        Amortissement a0 = new Amortissement(montantEmprunt, dureeAmortissement, dateDepart);
        
        Amortissement[] tabAmort = new Amortissement[dureeAmortissement]; 
        
        for(int i = 0; i<=dureeAmortissement; i++) {
            if(i == 0) {
                tabAmort[i] = a;
            } else {
                tabAmort[i] = a.concat(Integer i);
            }
        }
        
    }
    
}
