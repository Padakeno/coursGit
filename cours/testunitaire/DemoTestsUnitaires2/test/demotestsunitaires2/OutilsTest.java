package demotestsunitaires2;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author A. F
 */
public class OutilsTest {

    private Outils outils;

    public OutilsTest() {
    }

    @Before
    public void setUp() {
    }

    @Ignore
    @Test
    public void testInverser() {
        Assert.assertNull(outils.inverser(null));

        String res1 = outils.inverser("");
        Assert.assertEquals("La chaîne vide n'est pas gérée", "", res1);

        String res2 = outils.inverser("BTS sio");
        Assert.assertEquals("ois STB", res2);
    }
}
