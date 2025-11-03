package demos;


public class ReverseWithDepthDemo {

    private static void printReverse(Node node, int depth) {
        // visualize the call stack growth
        System.out.printf("%s→ call depth=%d, node=%s%n", "  ".repeat(depth), depth,
                (node == null ? "null" : String.valueOf(node.data)));

        if (node == null) {
            System.out.printf("%s← return depth=%d (base case)%n", "  ".repeat(depth), depth);
            return;
        }
        printReverse(node.next, depth + 1);

        // visualize unwinding (work happens on the way back)
        System.out.printf("%sprint %d at depth=%d%n", "  ".repeat(depth), node.data, depth);
        // actual action:
        System.out.print(node.data + "\n");
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        printReverse(head, 0);
    }
}
