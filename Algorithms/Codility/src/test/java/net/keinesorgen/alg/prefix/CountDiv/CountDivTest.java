package net.keinesorgen.alg.prefix.CountDiv;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class CountDivTest {

    public CountDivTest() {
    }

    @Test
    public void testSolution_3() {
        int A = 6;
        int B = 11;
        int K = 2;
        CountDiv instance = new CountDiv();
        int expResult = 3;
        int result = instance.solution(A, B, K);
        assertEquals(expResult, result);
    }

    @Test
    public void testSolution_5() {
        int A = 1;
        int B = 20;
        int K = 4;

        /**
         * 4%4 = 0
         *
         * 8%4 = 0
         *
         * 12%4 = 0
         *
         * 16%4 = 0
         *
         * 20%4 = 0
         */
        CountDiv instance = new CountDiv();
        int expResult = 5;
        int result = instance.solution(A, B, K);
        assertEquals(expResult, result);
    }

}
