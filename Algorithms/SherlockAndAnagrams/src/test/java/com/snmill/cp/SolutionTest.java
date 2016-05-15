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
                + "2\n"
                + "abba\n"
                + "abcd";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("4\r\n"
                + "0", outContent.toString().trim());
    }

    @Test
    public void official_2() {
        String input = ""
                + "5\n"
                + "ifailuhkqq\n"
                + "hucpoltgty\n"
                + "ovarjsnrbf\n"
                + "pvmupwjjjf\n"
                + "iwwhrlkpek";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("3\r\n"
                + "2\r\n"
                + "2\r\n"
                + "6\r\n"
                + "3", outContent.toString().trim());
    }

}
