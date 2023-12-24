import common.ListNode;

public class LC25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode cur = head;
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        while (cur != null) {
            int count = 1;
            ListNode first = cur;
            ListNode last = cur;
            while (last != null) {
                last = last.next;
                count++;
                if (count == k){
                    break;
                }
            }
            if (last != null) {
                ListNode next = last.next;
                last.next = null;
                ListNode h = reverse(first);
                pre.next = h;
                pre = first;
                cur = next;
            } else {
                pre.next = first;
                break;
            }
        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode head) {
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
        int k = 2;
        ListNode res = reverseKGroup(head, k);
        ListNode.print(res);
    }
}
