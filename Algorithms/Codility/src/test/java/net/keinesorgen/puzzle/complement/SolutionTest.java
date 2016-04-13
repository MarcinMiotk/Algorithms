package net.keinesorgen.puzzle.complement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class SolutionTest {

    public SolutionTest() {
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
     * Test of getIntegerComplement method, of class Solution.
     */
    @Test
    public void testGetIntegerComplement_50() {
        System.out.println("getIntegerComplement_50");
        int n = 50;
        int expResult = 13;
        int result = Solution.getIntegerComplement(n);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetIntegerComplement_100() {
        System.out.println("getIntegerComplement_100");
        int n = 100;
        int expResult = 27;
        int result = Solution.getIntegerComplement(n);
        assertEquals(expResult, result);
    }

}
