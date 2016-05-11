package com.snmill.cp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
                + "3\n"
                + "aaab\n"
                + "baa\n"
                + "aaa";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("3\r\n"
                + "0\r\n"
                + "-1", outContent.toString().trim());
    }
}
