package com.snmill.cp;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class SolutionPartialTest {

    public SolutionPartialTest() {
    }

    @Test
    public void minimumAmountToSpend_test1() {
        long toSpend = Solution.minimumAmountToSpend(10, 10, 1, 1, 1);
        assertEquals(20, toSpend);
    }

    @Test
    public void minimumAmountToSpend_test2() {
        long toSpend = Solution.minimumAmountToSpend(5, 9, 2, 3, 4);
        assertEquals(37, toSpend);
    }

    @Test
    public void minimumAmountToSpend_test3() {
        long toSpend = Solution.minimumAmountToSpend(3, 6, 9, 1, 1);
        assertEquals(12, toSpend);
    }

    @Test
    public void minimumAmountToSpend_test4() {
        long toSpend = Solution.minimumAmountToSpend(7, 7, 4, 2, 1);
        assertEquals(35, toSpend);
    }

    @Test
    public void minimumAmountToSpend_test5() {
        long toSpend = Solution.minimumAmountToSpend(3, 3, 1, 9, 2);
        assertEquals(12, toSpend);
    }

    @Test
    public void minimumAmountToSpend_test6() {
        long toSpend = Solution.minimumAmountToSpend(888, 86, 707984, 191923, 428029);
        assertEquals(567022754, toSpend);
    }

    @Test
    public void minimumAmountToSpend_test7() {
        long toSpend = Solution.minimumAmountToSpend(865, 107, 970686, 723490, 741673);
        assertEquals(917056820, toSpend);
    }

    @Test
    public void minimumAmountToSpend_test8() {
        long toSpend = Solution.minimumAmountToSpend(100, 100, 10000, 10000, 0);
        assertEquals(2000000, toSpend);
    }

}
