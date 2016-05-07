package com.snmill.cp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

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
    public void official() {
        String input = "3\n"
                + "3\n"
                + "3 1 2\n"
                + "4\n"
                + "1 3 4 2\n"
                + "5\n"
                + "1 2 3 5 4";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("YES\r\n"
                + "YES\r\n"
                + "NO", outContent.toString().trim());
    }

    @Test
    public void official_2() {
        String input = "5\n"
                + "12\n"
                + "9 6 8 12 3 7 1 11 10 2 5 4\n"
                + "21\n"
                + "17 21 2 1 16 9 12 11 6 18 20 7 14 8 19 10 3 4 13 5 15\n"
                + "15\n"
                + "5 8 13 3 10 4 12 1 2 7 14 6 15 11 9\n"
                + "13\n"
                + "8 10 6 11 7 1 9 12 3 5 13 4 2\n"
                + "18\n"
                + "7 9 15 8 10 16 6 14 5 13 17 12 3 11 4 1 18 2";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("NO\r\n"
                + "YES\r\n"
                + "NO\r\n"
                + "YES\r\n"
                + "NO", outContent.toString().trim());
    }

    @Test
    public void doesTheRobotCanFullySortA() {

        LinkedList<Integer> chain = new LinkedList<>();
        chain.add(1);
        chain.add(2);
        chain.add(3);
        chain.add(5);
        chain.add(4);

        assertFalse("Should be FALSE", Solution.doesTheRobotCanFullySortA(chain));
    }

//    @Test
//    public void doesTheRobotCanFullySortA_2() {
//        assertTrue("Should be TRUE", Solution.doesTheRobotCanFullySortA(new int[]{17, 21, 2, 1, 16, 9, 12, 11, 6, 18, 20, 7, 14, 8, 19, 10, 3, 4, 13, 5, 15}));
//    }
//
//    @Test
//    public void doesTheRobotCanFullySortA_3() {
//        assertFalse("Should be FALSE", Solution.doesTheRobotCanFullySortA(new int[]{9, 6, 8, 12, 3, 7, 1, 11, 10, 2, 5, 4}));
//    }
}
