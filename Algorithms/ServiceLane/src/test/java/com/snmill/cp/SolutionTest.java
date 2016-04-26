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
    public void official_largestVehicleWhichCanPassThroughTheServiceLane() {
        String input = ""
                + "8 5\n"
                + "2 3 1 2 3 2 3 3\n"
                + "0 3\n"
                + "4 6\n"
                + "6 7\n"
                + "3 5\n"
                + "0 7";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("1\r\n"
                + "2\r\n"
                + "3\r\n"
                + "2\r\n"
                + "1", outContent.toString().trim());
    }

}
