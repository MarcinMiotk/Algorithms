package com.snmill.cp;

import org.junit.Test;

/**
 *
 */
public class SolutionStdoutTest {

    @Test
    public void printSquares() {
        int[] sqrts = Solution.consecutiveIntegerSquares(1000000000);
//        System.out.println("sqrt1=" + sqrt);
        //       assertEquals("3.0", (int) sqrt);
    }
    
    
    @Test
    public void printSquares_100() {
        int[] sqrts = Solution.consecutiveIntegerSquares(100);
//        System.out.println("sqrt1=" + sqrt);
        //       assertEquals("3.0", (int) sqrt);
    }
}
