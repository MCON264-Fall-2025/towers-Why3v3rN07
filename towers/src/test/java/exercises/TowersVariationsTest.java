package exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;



/**
 * Every single move must use the middle peg.
 * Known closed form for total moves: 3^n - 1 (for n >= 0).
 * (Checks align with the book’s examples: n=1 → 2, n=2 → 8, etc.)
 */
@DisplayName("Exercise 23 — Towers of Hanoi Variation (middle peg on every move)")
class TowersVariationTest {

    /** If you add TowersVariation.reset() / getCount(), replace reflection helpers with direct calls. */
    private void resetCount() {
        try {
            Field f = TowersVariations.class.getDeclaredField("count");
            f.setAccessible(true);
            f.setInt(null, 0);
        } catch (ReflectiveOperationException e) {
            Assertions.fail("Unable to reset TowersVariation.count via reflection. Consider adding a public reset().");
        }
    }

    private int readCount() {
        try {
            Field f = TowersVariations.class.getDeclaredField("count");
            f.setAccessible(true);
            return f.getInt(null);
        } catch (ReflectiveOperationException e) {
            Assertions.fail("Unable to read TowersVariation.count via reflection. Consider adding getCount().");
            return -1;
        }
    }

    private int pow3Minus1(int n) {
        // For n up to ~15, 3^n fits in int; this is fine for classroom tests.
        int p = 1;
        for (int i = 0; i < n; i++) p *= 3;
        return p - 1;
    }

    @ParameterizedTest(name = "n={0} → moves should be 3^n - 1")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 10})
    void countsFollow3PowNMinus1(int n) {
        resetCount();
        TowersVariations.solveVariation(n, 1, 2, 3);
        int count = readCount();
        Assertions.assertEquals(pow3Minus1(n), count, "TowersVariation: move count mismatch for n=" + n);
    }

    @Test
    @DisplayName("n=1 → 2 moves (1→2→3)")
    void oneDisk() {
        resetCount();
        TowersVariations.solveVariation(1, 1, 2, 3);
        Assertions.assertEquals(2, readCount());
    }

    @Test
    @DisplayName("n=2 → 8 moves (matches book’s example)")
    void twoDisks() {
        resetCount();
        TowersVariations.solveVariation(2, 1, 2, 3);
        Assertions.assertEquals(8, readCount());
    }
}

