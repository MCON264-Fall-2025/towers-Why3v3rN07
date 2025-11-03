package exercises;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BinarySearch (recursive) — tests")
class BinarySearchTest {

    static Stream<org.junit.jupiter.params.provider.Arguments> arraysAndTargets() {
        return Stream.of(
                // found cases
                org.junit.jupiter.params.provider.Arguments.of(new int[]{}, 42, -1),
                org.junit.jupiter.params.provider.Arguments.of(new int[]{1}, 1, 0),
                org.junit.jupiter.params.provider.Arguments.of(new int[]{1, 3, 5, 7, 9}, 1, 0),
                org.junit.jupiter.params.provider.Arguments.of(new int[]{1, 3, 5, 7, 9}, 9, 4),
                org.junit.jupiter.params.provider.Arguments.of(new int[]{1, 3, 5, 7, 9}, 5, 2),
                // duplicates — any valid index is acceptable; we assert membership
                org.junit.jupiter.params.provider.Arguments.of(new int[]{2, 2, 2, 2}, 2, -2),
                // not found
                org.junit.jupiter.params.provider.Arguments.of(new int[]{1, 3, 5, 7, 9}, 6, -1),
                org.junit.jupiter.params.provider.Arguments.of(new int[]{-10, -3, 0, 4, 11}, -5, -1)
        );
    }

    @ParameterizedTest(name = "search {1} in array -> expect {2}")
    @MethodSource("arraysAndTargets")
    void testBinarySearch(int[] a, int target, int expected) {
        int idx = BinarySearch.binarySearch(a, target);

        if (expected >= 0) {
            assertEquals(expected, idx, "Should return exact index for unique items");
        } else if (expected == -2) {
            // duplicates case: index must point to a target occurrence
            assertTrue(idx >= 0 && idx < a.length && a[idx] == target,
                    "Index must point to an occurrence when array has duplicates");
        } else {
            assertEquals(-1, idx, "Not found should return -1");
        }
    }

    @Test
    @DisplayName("Null or empty array returns -1")
    void nullOrEmpty() {
        assertEquals(-1, BinarySearch.binarySearch(null, 10));
        assertEquals(-1, BinarySearch.binarySearch(new int[]{}, 10));
    }
}
