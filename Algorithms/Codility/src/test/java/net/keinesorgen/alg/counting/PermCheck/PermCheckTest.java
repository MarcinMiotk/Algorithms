package net.keinesorgen.alg.counting.PermCheck;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class PermCheckTest {

    public PermCheckTest() {
    }

    @Test
    public void testSolution_yes() {
        int[] A = {4, 1, 3, 2};
        PermCheck instance = new PermCheck();
        boolean expResult = true;
        boolean result = instance.solutionB(A);
        assertEquals(expResult, result);
    }

    @Test
    public void testSolution_no() {
        int[] A = {4, 1, 3};
        PermCheck instance = new PermCheck();
        boolean expResult = false;
        boolean result = instance.solutionB(A);
        assertEquals(expResult, result);
    }

    @Test
    public void testSolution_single_one() {
        int[] A = {1};
        PermCheck instance = new PermCheck();
        boolean expResult = true;
        boolean result = instance.solutionB(A);
        assertEquals(expResult, result);
    }

    @Test
    public void testSolution_single() {
        int[] A = {4};
        PermCheck instance = new PermCheck();
        boolean expResult = false;
        boolean result = instance.solutionB(A);
        assertEquals(expResult, result);
    }

    @Test
    public void testSolution_single_maxmin() {
        int[] A = {1000000000};
        PermCheck instance = new PermCheck();
        boolean expResult = false;
        boolean result = instance.solutionB(A);
        assertEquals(expResult, result);
    }

    @Test
    public void testSolution_single_double() {
        int[] A = {999999999 + 1, 999999999};
        PermCheck instance = new PermCheck();
        boolean expResult = false;
        boolean result = instance.solutionB(A);
        assertEquals(expResult, result);
    }

}
