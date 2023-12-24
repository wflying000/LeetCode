import common.ListNode;

public class LC445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = reverseList(l1);
        ListNode h2 = reverseList(l2);
        ListNode pre = null;
        int a = 0;
        int b = 0;
        int c = 0;
        while (h1 != null || h2 != null || c != 0) {
            if (h1 != null) {
                a = h1.val;
                h1 = h1.next;
            } else {
                a = 0;
            }
            if (h2 != null) {
                b = h2.val;
                h2 = h2.next;
            } else {
                b = 0;
            }
            int sum = a + b + c;
            c = sum / 10;
            ListNode cur = new ListNode(sum % 10);
            cur.next = pre;
            pre = cur;
        }
        
        return pre;
    }

    private ListNode reverseList(ListNode head) {
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
        LC445 sln = new LC445();
        int[] nums1 = {7, 2, 4, 3};
        int[] nums2 = {5, 6, 4};
        ListNode l1 = ListNode.buildList(nums1);
        ListNode l2 = ListNode.buildList(nums2);
        ListNode.print(l1);
        ListNode.print(l2);
        ListNode res = sln.addTwoNumbers(l1, l2);
        ListNode.print(res);
    }
}
