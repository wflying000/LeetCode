import java.util.NoSuchElementException;

// LeetCode 707

public class IntLinkedList {
    class Node {
        int val;
        Node next;
        Node prev;
        public Node() {}
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    int size;
    Node first;
    Node last;

    public IntLinkedList() {
        size = 0;
        first = new Node();
        last = new Node();
        first.next = last;
        last.prev = first;
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException();
        }
        Node node = getNode(index);
        return node.val;
    }

    public void add(int val) {
        addAtTail(val);
    }

    public void addFirst(int val) {
        addAtHead(val);
    }

    public void addLast(int val) {
        addAtTail(val);
    }

    public void removeFirst() {
        deleteAtIndex(0);
    }

    public void removeLast() {
        deleteAtIndex(size - 1);
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
        return;
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
        return;
    }
    
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        } 
        index = index > 0 ? index : 0;
        Node prev = null;
        if (index == 0) {
            prev = first;
        } else {
            prev = getNode(index - 1);
        }
        Node node = new Node(val);
        Node next = prev.next;
        prev.next = node;
        node.prev = prev;
        node.next = next;
        next.prev = node;
        size++;
        return;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node node = getNode(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
        return;
    }

    private Node getNode(int index) {
        if (index < size - index) {
            Node node = first.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node node = last.prev;
            for (int i = 0; i < size - 1 - index; i++) {
                node = node.prev;
            }
            return node;
        }
    }

    public static void main(String[] args) {
        IntLinkedList list = new IntLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.removeFirst();
        System.out.println(list.get(0));
    }
    
}
