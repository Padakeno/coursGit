/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertisseur;

import java.util.Hashtable;
import static java.lang.Math.round;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author slam
 */
public class Convertisseur {
    private Hashtable<String, Integer> unites;
    private Hashtable<String, Integer> AConvertir;
    
    public Convertisseur () {
        unites = new Hashtable();
        AConvertir = new Hashtable();
        
        //insertion des unités et leur valeur
        unites.put("km", 3);
        unites.put("dam", 2);
        unites.put("hm", 1);
        unites.put("m", 0);
        unites.put("dm", -1);
        unites.put("cm", -2);
        unites.put("mm", -3);
        
        AConvertir.put("km", 3);
        AConvertir.put("dam", 2);
        AConvertir.put("hm", 1);
        AConvertir.put("m", 0);
        AConvertir.put("dm", -1);
        AConvertir.put("cm", -2);
        AConvertir.put("mm", -3);
    }
    
    public double conversion(double chiffreConv, String aConvertir,String unite) {
        int indice1 = AConvertir.get(aConvertir); // renvois la valeur du hashtable
        int indice2 = unites.get(unite);
        chiffreConv = chiffreConv*Math.pow(10, indice1 - indice2);
        return chiffreConv;
    }
}
