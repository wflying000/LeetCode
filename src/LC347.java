import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int[] pair = new int[] {entry.getKey(), entry.getValue()};
            if (pq.size() < k) {
                pq.offer(pair);
            } else {
                if (pair[1] > pq.peek()[1]) {
                    pq.poll();
                    pq.offer(pair);
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }
        return res;
    }
}