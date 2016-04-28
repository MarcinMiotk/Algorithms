
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static junit.framework.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mmiotk on 2016-04-28.
 */
public class SolutionTest {

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
                + "5 3\n"
                + "4 2 6 1 10 ";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("4", outContent.toString().trim());
    }

    @Test
    public void official_2() {
        String input = ""
                + "10 5\n"
                + "3 8 15 11 14 1 9 2 24 31";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("8", outContent.toString().trim());
    }
}
