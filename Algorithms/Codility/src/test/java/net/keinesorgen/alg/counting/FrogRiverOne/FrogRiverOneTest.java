package net.keinesorgen.alg.counting.FrogRiverOne;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class FrogRiverOneTest {

    public FrogRiverOneTest() {
    }

    @Test
    public void testSolution() {
        int X = 5;
        int[] A = new int[]{
            1, 3, 1, 4, 2, 3, 5, 4
        };
        FrogRiverOne instance = new FrogRiverOne();
        int expResult = 6;
        int result = instance.solution(X, A);
        assertEquals(expResult, result);
    }

    @Test
    public void testSolution_fail_1() {
        int X = 5;
        int[] A = new int[]{
            1, 3, 1, 4, 2, 3, 4, 4
        };
        FrogRiverOne instance = new FrogRiverOne();
        int expResult = -1;
        int result = instance.solution(X, A);
        assertEquals(expResult, result);
    }

    @Test
    public void testSolution_5() {
        int X = 5;
        int[] A = new int[]{
            1, 3, 5, 5, 4, 2, 3, 4, 4
        };
        FrogRiverOne instance = new FrogRiverOne();
        int expResult = 5;
        int result = instance.solution(X, A);
        assertEquals(expResult, result);
    }

}
