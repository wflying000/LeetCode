public class LC19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode first = dummy;
        for (int i = 0; i < n + 1; i++) {
            first = first.next;
        }
        ListNode second = dummy;
        while (first != null) {
            second = second.next;
            first = first.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
