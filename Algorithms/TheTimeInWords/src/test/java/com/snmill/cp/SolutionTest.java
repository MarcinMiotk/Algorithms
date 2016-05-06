package com.snmill.cp;

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
                + "5\n"
                + "47  ";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("thirteen minutes to six", outContent.toString().trim());
    }

    @Test
    public void hoursInWords_one() {
        assertEquals("one", new Solution().hoursInWords(1));
    }

    @Test
    public void hoursInWords_five() {
        assertEquals("five", new Solution().hoursInWords(5));
    }

    @Test
    public void minutesInWords_00() {
        assertEquals("o' clock", new Solution().minutesInWords(0));
    }

    @Test
    public void minutesInWords_28() {
        assertEquals("twenty eight minutes past", new Solution().minutesInWords(28));
    }

    @Test
    public void timeInWords_bulk() {
        assertEquals("five o' clock", new Solution().timeInWords(5, 0));
        assertEquals("one minute past five", new Solution().timeInWords(5, 1));
        assertEquals("ten minutes past five", new Solution().timeInWords(5, 10));
        assertEquals("half past five", new Solution().timeInWords(5, 30));
        assertEquals("twenty minutes to six", new Solution().timeInWords(5, 40));
        assertEquals("quarter to six", new Solution().timeInWords(5, 45));
        assertEquals("thirteen minutes to six", new Solution().timeInWords(5, 47));
        assertEquals("twenty eight minutes past five", new Solution().timeInWords(5, 28));
    }

}
