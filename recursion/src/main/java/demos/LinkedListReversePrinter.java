package demos;

public class LinkedListReversePrinter {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }
    // Recursive method to print list in reverse
    public static void printReverse(Node head) {
        if (head == null) {
            return;  // base case: end of list
        }
        printReverse(head.next);  // recursive case: go deeper
        System.out.print(head.data + " ");  // action after returning
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.println("List in reverse:");
        printReverse(head);
    }
}

