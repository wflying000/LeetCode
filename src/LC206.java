public class LC206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListNode.buildList(nums);
        LC206 sln = new LC206();
        ListNode res = sln.reverseList(head);
        ListNode.print(res);

        res = sln.reverseList2(res);
        ListNode.print(res);
    }
}
