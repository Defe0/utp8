import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public
    class PolynomialTest {

    @Test
    public void testAddition() {
        Polynomial p1 = new Polynomial(new int[]{1, 2, 3});
        Polynomial p2 = new Polynomial(new int[]{4, 0, -3});

        Polynomial result = p1.add(p2);
        int[] expected = {5, 2, 0};

        assertArrayEquals(expected, result.getCoefficients());
    }

    @Test
    public void testMultiplication() {
        Polynomial p1 = new Polynomial(new int[]{1, 2});
        Polynomial p2 = new Polynomial(new int[]{2, 1});

        Polynomial result = p1.multiply(p2);
        int[] expected = {2, 5, 2};

        assertArrayEquals(expected, result.getCoefficients());
    }

    @Test
    public void testEvaluate() {
        Polynomial p = new Polynomial(new int[]{3, 0, 2});
        double result = p.evaluate(2);
        assertEquals(11, result);
    }

    @Test
    public void testDerivative() {
        Polynomial p = new Polynomial(new int[]{3, 0, 2});

        Polynomial result = p.derivative();
        int[] expected = {0, 4};

        assertArrayEquals(expected, result.getCoefficients());
    }

}