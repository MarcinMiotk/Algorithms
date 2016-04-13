package com.snmill.cp.pairs;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Stack;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class SolutionTest {

    public SolutionTest() {
    }

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private Solution.PairsOfIntegersWhoseDifferenceIsKImpl counter;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        counter = new Solution.PairsOfIntegersWhoseDifferenceIsKImpl();
    }

    @After
    public void tearDown() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void kDifference_3() {
        String input = ""
                + "5 2\n"
                + "1 5 3 4 2";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("3", outContent.toString().trim());
    }

    @Test
    public void kDifference_0() {
        String input = ""
                + "10 1\n"
                + "363374326 364147530 61825163 1073065718 1281246024 1399469912 428047635 491595254 879792181 1069262793";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("0", outContent.toString().trim());
    }

    @Test
    public void count_2_pairsWithK_1() {
        int count = counter.countPairsOfIntegersWhoseDifferenceIsK(new int[]{1, 2, 3}, 1);
        assertEquals(2, count);
    }

    @Test
    public void count_2_pairsWithK_1_andReveresOrder() {
        int count = counter.countPairsOfIntegersWhoseDifferenceIsK(new int[]{3, 2, 1}, 1);
        assertEquals(2, count);
    }

    @Test
    public void kCanBeMin1() {
        int count = counter.countPairsOfIntegersWhoseDifferenceIsK(new int[]{1, 2, 5}, 1);
        assertEquals(1, count);
    }

    @Test
    public void kCanBeMax1_000_000_000() {
        int count = counter.countPairsOfIntegersWhoseDifferenceIsK(new int[]{1, 1_000_000_000, 1_999_999_999}, 999_999_999);
        assertEquals(2, count);
    }

    @Test
    public void eachArrayItemCanBeMin1() {
        counter.countPairsOfIntegersWhoseDifferenceIsK(new int[]{1, Integer.MAX_VALUE}, 2);
    }

    @Test
    public void eachArrayItemCanBeMax2mld() {
        counter.countPairsOfIntegersWhoseDifferenceIsK(new int[]{1, Integer.MAX_VALUE}, 1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldEachArrayItemsBeUnique() {
        counter.countPairsOfIntegersWhoseDifferenceIsK(new int[]{1, 1, 1}, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldEachArrayItemsBeGreaterThan0() {
        counter.countPairsOfIntegersWhoseDifferenceIsK(new int[]{1, -2, 3}, 1);
    }

    @Test
    public void nCanBeMax100_000() {
        int n = 100000;
        int[] input = new int[n];
        int valueToSet = 1;
        for (int i = 0; i < n; i++) {
            input[i] = valueToSet;
            valueToSet += 3;
        }
        int count = counter.countPairsOfIntegersWhoseDifferenceIsK(input, 2);
        assertEquals(0, count);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNBeLessOrEqualThan_100_000() {
        int n = 100001;
        int[] input = new int[n];
        int valueToSet = 1;
        for (int i = 0; i < n; i++) {
            input[i] = valueToSet;
            valueToSet += 3;
        }
        int count = counter.countPairsOfIntegersWhoseDifferenceIsK(input, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldKBeGreaterThan0() {
        int count = counter.countPairsOfIntegersWhoseDifferenceIsK(new int[]{1, 2, 3}, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldKBeGreaterThan0_case2() {
        int count = counter.countPairsOfIntegersWhoseDifferenceIsK(new int[]{1, 2, 3}, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldKBeLessThan_1000000000() {
        int count = counter.countPairsOfIntegersWhoseDifferenceIsK(new int[]{1, 2, 3}, 1000000001);
    }

    @Test
    public void count_3_pairsWithK_1_case2() {
        int count = counter.countPairsOfIntegersWhoseDifferenceIsK(new int[]{1, 2, 3, 4}, 1);
        assertEquals(3, count);
    }

    @Test
    public void computeDeltas_case1() {
        long[] deltas = counter.computeDeltas(new int[]{1, 2, 3, 4});
        assertArrayEquals(new long[]{0, 1, 1, 1}, deltas);
    }

    @Test
    public void computeDeltas_case2() {
        long[] deltas = counter.computeDeltas(new int[]{1, 3, 4, 6});
        assertArrayEquals(new long[]{0, 2, 1, 2}, deltas);
    }

    @Test
    public void count_3_pairsWithK_2_ArrayIsUnordered() {
        int count = counter.countPairsOfIntegersWhoseDifferenceIsK(new int[]{1, 5, 3, 4, 2}, 2);
        assertEquals(3, count);
    }

    @Test
    public void computeDeltas_case3() {
        long[] deltas = counter.computeDeltas(new int[]{1, 2, 3, 4, 5});
        // 1, 5, 3, 4, 2 = 1, 2, 3, 4, 5
        assertArrayEquals(new long[]{0, 1, 1, 1, 1}, deltas);
    }

    /**
     * Stack based
     *
     * stack has
     *
     * Stack A = 1;2;3;4;5
     *
     * Stack B = empty
     *
     * pop 5, pop 4
     *
     * diff 5-4 = 1 it is <2 so pop 3
     *
     * diff 5-3 = 2 it is =2 so i remove 5 and counter++ and push 4
     *
     * Stack A = 1;2;3;4
     *
     * pop 4, pop 3
     *
     * diff 4-3 = 1 it is <2 so pop 2
     *
     * diff 4-2 = 2 it is =2 so i remove 4 and counter++ and push 3
     *
     * Stack A = 1;2;3
     *
     * pop 3, pop 2
     *
     * diff 3-2=1 it is <2 so pop 1
     *
     * diff 3-1=2 it is =2 so i remove 3 and counter++ and push 2
     *
     * Stack A = 1;2
     *
     * pop 2, pop 1
     *
     * diff 2-1=1 it is <1 so i try pop
     *
     * there is no more data so i return counter
     *
     *
     *
     */
    @Test
    public void countBasedOnStack_case1() {
        int result = counter.countBasedOnStack(new int[]{1, 2, 3, 4, 5}, 2);
        // 1, 5, 3, 4, 2 = 1, 2, 3, 4, 5
        assertEquals(3, result);
    }

    @Test
    public void countIs99999() {
        int n = 100000;
        int[] input = new int[n];
        int valueToSet = 1;
        for (int i = 0; i < n; i++) {
            input[i] = valueToSet;
            valueToSet += 3;
        }
        int count = counter.countPairsOfIntegersWhoseDifferenceIsK(input, 3);
        assertEquals(99999, count);
    }

    @Test
    public void countPairsOfIntegersWhoseDifferenceIsK_k_1_result_4() {
        int count = counter.countPairsOfIntegersWhoseDifferenceIsK(new int[]{2, 6, 7, 9, 3, 1, 4}, 1);
        assertEquals(4, count);
    }

    @Test
    public void countPairsOfIntegersWhoseDifferenceIsK_k_2_result_4() {
        int count = counter.countPairsOfIntegersWhoseDifferenceIsK(new int[]{2, 6, 7, 9, 3, 1, 4}, 2);
        assertEquals(4, count);
    }

    @Test
    public void countPairsOfIntegersWhoseDifferenceIsK_k_3_result_4() {
        int count = counter.countPairsOfIntegersWhoseDifferenceIsK(new int[]{2, 6, 7, 9, 3, 1, 4}, 3);
        assertEquals(4, count);
    }

    @Test
    public void countPairsOfIntegersWhoseDifferenceIsK_k_4_result_2() {
        int count = counter.countPairsOfIntegersWhoseDifferenceIsK(new int[]{2, 6, 7, 9, 3, 1, 4}, 4);
        assertEquals(2, count);
    }

    @Test
    public void countPairsOfIntegersWhoseDifferenceIsK_k_5_result_3() {
        int count = counter.countPairsOfIntegersWhoseDifferenceIsK(new int[]{2, 6, 7, 9, 3, 1, 4}, 5);
        assertEquals(3, count);
    }

    @Test
    public void countPairsOfIntegersWhoseDifferenceIsK_k_6_result_2() {
        int count = counter.countPairsOfIntegersWhoseDifferenceIsK(new int[]{2, 6, 7, 9, 3, 1, 4}, 6);
        assertEquals(2, count);
    }

    @Test
    public void countPairsOfIntegersWhoseDifferenceIsK_k_7_result_1() {
        int count = counter.countPairsOfIntegersWhoseDifferenceIsK(new int[]{2, 6, 7, 9, 3, 1, 4}, 7);
        assertEquals(1, count);
    }

    @Test
    public void countPairsOfIntegersWhoseDifferenceIsK_k_8_result_1() {
        int count = counter.countPairsOfIntegersWhoseDifferenceIsK(new int[]{2, 6, 7, 9, 3, 1, 4}, 8);
        assertEquals(1, count);
    }

    @Test
    public void copySecondStackIntoFirstAndThenClearSecond() {
        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();
        a.push(1);
        a.push(2);
        a.push(3);
        b.push(11);
        b.push(10);
        counter.copySecondStackIntoFirstAndThenClearSecond(a, b);
        assertEquals(0, b.size());
        assertEquals(5, a.size());
        assertEquals(1, (int) a.get(0));
        assertEquals(2, (int) a.get(1));
        assertEquals(3, (int) a.get(2));
        assertEquals(10, (int) a.get(3));
        assertEquals(11, (int) a.get(4));
    }
}
