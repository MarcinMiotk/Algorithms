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
public class SolutionSystemIoTest {

    public SolutionSystemIoTest() {
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
    public void official() {
        String input = "5\n"
                + "ab\n"
                + "bb\n"
                + "hefg\n"
                + "dhck\n"
                + "dkhc";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals(""
                + "ba\r\n"
                + "no answer\r\n"
                + "hegf\r\n"
                + "dhkc\r\n"
                + "hcdk", outContent.toString().trim());
    }

}
