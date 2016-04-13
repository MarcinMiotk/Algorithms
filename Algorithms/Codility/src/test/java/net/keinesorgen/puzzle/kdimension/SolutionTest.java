package net.keinesorgen.puzzle.kdimension;

import net.keinesorgen.puzzle.kdimension.Solution;
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
     * Test of solution method, of class Solution.
     */
    @Test
    public void testSolution() {
        System.out.println("solution");
        Solution instance = new Solution();
        assertEquals(3, instance.solution(5, 2, new int[]{1, 5, 3, 4, 2}));
    }

}
