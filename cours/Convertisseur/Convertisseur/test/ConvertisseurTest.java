

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import convertisseur.Convertisseur;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Bamba Mohamed
 */
public class ConvertisseurTest {
    private Convertisseur convertisseur;
    
    public ConvertisseurTest() {}
    
    @Before
    public void setUp() {
        // cette méthode est exécutée avant chaque méthode de test        
        convertisseur = new Convertisseur ();
        System.out.println("setup");
    }
    
    @Test
    public void testConvertir() {
        Assert.assertEquals(convertisseur.conversion(12.0, "mm", "cm"), 1.2);
        Assert.assertEquals(convertisseur.conversion(12000.0, "mm", "dm"), 120);
        Assert.assertEquals(convertisseur.conversion(12.0, "mm", "m"), 0.012);
        Assert.assertEquals(convertisseur.conversion(12000.0, "mm", "dam"), 1.2);
        Assert.assertEquals(convertisseur.conversion(12.0, "mm", "hm"), 0.00012);
        Assert.assertEquals(convertisseur.conversion(12000.0, "mm", "km"), 0.012);
        Assert.assertEquals(convertisseur.conversion(12.0, "mm", "mm"), 12.0);
        Assert.assertEquals(convertisseur.conversion(12000.0, "km", "m"), 12000000.0);
        Assert.assertEquals(convertisseur.conversion(12.0, "m", "km"), 0.012);
        Assert.assertEquals(convertisseur.conversion(12.0, "km", "mm"), 12_000_000.0);
        
    }
}
