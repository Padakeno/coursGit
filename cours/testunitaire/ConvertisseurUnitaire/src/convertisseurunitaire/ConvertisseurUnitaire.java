/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertisseurunitaire;

/**
 *
 * @author slam
 */
public class ConvertisseurUnitaire {

    public ConvertisseurUnitaire() {

    }

    public double Calcul(double valeur, int uniteDepart, int uniteArrivee) {
        return valeur * Math.pow(10, uniteDepart - uniteArrivee);
    }
}
