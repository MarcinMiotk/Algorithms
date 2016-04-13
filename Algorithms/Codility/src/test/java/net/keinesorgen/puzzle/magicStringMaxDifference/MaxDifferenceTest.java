package net.keinesorgen.puzzle.magicStringMaxDifference;

import net.keinesorgen.puzzle.magicStringMaxDifference.MaxDifference;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class MaxDifferenceTest {

    public MaxDifferenceTest() {
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

    @Test
    public void testMaxDifference_8() {
        System.out.println("maxDifference_8");
        int[] a = {2, 3, 10, 2, 4, 8, 1};
        int expResult = 8;
        int result = MaxDifference.maxDifference(a);
        assertEquals(expResult, result);
    }

    @Test
    public void testMaxDifference_2() {
        System.out.println("maxDifference_2");
        int[] a = {7, 9, 5, 6, 3, 2};
        int expResult = 2;
        int result = MaxDifference.maxDifference(a);
        assertEquals(expResult, result);
    }

}
