class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class LC23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeLists(ListNode[] lists, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return lists[left];
        }
        int mid = (right - left) / 2 + left;
        ListNode head1 = mergeLists(lists, left, mid);
        ListNode head2 = mergeLists(lists, mid + 1, right);
        ListNode head = mergeTwo(head1, head2);
        return head;
    }

    public ListNode mergeTwo(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if (head1 != null) {
            cur.next = head1;
        } else {
            cur.next = head2;
        }

        return dummy.next;
    }
}