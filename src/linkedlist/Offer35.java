public class Offer35 {
    class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        // 复制节点将每个原始节点的新节点放在原始节点后面, 构成 1 --> 1' --> 2 --> 2' 
        while (cur != null) {
            Node next = cur.next;
            Node newNode = new Node(cur.val);
            cur.next = newNode;
            newNode.next = next;
            cur = next;
        }
        
        // 为复制节点添加random连接
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            } 
            cur = cur.next.next;
        }

        // 解开原始链表与复制链表
        Node res = head.next;
        cur = head;
        while (cur != null) {
            Node newNode = cur.next;
            cur.next= newNode.next;
            if (cur.next != null) {
                newNode.next = cur.next.next;
            }
            cur = cur.next;
        }
        return res;

    }
}
