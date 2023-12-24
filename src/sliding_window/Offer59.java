package sliding_window;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Offer59 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        Deque<int[]> dq = new LinkedList<>();
        int[] res = new int[n - k + 1];
        for (int i = 0; i < k - 1; i++) {
            while (!dq.isEmpty() && dq.peekLast()[1] < nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(new int[]{i, nums[i]});
        }
        for (int i = k - 1; i < n; i++) {
            if (!dq.isEmpty() && dq.peekFirst()[0] < i - k + 1) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && dq.peekLast()[1] < nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(new int[]{i, nums[i]});
            res[i - k + 1] = dq.peekFirst()[1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 2, 0, 5};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
}