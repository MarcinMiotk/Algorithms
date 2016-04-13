package net.keinesorgen.alg.counting.MaxCounters;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class MaxCountersTest {

    public MaxCountersTest() {
    }

    @Test
    public void testSolution() {
        int N = 5;
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        MaxCounters instance = new MaxCounters();
        int[] expResult = {3, 2, 2, 4, 2};
        int[] result = instance.solution(N, A);
        assertArrayEquals(expResult, result);
    }

}
