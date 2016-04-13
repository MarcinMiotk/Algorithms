package net.keinesorgen.alg.counting.MissingInteger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class MissingIntegerTest {

    public MissingIntegerTest() {
    }

    @Test
    public void testSolution_ok_from_task() {
        int[] A = new int[]{1, 3, 6, 4, 1, 2};
        MissingInteger instance = new MissingInteger();
        int expResult = 5;
        int result = instance.solution(A);
        assertEquals(expResult, result);
    }

    @Test
    public void testSolution_4() {
        int[] A = new int[]{1000, 2000, 3000, 4000, 5000, 1, 2, 3};
        MissingInteger instance = new MissingInteger();
        int expResult = 4;
        int result = instance.solution(A);
        assertEquals(expResult, result);
    }

    @Test
    public void testSolution_3() {
        int[] A = new int[]{-10, -6, -3, 2, 600, 1};
        MissingInteger instance = new MissingInteger();
        int expResult = 3;
        int result = instance.solution(A);
        assertEquals(expResult, result);
    }

    @Test
    public void testSolution_11() {
        int[] A = new int[]{-10, -6, -3, 2, 600, 1, 5, 4, 3, 6, 7, 8, 9, 10};
        MissingInteger instance = new MissingInteger();
        int expResult = 11;
        int result = instance.solution(A);
        assertEquals(expResult, result);
    }

    @Test
    public void testSolution_sequence() {
        int[] A = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        MissingInteger instance = new MissingInteger();
        int expResult = 12;
        int result = instance.solution(A);
        assertEquals(expResult, result);
    }

    @Test
    public void testSolution_1() {
        int[] A = new int[]{-10, -11, -12, -13, 0};
        MissingInteger instance = new MissingInteger();
        int expResult = 1;
        int result = instance.solution(A);
        assertEquals(expResult, result);
    }
}
