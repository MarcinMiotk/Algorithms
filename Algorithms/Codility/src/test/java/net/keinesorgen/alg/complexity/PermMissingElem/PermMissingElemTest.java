package net.keinesorgen.alg.complexity.PermMissingElem;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class PermMissingElemTest {

    public PermMissingElemTest() {
    }

    @Test
    public void testSolution_4() {
        int[] A = {2, 3, 1, 5};
        PermMissingElem instance = new PermMissingElem();
        int expResult = 4;
        int result = instance.solution(A);
        assertEquals(expResult, result);
    }

    @Test
    public void testSolution_8() {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 9, 10};
        PermMissingElem instance = new PermMissingElem();
        int expResult = 8;
        int result = instance.solution(A);
        assertEquals(expResult, result);
    }

    @Test
    public void testSolution_precision() {

        int len = 100000;
        long sum = (1L + len) * len / 2;
        assertEquals(5000050000L, sum);

    }
}
