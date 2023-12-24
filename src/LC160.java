import common.ListNode;


public class LC160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int m = 0;
        ListNode pa = headA;
        while (pa != null) {
            pa = pa.next;
            m++;
        }
        int n = 0;
        ListNode pb = headB;
        while (pb != null) {
            pb = pb.next;
            n++;
        }
        if (m >= n) {
            pa = headA;
            pb = headB;
        } else {
            pa = headB;
            pb = headA;
        }
        int diff = Math.abs(m - n);
        for (int i = 0; i < diff; i++) {
            pa = pa.next;
        }
        while (pa != null && pa != pb) {
            pa = pa.next;
            pb = pb.next;
        } 
        if (pa != null && pa == pb) {
            return pa;
        }
        return null;

    }
}
