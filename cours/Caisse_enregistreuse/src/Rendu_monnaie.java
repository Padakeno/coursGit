
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author slam
 */
public class Rendu_monnaie {
    public static void main(String[] args) {
        System.out.println("Argent client : ");
        BigDecimal sommeProduit = new BigDecimal("10");
        BigDecimal tableMonnaie [] = {new BigDecimal("200.00"), 
                                        new BigDecimal("100.00"), 
                                        new BigDecimal("50.00"), 
                                        new BigDecimal("20.00"), 
                                        new BigDecimal("10.00"), 
                                        new BigDecimal("5.00"), 
                                        new BigDecimal("2.00"), 
                                        new BigDecimal("1.00"), 
                                        new BigDecimal("0.50"), 
                                        new BigDecimal("0.20"), 
                                        new BigDecimal("0.10"), 
                                        new BigDecimal("0.05"), 
                                        new BigDecimal("0.02"), 
                                        new BigDecimal("0.01")};

        
        ArrayList<BigDecimal> maListe = new ArrayList<BigDecimal>();
        int listeMonnaie [] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        
	Scanner scanner = new Scanner(System.in);
	BigDecimal argentClient = scanner.nextBigDecimal();
        BigDecimal argentArendre = argentClient.subtract(sommeProduit); 
        
        
        System.out.println("Monnaie à rendre au client : "+argentArendre);
        
        
        while(argentArendre.compareTo(BigDecimal.ZERO) != 0) {
            for (int i=0; i<tableMonnaie.length; i++) {
                BigDecimal test = argentArendre.subtract(tableMonnaie[i]);
                if (test.compareTo(BigDecimal.ZERO) >= 0) {
                    argentArendre = argentArendre.subtract(tableMonnaie[i]);
                    maListe.add(tableMonnaie[i]);
                    listeMonnaie[i]++;
                    i=14;
                }
            }
        }
        
       /*System.out.println("");
        for (BigDecimal s : maListe) {
            System.out.println(s);
	}*/
        
        System.out.println("");
        for (int m = 0; m < listeMonnaie.length; m++) {
            if (listeMonnaie[m] != 0) {
                System.out.println("X"+listeMonnaie[m]+" "+tableMonnaie[m]);
                
            }

        }
        
        
    }
}
