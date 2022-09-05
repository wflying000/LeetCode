public class LC234 {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode nhead = slow.next;
        slow.next = null;
        nhead = reverseList(nhead);
        ListNode l1 = head;
        ListNode l2 = nhead;
        boolean res = true;
        while (l2 != null) {
            if (l1.val != l2.val) {
                res = false;
                break;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        nhead = reverseList(nhead);
        slow.next = nhead;
        return res;
    }

    private ListNode reverseList(ListNode head) {
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
}
