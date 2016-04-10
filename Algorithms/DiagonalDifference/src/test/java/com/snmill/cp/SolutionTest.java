package com.snmill.cp;

import com.snmill.cp.Solution.DiagonalGetter;
import com.snmill.cp.Solution.DifferenceOfSums;
import com.snmill.cp.Solution.GetValue;
import com.snmill.cp.Solution.MatrixFactory;
import com.snmill.cp.Solution.MatrixFactoryImpl;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 *
 */
public class SolutionTest {

    public SolutionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
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
    public void testMain_31() {
        String input = "3\n"
                + "11 2 4\n"
                + "4 5 6\n"
                + "10 8 -12";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("15", outContent.toString().trim());
    }

    @Test
    public void matrixFactory_N_is_empty() {
        MatrixFactory factory = new Solution().new MatrixFactoryImpl();
        String input = "0\n";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        int result[] = factory.createMatrix(in);
        assertArrayEquals(new int[]{}, result);
    }

    @Test
    public void matrixFactory_N_is_1() {
        MatrixFactory factory = new Solution().new MatrixFactoryImpl();
        String input = "1\n"
                + "10";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        int result[] = factory.createMatrix(in);
        assertArrayEquals(new int[]{10}, result);
    }

    @Test
    public void matrixFactory_N_is_2() {
        MatrixFactory factory = new Solution().new MatrixFactoryImpl();
        String input = "2\n"
                + "10 11\n"
                + "12 13";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        int result[] = factory.createMatrix(in);
        assertArrayEquals(new int[]{10, 11, 12, 13}, result);
    }

    @Test
    public void matrixFactory_N_is_3() {
        MatrixFactory factory = new Solution().new MatrixFactoryImpl();
        String input = "3\n"
                + "11 2 4\n"
                + "4 5 6\n"
                + "10 8 -12";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        int result[] = factory.createMatrix(in);
        assertArrayEquals(new int[]{11, 2, 4, 4, 5, 6, 10, 8, -12}, result);
    }

    @Test
    public void matrixFactory_N_is_4() {
        MatrixFactory factory = new Solution().new MatrixFactoryImpl();
        String input = "4\n"
                + "1 2 3 4\n"
                + "5 6 7 8\n"
                + "9 10 11 12\n"
                + "13 14 15 16";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        int result[] = factory.createMatrix(in);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}, result);
    }

    @Test
    public void matrixXY_1_2() {
        GetValue instance = new Solution().new MatrixGetValue(new int[]{10, 11, 12, /*  */ 20, 21, 22, /*   */ 30, 31, 32}, 3);
        int result = instance.get(1, 2);
        assertEquals(22, result);
    }

    @Test
    public void matrixXY_2_2() {
        GetValue instance = new Solution().new MatrixGetValue(new int[]{10, 11, 12, /*  */ 20, 21, 22, /*   */ 30, 31, 32}, 3);
        int result = instance.get(2, 2);
        assertEquals(32, result);
    }

    @Test
    public void matrixXY_0_2() {
        GetValue instance = new Solution().new MatrixGetValue(new int[]{10, 11, 12, /*  */ 20, 21, 22, /*   */ 30, 31, 32}, 3);
        int result = instance.get(0, 2);
        assertEquals(12, result);
    }

    @Test
    public void diagonalPrimary_coordinatesGetting() {
        GetValue valueGetter = mock(GetValue.class);
        DiagonalGetter instance = new Solution().new DiagonalGetterImpl();
        Iterator<Integer> iterator = instance.iterator(valueGetter, Solution.DiagonalType.PRIMARY, 4);
        iterator.next();
        verify(valueGetter).get(0, 0);
        iterator.next();
        verify(valueGetter).get(1, 1);
        iterator.next();
        verify(valueGetter).get(2, 2);
        iterator.next();
        verify(valueGetter).get(3, 3);
    }

    @Test
    public void diagonalSecondary_coordinatesGetting() {
        GetValue valueGetter = mock(GetValue.class);
        DiagonalGetter instance = new Solution().new DiagonalGetterImpl();
        Iterator<Integer> iterator = instance.iterator(valueGetter, Solution.DiagonalType.SECONDARY, 4);
        iterator.next();
        verify(valueGetter).get(0, 3);
        iterator.next();
        verify(valueGetter).get(1, 2);
        iterator.next();
        verify(valueGetter).get(2, 1);
        iterator.next();
        verify(valueGetter).get(3, 0);
    }

    @Test
    public void differenceOfSums_n_is_3() {
        MatrixFactory factory = new Solution().new MatrixFactoryImpl();
        String input = "3\n"
                + "11 2 4\n"
                + "4 5 6\n"
                + "10 8 -12";
        int n = 3;

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        int[] matrix = factory.createMatrix(in);
        GetValue xyGetter = new Solution().new MatrixGetValue(matrix, n);

        DifferenceOfSums solution = new Solution().new DifferenceOfSumsImpl();
        int result = solution.difference(xyGetter, n);
        assertEquals(15, result);
    }
}
