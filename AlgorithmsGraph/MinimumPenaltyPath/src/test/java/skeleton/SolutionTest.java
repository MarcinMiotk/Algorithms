package skeleton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
    public void test_first() {
        String input = "3 4\n" +
                "1 2 1\n" +
                "1 2 1000\n" +
                "2 3 3\n" +
                "1 3 100\n" +
                "1 3";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("3", outContent.toString().trim());
    }

    @Test
    public void test_second() {
        String input = "9 9\n" +
                "9 8 4\n" +
                "8 2 2\n" +
                "2 1 1\n" +
                "1 3 5\n" +
                "3 4 3\n" +
                "4 5 1\n" +
                "4 6 1\n" +
                "6 7 1\n" +
                "5 7 1\n" +
                "4 8";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("7", outContent.toString().trim());
    }

    @Test
    public void testcase_01() {
        InputStream fromFile = SolutionTest.class.getResourceAsStream("/testcases/testcase_01_input");
        System.setIn(fromFile);

        Solution.main(null);
        assertEquals("7", outContent.toString().trim());
    }


    @Test
    public void testcase_02() {
        InputStream fromFile = SolutionTest.class.getResourceAsStream("/testcases/testcase_02_input");
        System.setIn(fromFile);

        Solution.main(null);
        assertEquals("95", outContent.toString().trim());
    }


    @Test
    public void testcase_03() {
        InputStream fromFile = SolutionTest.class.getResourceAsStream("/testcases/testcase_03_input");
        System.setIn(fromFile);

        Solution.main(null);
        assertEquals("63", outContent.toString().trim());
    }

    @Test
    public void testcase_04() {
        InputStream fromFile = SolutionTest.class.getResourceAsStream("/testcases/testcase_04_input");
        System.setIn(fromFile);

        Solution.main(null);
        assertEquals("379", outContent.toString().trim());
    }

    @Test
    public void testcase_05() {
        InputStream fromFile = SolutionTest.class.getResourceAsStream("/testcases/testcase_05_input");
        System.setIn(fromFile);

        Solution.main(null);
        assertEquals("183", outContent.toString().trim());
    }

    @Test
    public void testcase_08() {
        InputStream fromFile = SolutionTest.class.getResourceAsStream("/testcases/testcase_08_input");
        System.setIn(fromFile);

        Solution.main(null);
        assertEquals("111", outContent.toString().trim());
    }

    @Test
    public void testcase_10() {
        InputStream fromFile = SolutionTest.class.getResourceAsStream("/testcases/testcase_10_input");
        System.setIn(fromFile);

        Solution.main(null);
        assertEquals("23", outContent.toString().trim());
    }

}
