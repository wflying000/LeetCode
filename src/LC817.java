import common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LC817 {
    public int numComponents(ListNode head, int[] nums) {
        int res = 0;
        boolean hasFirst = false;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        while (head != null) {
            if (set.contains(head.val)) {
                if (!hasFirst) {
                    res++;
                    hasFirst = true;
                }
            } else {
                hasFirst = false;
            }
            head = head.next;
        }
        return res;
    }
}