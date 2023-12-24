import common.ListNode;
public class LC143 {
    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode nhead = slow.next;
        slow.next = null;
        nhead = reverseList(nhead);
        while (nhead != null) {
            ListNode next1 = head.next;
            ListNode next2 = nhead.next;
            head.next = nhead;
            nhead.next = next1;
            head = next1;
            nhead = next2;
        }
        return;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ListNode head = ListNode.buildList(nums);
        ListNode.print(head);
        reorderList(head);
        ListNode.print(head);
    }
}
