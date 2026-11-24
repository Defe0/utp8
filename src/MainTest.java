import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MainTest {

    @Test
    public void simpleTest() {
        int[] first = Main.generateTestArray();
        int[] second = Main.generateTestArray();
        assertArrayEquals(first, second);
    }

    @RepeatedTest(10)
    public void simpleTestR() {
        simpleTest();
    }

    @Test
    public void manualPerfTest() {
        int[] array = Main.generateTestArray();

        long start = System.nanoTime();
        Main.bogoSort(array);
        long elapsed = System.nanoTime() - start;

        System.out.println("BogoSort took " + elapsed + " ns");
    }

    @RepeatedTest(10)
    @Tag("performance")
    public void autoPerfTest() {
        simpleTest();
    }

    @Test
    @Timeout(1)
    public void finalTest() {
        int[] array = {3, 1, 2};
        Main.bogoSort(array);
        assertArrayEquals(new int[]{1, 2, 3}, array);
    }
}
