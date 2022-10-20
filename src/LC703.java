import java.util.PriorityQueue;

public class LC703 {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
    int k;
    public LC703(int k, int[] nums) {
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            if (pq.size() < k) {
                pq.offer(nums[i]);
            } else {
                if (nums[i] > pq.peek()) {
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
        }
    }
    
    public int add(int val) {
        if (pq.size() < k) {
            pq.offer(val);
        } else {
            if (val > pq.peek()) {
                pq.poll();
                pq.offer(val);
            }
        }
        return pq.peek();
    }
}