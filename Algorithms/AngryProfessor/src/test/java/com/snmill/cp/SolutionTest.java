package com.snmill.cp;

import com.snmill.cp.Solution.TestCase;
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
    public void official_TestCase_1() {
        String input = ""
                + "2\n"
                + "4 3\n"
                + "-1 -3 4 2\n"
                + "4 2\n"
                + "0 -1 2 1";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("YES\r\n"
                + "NO", outContent.toString().trim());
    }

    @Test
    public void official_TestCase_1_firstTC() {
        int cancellationThreshold = 3;
        int[] arrivalTimesOfStudents = new int[]{-1, -3, 4, 2};

        TestCase tc = new TestCase(cancellationThreshold, arrivalTimesOfStudents);
        Solution.Cancelled result = tc.isTheClassCancelled();
        assertEquals(Solution.Cancelled.YES, result);
    }

    @Test
    public void official_TestCase_1_secondTC() {
        int cancellationThreshold = 2;
        int[] arrivalTimesOfStudents = new int[]{0, -1, 2, 1};

        TestCase tc = new TestCase(cancellationThreshold, arrivalTimesOfStudents);
        Solution.Cancelled result = tc.isTheClassCancelled();
        assertEquals(Solution.Cancelled.NO, result);
    }

}
