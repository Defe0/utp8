public class Polynomial {

    private final int[] coefficients;

    public Polynomial(int[] coefficients) {
        this.coefficients = coefficients;
    }

    public int[] getCoefficients() {
        return coefficients;
    }

    public Polynomial add(Polynomial other) {
        int[] result = new int[Math.max(coefficients.length, other.coefficients.length)];

        for (int i = 0; i < coefficients.length; i++) {
            result[i] = coefficients[i];
        }

        for (int i = 0; i < other.coefficients.length; i++) {
            result[i] += other.coefficients[i];
        }

        return new Polynomial(result);
    }

    public Polynomial multiply(Polynomial other) {
        int[] result = new int[coefficients.length + other.coefficients.length - 1];

        for (int i = 0; i < coefficients.length; i++) {
            for (int j = 0; j < other.coefficients.length; j++) {
                result[i + j] += coefficients[i] * other.coefficients[j];
            }
        }

        return new Polynomial(result);
    }

    public double evaluate(double x) {
        double result = coefficients[coefficients.length - 1];

        for (int i = coefficients.length - 2; i >= 0; i--) {
            result = result * x + coefficients[i];
        }

        return result;
    }

    public Polynomial derivative() {
        int[] result = new int[Math.max(1, coefficients.length - 1)];

        for (int i = 1; i < coefficients.length; i++) {
            result[i - 1] = i * coefficients[i];
        }

        return new Polynomial(result);
    }
}
