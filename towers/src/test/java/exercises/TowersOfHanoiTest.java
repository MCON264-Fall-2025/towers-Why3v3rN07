package exercises;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;

@DisplayName("TowersOfHanoi (recursive) — tests")
class TowersOfHanoiTest {

    @Test
    @DisplayName("n=0 -> no moves")
    void zeroDisks() {
        List<String> moves = new ArrayList<>();
        TowersOfHanoi.solve(0, 'A', 'B', 'C', moves);
        Assertions.assertTrue(moves.isEmpty());
    }

    @Test
    @DisplayName("n=1 -> one move A -> C")
    void oneDisk() {
        List<String> moves = new ArrayList<>();
        TowersOfHanoi.solve(1, 'A', 'B', 'C', moves);
        Assertions.assertEquals(List.of("A -> C"), moves);
    }

    @Test
    @DisplayName("n=3 -> 7 moves in canonical order")
    void threeDisks() {
        List<String> moves = new ArrayList<>();
        TowersOfHanoi.solve(3, 'A', 'B', 'C', moves);

        Assertions.assertEquals(7, moves.size(), "Should be 2^3 - 1 moves");
        List<String> expected = List.of(
                "A -> C",
                "A -> B",
                "C -> B",
                "A -> C",
                "B -> A",
                "B -> C",
                "A -> C"
        );
        Assertions.assertEquals(expected, moves);
    }

 }
