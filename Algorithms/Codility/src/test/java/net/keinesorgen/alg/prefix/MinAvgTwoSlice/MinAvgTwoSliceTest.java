package net.keinesorgen.alg.prefix.MinAvgTwoSlice;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 */
public class MinAvgTwoSliceTest {

    public MinAvgTwoSliceTest() {
    }

    @Ignore
    @Test
    public void testSolution() {
        int[] A = {4, 2, 2, 5, 1, 5, 8};
        MinAvgTwoSlice instance = new MinAvgTwoSlice();
        int expResult = 1;
        int result = instance.solution(A);
        assertEquals(expResult, result);
    }

    @Ignore
    @Test
    public void testSolution_3() {
        int[] A = {10, 5, 2, 1, 1};
        MinAvgTwoSlice instance = new MinAvgTwoSlice();
        int expResult = 3;
        int result = instance.solution(A);
        assertEquals(expResult, result);
    }

    @Ignore
    @Test
    public void testSolution_2() {
        int[] A = {100, 50, 10, 15, 200};
        MinAvgTwoSlice instance = new MinAvgTwoSlice();
        int expResult = 2;
        int result = instance.solution(A);
        assertEquals(expResult, result);
    }

    @Ignore
    @Test
    public void testSolution_increasing() {
        int[] A = {10, 20, 30, 40};
        MinAvgTwoSlice instance = new MinAvgTwoSlice();
        int expResult = 0;
        int result = instance.solution(A);
        assertEquals(expResult, result);
    }

    @Ignore
    @Test
    public void testSolution_decreasing() {
        int[] A = {40, 30, 20, 10};
        MinAvgTwoSlice instance = new MinAvgTwoSlice();
        int expResult = 2;
        int result = instance.solution(A);
        assertEquals(expResult, result);
    }

    @Ignore
    @Test
    public void testSolution_sinus() {
        int[] A = {100, 1, 5, 300, 1, 5, 200};
        MinAvgTwoSlice instance = new MinAvgTwoSlice();
        int expResult = 1;
        int result = instance.solution(A);
        assertEquals(expResult, result);
    }

    @Ignore
    @Test
    public void testSolution_sinus_second() {
        int[] A = {100, 1, 5, 300, 1, 4, 200};
        MinAvgTwoSlice instance = new MinAvgTwoSlice();
        int expResult = 4;
        int result = instance.solution(A);
        assertEquals(expResult, result);
    }

    @Ignore
    @Test
    public void testSolution_three() {
        int[] A = {100, 100, 100, 1, 10, 1, 100};
        MinAvgTwoSlice instance = new MinAvgTwoSlice();
        int expResult = 3;
        int result = instance.solution(A);
        assertEquals(expResult, result);
    }

    @Ignore
    @Test
    public void testSolution_minus() {
        int[] A = {1, 1, 1, 1, 1, -1, 0, 0, 1, 1};
        MinAvgTwoSlice instance = new MinAvgTwoSlice();
        int expResult = 5;
        int result = instance.solution(A);
        assertEquals(expResult, result);
    }

    @Test
    public void testSolution_minus_two() {
        int[] A = {100, 1, 10, 1, 100, -1, 13, -1, 100};
        MinAvgTwoSlice instance = new MinAvgTwoSlice();
        int expResult = 5;
        int result = instance.solution(A);
        assertEquals(expResult, result);
    }

}
