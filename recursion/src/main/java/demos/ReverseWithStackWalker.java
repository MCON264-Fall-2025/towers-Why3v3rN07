package demos;

import java.lang.StackWalker;

public class ReverseWithStackWalker {
    private static final StackWalker WALKER = StackWalker.getInstance();

    private static int currentDepth() {
        // counts *all* frames.Note: This includes the main method and any JVM-internal frames.
        int frames = WALKER.walk(s -> (int) s.count());
        System.out.println("Current stack frames:");
        WALKER.forEach(frame -> System.out.println("  " + frame));
        System.out.println("Total frames: " + frames);
        return frames;
    }

    public static void printReverse(Node node) {
        int depth = currentDepth();
        System.out.printf("%s→ call depth=%d, node=%s%n", "  ".repeat(depth), depth,
                (node == null ? "null" : String.valueOf(node.data)));

        if (node == null) {
            System.out.printf("%s← return depth=%d (base case)%n", "  ".repeat(depth), depth);
            return;
        }
        printReverse(node.next);

        depth = currentDepth(); // re-check on unwind (depth shrinks)
        System.out.printf("%sprint %d at depth=%d%n", "  ".repeat(depth), node.data, depth);
        System.out.print(node.data + " ");
    }
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);

        printReverse(head);
    }
}
