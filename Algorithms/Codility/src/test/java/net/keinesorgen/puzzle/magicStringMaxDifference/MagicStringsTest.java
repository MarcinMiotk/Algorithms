package net.keinesorgen.puzzle.magicStringMaxDifference;

import net.keinesorgen.puzzle.magicStringMaxDifference.MagicStrings;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class MagicStringsTest {

    public MagicStringsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of solution method, of class MagicStrings.
     */
    @Test
    public void testSolution() {
        System.out.println("solution");
        int M = 50;
        String[] strings = new String[]{
            "aceace",
            "ceceaa",
            "abdbdbdbakjkljhkjh"
        };
        MagicStrings instance = new MagicStrings();
        MagicStrings.Solution expResult = MagicStrings.Solution.EVEN;
        MagicStrings.Solution result = instance.solution(M, strings);
        assertEquals(expResult, result);
    }

}
