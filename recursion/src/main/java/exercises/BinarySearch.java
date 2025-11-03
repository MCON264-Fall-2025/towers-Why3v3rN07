package exercises;

/**
 * Binary Search (Recursive) on a sorted array.
 *
 * ALGORITHM (explain to students):
 * - Precondition: the array is sorted in non-decreasing order.
 * - Idea: Compare target with the middle element:
 *     * If target == midVal -> found (return index).
 *     * If target < midVal  -> search left half.
 *     * If target > midVal  -> search right half.
 * - Each step halves the search range (log2(n) steps).
 *
 * RECURSION DESIGN:
 * - Base cases:
 *     1) If lo > hi -> not found (return -1).
 *     2) If a[mid] == target -> return mid.
 * - Recursive cases:
 *     * target < a[mid]  -> search(lo, mid - 1)
 *     * target > a[mid]  -> search(mid + 1, hi)
 *
 * COMPLEXITY:
 * - Time: O(log n)
 * - Space: O(log n) due to recursion depth (or O(1) if you write it iteratively)
 */
public class BinarySearch {

    /**
     * Public entry point. Students: validate input if desired (null/empty).
     */
    public static int binarySearch(int[] a, int target) {
        if (a == null || a.length == 0) return -1;
        return search(a, target, 0, a.length - 1);
    }

    // TODO: Implement recursively. DO NOT convert to a loop.
    private static int search(int[] a, int target, int lo, int hi) {
        // Base case 1: empty range
        // Base case 2: found at mid
        // Recursive case: pick left or right half
        // Hints:
        //   int mid = lo + (hi - lo) / 2;
        //   if (target < a[mid]) return search(a, target, lo, mid - 1);
        //   else if (target > a[mid]) return search(a, target, mid + 1, hi);
        //   else return mid;
        return -2; // TEMP: replace with your recursive solution
    }
}
