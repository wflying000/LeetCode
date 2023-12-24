

public class LC708 {
    public class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        Node cur = head.next;
        Node max = head;
        while (cur != head) {
            if (cur.val > cur.next.val) {
                max = cur;
                break;
            }
            cur = cur.next;
        }
        
        
        Node min = max.next;
        max.next = null;
        if (insertVal <= min.val || insertVal >= max.val) {
            Node node = new Node(insertVal);
            node.next = min;
            max.next = node;
            return head;
        }
        cur = min;
        while (cur != null && cur.next != null) {
            if (insertVal >= cur.val && insertVal <= cur.next.val) {
                Node next = cur.next;
                cur.next = new Node(insertVal);
                cur.next.next = next;
                max.next = min;
                break;
            }
            cur = cur.next;
        }
        return head;

    }
}
