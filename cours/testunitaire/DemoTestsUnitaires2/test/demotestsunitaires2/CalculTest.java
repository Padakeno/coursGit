package demotestsunitaires2;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author arno
 */
public class CalculTest {

    private Calcul calcul;

    public CalculTest() {
    }

    @Before
    public void setUp() {
        // cette méthode est exécutée avant chaque méthode de test        
        calcul = new Calcul();
        System.out.println("setup");
    }

    @Test
    public void testInc() {
        int x = calcul.inc(10);
        Assert.assertEquals(11, x);
    }

    @Test
    public void testAdditionner() {
        Assert.assertEquals(calcul.additionner(7, 5), 12);
        Assert.assertEquals(calcul.additionner(7, 5, 15), 27);
        Assert.assertEquals(calcul.additionner(7, 5, 15, 341), 368);
    }
}
