package exercises;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Exercise 21 — Towers of Hanoi (counting moves)")
class TowersExercise21Test {

    /** If you add TowersExercise21.reset() / getCount(), replace reflection helpers with direct calls. */
    private void resetCount() {
        try {
            Field f = TowersExercise21.class.getDeclaredField("count");
            f.setAccessible(true);
            f.setInt(null, 0);
        } catch (ReflectiveOperationException e) {
            Assertions.fail("Unable to reset TowersExercise21.count via reflection. Consider adding a public reset().");
        }
    }

    private int readCount() {
        try {
            Field f = TowersExercise21.class.getDeclaredField("count");
            f.setAccessible(true);
            return f.getInt(null);
        } catch (ReflectiveOperationException e) {
            Assertions.fail("Unable to read TowersExercise21.count via reflection. Consider adding getCount().");
            return -1;
        }
    }

    private int pow2Minus1(int n) {
        // (2^n) - 1 using BigInteger for safety, then intValueExact for small n
        return BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE).intValueExact();
    }

    @ParameterizedTest(name = "n={0} → moves should be 2^n - 1")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 10, 15})
    void countsFollow2PowNMinus1(int n) {
        resetCount();
        TowersExercise21.solve(n, 'A', 'B', 'C');
        int count = readCount();
        Assertions.assertEquals(pow2Minus1(n), count, "TowersExercise21: move count mismatch for n=" + n);
    }

    @Test
    @DisplayName("n=0 → zero moves")
    void zeroDisks() {
        resetCount();
        TowersExercise21.solve(0, 'A', 'B', 'C');
        Assertions.assertEquals(0, readCount());
    }

    @Test
    @DisplayName("n=3 → 7 moves")
    void threeDisks() {
        resetCount();
        TowersExercise21.solve(3, 'A', 'B', 'C');
        Assertions.assertEquals(7, readCount());
    }
}

