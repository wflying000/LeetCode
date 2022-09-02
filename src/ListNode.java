
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { 
        this.val = val; 
    }
    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }

    public static ListNode buildList(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode pre = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode cur = new ListNode(nums[i]);
            pre.next = cur;
            pre = cur;
        }
        return head;
    }

    public static void print(ListNode head) {
        if (head == null) {
            System.out.println("null");
        }
        StringBuilder strs = new StringBuilder();
        strs.append("[");
        strs.append(head.val + "");
        ListNode cur = head.next;
        while (cur != null) {
            strs.append(", " + cur.val);
            cur = cur.next;
        }
        strs.append("]");
        System.out.println(strs);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListNode.buildList(nums);
        ListNode.print(head);
    }
}
