/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demotestsunitaires2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author A. F
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({demotestsunitaires2.OutilsTest.class, demotestsunitaires2.CalculTest.class})
public class DemoTestSuite {
    // pas besoin de mettre du code ici
    // la suite de tests est composée des cas de tests OutilsTest et CalculTest
}
