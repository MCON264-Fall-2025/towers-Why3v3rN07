package exercises;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("LinkedListInsertEnd (recursive) — tests")
class LinkedListInsertEndTest {

    private <T> LinkedListInsertEnd.Node<T> listOf(T... vals) {
        LinkedListInsertEnd.Node<T> head = null, tail = null;
        for (T v : vals) {
            LinkedListInsertEnd.Node<T> n = new LinkedListInsertEnd.Node<>(v);
            if (head == null) { head = tail = n; } else { tail.next = n; tail = n; }
        }
        return head;
    }

    private <T> List<T> toList(LinkedListInsertEnd.Node<T> head) {
        List<T> out = new ArrayList<>();
        for (LinkedListInsertEnd.Node<T> p = head; p != null; p = p.next) out.add(p.data);
        return out;
    }

    @Test
    @DisplayName("Insert into EMPTY list returns new single-node list")
    void insertIntoEmpty() {
        LinkedListInsertEnd.Node<Integer> head = null;
        head = LinkedListInsertEnd.insertAtEnd(head, 42);
        assertNotNull(head);
        assertEquals(List.of(42), toList(head));
        assertNull(head.next);
    }

    @Test
    @DisplayName("Insert into NON-EMPTY list appends at tail and preserves head")
    void insertIntoNonEmpty() {
        var head = listOf(1, 2, 3);
        var originalHead = head;
        head = LinkedListInsertEnd.insertAtEnd(head, 99);

        assertSame(originalHead, head, "Head reference should be preserved");
        assertEquals(List.of(1, 2, 3, 99), toList(head));
    }

    @Test
    @DisplayName("Multiple inserts append in order")
    void multipleAppends() {
        var head = listOf("a", "b");
        head = LinkedListInsertEnd.insertAtEnd(head, "c");
        head = LinkedListInsertEnd.insertAtEnd(head, "d");
        head = LinkedListInsertEnd.insertAtEnd(head, "e");
        assertEquals(List.of("a", "b", "c", "d", "e"), toList(head));
    }

}
