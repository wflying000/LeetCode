class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val) {
        this.val = val;
    }
}

public class LC430 {
    public static Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        return process(head)[0];
    }

    private static Node[] process(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null && head.child == null) {
            return new Node[] {head, head};
        }
        Node[] node1 = null;
        Node[] node2 = null;
        Node next = head.next;
        if (head.child != null) {
            node1 = process(head.child);
            head.next = node1[0];
            node1[0].prev = head;
            node1[1].next = next;
            if (next != null) {
                next.prev = node1[1];
            }
            head.child = null;
        }
        if (next != null) {
            node2 = process(next);
            return new Node[] {head, node2[1]};
        }
        
        return new Node[] {head, node1[1]};
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.child = new Node(3);
        head.next = new Node(2);
        head.next.prev = head;
        Node node = flatten(head);
        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }

    }
}
