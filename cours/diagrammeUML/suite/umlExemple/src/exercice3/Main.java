/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercice3;

/**
 *
 * @author slam
 * @startuml
 * Proprietaire {
 *     -String nom
 *     -Date date
 * }
 * 
 * Vehicule {
 *     -String nom
 *     -String marque
 * }
 * 
 * Voiture {
 *     -int volumeCoffre
 * }
 * Proprietaire "1" --* "*" Vehicule : possede
 * Voiture --|> Proprietaire
 * Moto --|> Moto
 * @enduml
 */

public class Main {
    public static void main(String[] args){
        
    }
}
