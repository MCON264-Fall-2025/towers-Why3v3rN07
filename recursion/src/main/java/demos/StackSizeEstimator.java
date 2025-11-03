package demos;

/**
 * Quick Rules of Thumb
 * JVM Flag	Description	Typical Default
 * -Xss	Per-thread stack size	~1 MB on 64-bit JVM
 * Each recursive call	Consumes ~100 bytes–1 KB	Depends on method locals
 * Stack overflow depth	5k–20k recursive calls	Varies by system
 */
public class StackSizeEstimator {
    static int depth = 0;
    static long start;

    static void recurse() {
        long current = Runtime.getRuntime().freeMemory();
        if (depth == 0) start = current;
        depth++;
        recurse();
    }

    public static void main(String[] args) {
        try {
            recurse();
        } catch (StackOverflowError e) {
            long usedPerFrame = (start - Runtime.getRuntime().freeMemory()) / depth;
            System.out.println("Max depth: " + depth);
            System.out.println("Approx. bytes per frame: " + usedPerFrame);
        }
    }
}

