package com.snmill.cp;

import java.util.List;
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

    @Test
    public void testStaircase_nIs_6() {
        int n = 6;
        List<String> result = Solution.staircase(n);
        assertEquals("     #", result.get(0));
        assertEquals("    ##", result.get(1));
        assertEquals("   ###", result.get(2));
        assertEquals("  ####", result.get(3));
        assertEquals(" #####", result.get(4));
        assertEquals("######", result.get(5));
    }

}
