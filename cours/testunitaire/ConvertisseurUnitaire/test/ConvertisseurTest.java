import convertisseurunitaire.*;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConvertisseurTest {

    private ConvertisseurUnitaire converteur;

    public ConvertisseurTest() {
        
    }

    @Before
    public void setUp() {
        // cette méthode est exécutée avant chaque méthode de test        
        converteur = new ConvertisseurUnitaire();
    }
    
    // test unité de depart < unité d'arrivée
    @Test
    public void testConvertionUnitesSup() {
        Assert.assertEquals(converteur.Calcul(1.0, Unite.MILLIMETRE, Unite.METRE), 0.001);
        Assert.assertEquals(converteur.Calcul(Math.floor(Math.PI), Unite.DECIMETRE, Unite.HECTOMETRE), 0.003);
        Assert.assertEquals(converteur.Calcul(20, Unite.METRE, Unite.DECAMETRE), 2D);
        Assert.assertEquals(converteur.Calcul(72, Unite.HECTOMETRE, Unite.KILOMETRE), 7.2);
    }
    
    // Test unité de départ = unité arrivée
    @Test
    public void testConvertionUnitesEgales() {
        Assert.assertEquals(converteur.Calcul(Math.exp(Math.log(1)), Unite.CENTIMETRE, Unite.CENTIMETRE), 1D);
        Assert.assertEquals(converteur.Calcul(Math.log(Math.E), Unite.METRE, Unite.METRE), 1D);
        Assert.assertEquals(converteur.Calcul(Math.log(Math.E), Unite.DECIMETRE, Unite.DECIMETRE), 1D);
        Assert.assertEquals(converteur.Calcul(Math.log(Math.E), Unite.KILOMETRE, Unite.KILOMETRE), 1D);
    }
    
    // Test unité de départ > unité arrivée
    @Test
    public void testConvertionUnitesInf() {
        Assert.assertEquals(converteur.Calcul(Math.PI, Unite.METRE, Unite.MILLIMETRE), Math.PI * 1000D);
        Assert.assertEquals(converteur.Calcul(453.1, Unite.DECAMETRE, Unite.DECIMETRE), 45310D);
        Assert.assertEquals(converteur.Calcul(1.0, Unite.KILOMETRE, Unite.METRE), 1000D);
        Assert.assertEquals(converteur.Calcul(6.25, Unite.HECTOMETRE, Unite.DECAMETRE), 62.5);
    }
    
}