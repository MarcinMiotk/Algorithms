package net.keinesorgen.puzzle.pathsnumber;

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
    public void testNumberOfPaths_all() {
        System.out.println("numberOfPaths_all");
        int[][] a = {
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 1}};
        int M = 3;
        int N = 4;
        int expResult = 10;
        long start = System.currentTimeMillis();
        int result = Solution.numberOfPaths(a, M, N);
        long time = System.currentTimeMillis() - start;

        System.out.println("time=" + time);

        assertEquals(expResult, result);
    }

    @Test
    public void testNumberOfPaths_none() {
        System.out.println("numberOfPaths_none");
        int[][] a = {
            {1, 0},
            {0, 1}};
        int M = 2;
        int N = 2;
        int expResult = 0;
        int result = Solution.numberOfPaths(a, M, N);
        assertEquals(expResult, result);
    }
}
