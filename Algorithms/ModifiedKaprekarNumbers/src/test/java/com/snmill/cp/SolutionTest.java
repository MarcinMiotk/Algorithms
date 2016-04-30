package com.snmill.cp;

import com.snmill.cp.Solution.Parts;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
    public void official_1() {
        String input = ""
                + "1\n"
                + "100";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("1 9 45 55 99", outContent.toString().trim());
    }

    @Test
    public void official_2() {
        String input = ""
                + "100\n"
                + "300";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("297", outContent.toString().trim());
    }

    @Test
    public void official_3() {
        String input = ""
                + "400\n"
                + "700";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("INVALID RANGE", outContent.toString().trim());
    }

    @Test
    public void digitsAsEvenArray_25() {
        long[] array = Solution.digitsAsEvenArray(25);
        assertEquals(2, array[1]);
        assertEquals(5, array[0]);
        assertEquals(2, array.length);
    }

    @Test
    public void digitsAsEvenArray_9() {
        long[] array = Solution.digitsAsEvenArray(9);
        assertEquals(2, array.length);
        assertEquals(0, array[1]);
        assertEquals(9, array[0]);
    }

    @Test
    public void digitsAsEvenArray_1234() {
        long[] array = Solution.digitsAsEvenArray(1234);
        assertEquals(1, array[3]);
        assertEquals(2, array[2]);
        assertEquals(3, array[1]);
        assertEquals(4, array[0]);
        assertEquals(4, array.length);
    }

    @Test
    public void digitsAsEvenArray_12345() {
        long[] array = Solution.digitsAsEvenArray(12345);
        assertEquals(0, array[5]);
        assertEquals(1, array[4]);
        assertEquals(2, array[3]);
        assertEquals(3, array[2]);
        assertEquals(4, array[1]);
        assertEquals(5, array[0]);
        assertEquals(6, array.length);
    }

    @Test
    public void split_25_is_2_and_5_check_digitsOnly() {
        Parts parts = Solution.split(25);
        assertEquals(1, parts.len());
        assertEquals(2, parts.leftDigits[0]);
        assertEquals(5, parts.rightDigits[0]);
    }

    @Test
    public void split_123_is_01_and_23_check_digitsOnly() {
        Parts parts = Solution.split(123);
        assertEquals(2, parts.len());
        assertEquals(0, parts.leftDigits[1]);
        assertEquals(1, parts.leftDigits[0]);
        assertEquals(2, parts.rightDigits[1]);
        assertEquals(3, parts.rightDigits[0]);
    }

    @Test
    public void split_25_is_2_and_5_check_sums() {
        Parts parts = Solution.split(25);
        assertEquals(2, parts.left);
        assertEquals(5, parts.right);
        assertEquals(7, parts.sumLeftAndRight);
    }

    @Test
    public void split_123_is_01_and_23_check_sums() {
        Parts parts = Solution.split(123);
        assertEquals(1, parts.left);
        assertEquals(23, parts.right);
        assertEquals(24, parts.sumLeftAndRight);
    }

    @Test
    public void power_for_5_is_25() {
        assertEquals(25, Solution.power2(5));
    }

    @Test
    public void power_for_99999_is_9999800001() {
        assertEquals(9999800001L, Solution.power2(99999));
    }
}
