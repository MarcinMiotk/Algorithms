package com.snmill.cp;

import com.snmill.cp.Solution.FindMaxSum;
import com.snmill.cp.Solution.PrefixSums;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
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

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

    }

    @After
    public void tearDown() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void official_test() {
        String input = ""
                + "2 \n"
                + "4 \n"
                + "1 2 3 4\n"
                + "6\n"
                + "2 -1 2 3 4 -5";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("10 10\r\n"
                + "10 11", outContent.toString().trim());
    }

    @Test
    public void official_4_elements() {
        FindMaxSum solution = new FindMaxSum(new int[]{1, 2, 3, 4});
        int maxSum = solution.findMaxContiguousSum();
        assertEquals(10, maxSum);
    }

    @Test
    public void official_6_elements() {
        FindMaxSum solution = new FindMaxSum(new int[]{2, -1, 2, 3, 4, -5});
        int maxSum = solution.findMaxContiguousSum();
        assertEquals(10, maxSum);
    }

    //@Test
    public void recorrency_bestY_is_4() {
        FindMaxSum solution = new FindMaxSum(new int[]{});
        int bestY = solution.findBestY_recurrency(new int[]{0, 2, 1, 3, 6, 10, 5}, 0, 5);
        assertEquals(4, bestY);
    }

    @Test
    public void official_test2() {
        String input = ""
                + "6\n"
                + "1\n"
                + "1\n"
                + "6\n"
                + "-1 -2 -3 -4 -5 -6\n"
                + "2\n"
                + "1 -2\n"
                + "3\n"
                + "1 2 3\n"
                + "1\n"
                + "-10\n"
                + "6\n"
                + "1 -1 -1 -1 -1 5";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("1 1\r\n"
                + "-1 -1\r\n"
                + "1 1\r\n"
                + "6 6\r\n"
                + "-10 -10\r\n"
                + "5 6", outContent.toString().trim());
    }

    @Test
    public void findMaxNonContiguousSum_input_1() {
        FindMaxSum solution = new FindMaxSum(new int[]{-10});
        int maxContiguousSum = solution.findMaxNonContiguousSum();
        assertEquals(-10, maxContiguousSum);
    }

    @Test
    public void findMaxNonContiguousSum_input_2() {
        FindMaxSum solution = new FindMaxSum(new int[]{-1, -2, -3, -4, -5, -6});
        int maxContiguousSum = solution.findMaxNonContiguousSum();
        assertEquals(-1, maxContiguousSum);
    }

    @Test
    public void findMaxContiguousSum_input1() {
        FindMaxSum solution = new FindMaxSum(new int[]{2, -1, 2, 3, 4, -5});
        int maxContiguousSum = solution.findMaxContiguousSum();
        assertEquals(10, maxContiguousSum);
    }

    @Test
    public void prefixSums_1() {
        int[] input = new int[]{1, -3, 7, 2, 3};
        int[] prefixes = PrefixSums.sums(input);
        assertEquals(input.length + 1, prefixes.length);
        int[] expectedPrefixes = new int[]{0, 1, -2, 5, 7, 10};
        assertArrayEquals(expectedPrefixes, prefixes);
    }

    @Test
    public void findMaxContiguousSum_input2() {
        FindMaxSum solution = new FindMaxSum(new int[]{1, -1, -1, -1, -1, 5});
        int maxContiguousSum = solution.findMaxContiguousSum();
        assertEquals(5, maxContiguousSum);
    }

    @Test
    public void findMaxContiguousSum_input3() {
        FindMaxSum solution = new FindMaxSum(new int[]{-1, -2, -3, -4, -5, -6});
        int maxContiguousSum = solution.findMaxContiguousSum();
        assertEquals(-1, maxContiguousSum);
    }

    @Test
    public void tenPerformanceTests() throws IOException {
        InputStream in = this.getClass().getResourceAsStream("/performance");
        System.setIn(in);

        Solution.main(null);
        assertEquals("2617065 172083036\r\n"
                + "1274115 193037987\r\n"
                + "2202862 163398048\r\n"
                + "2454939 240462364\r\n"
                + "3239908 186256172\r\n"
                + "2486039 202399661\r\n"
                + "1092777 137409985\r\n"
                + "962621 135978139\r\n"
                + "3020911 224370860\r\n"
                + "1755033 158953999", outContent.toString().trim());
    }
}
