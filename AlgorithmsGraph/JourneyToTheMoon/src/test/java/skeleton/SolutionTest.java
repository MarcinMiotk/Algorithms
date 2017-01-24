package skeleton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
    public void test_first() {
        String input = "4 2\n"
                + "0 1\n"
                + "2 3";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("4", outContent.toString().trim());
    }

    @Test
    public void test_second() {

        InputStream fromFile = SolutionTest.class.getResourceAsStream("/case_2_input");
        System.setIn(fromFile);

        Solution.main(null);
        assertEquals("43723", outContent.toString().trim());
    }

    @Test
    public void test_third() {

        String input = "100000 2\n"
                + "1 2\n"
                + "3 4";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("4999949998", outContent.toString().trim());
    }

}
