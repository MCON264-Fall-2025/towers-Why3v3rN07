package exercises;

/**
 * Recursively insert a new value at the END of a singly linked list.
 *
 * RECURSION DESIGN:
 * - Base cases:
 *     1) head == null  -> the list is empty; create and return a new single-node list.
 *     2) head.next == null -> we're at the last node; attach new node and return head.
 * - Recursive case:
 *     * Set head.next = insertAtEnd(head.next, value), then return head.
 *
 * NOTE:
 * - Return the (possibly new) head to make chaining easy.
 * - This mirrors many recursive list patterns you’ll use later (size, contains, printReverse).
 */
public class LinkedListInsertEnd {

    public static class Node<T> {
        public T data;
        public Node<T> next;
        public Node(T data) { this.data = data; }
    }

    public static <T> Node<T> insertAtEnd(Node<T> head, T value) {
        // TODO: implement recursively
        // Base 1: if (head == null) return new Node<>(value);
        // Base 2: if (head.next == null) { head.next = new Node<>(value); return head; }
        // Recursive: head.next = insertAtEnd(head.next, value); return head;
        return head; // TEMP: replace with your recursive solution
    }
}
