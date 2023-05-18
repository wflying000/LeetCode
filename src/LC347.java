import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

public class LC347 {
    public int[] topKFrequent2(int[] nums, int k) {
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

    private Random rand = new Random();
    private int[] res;
    private int index;

    public int[] topKFrequent(int[] nums, int k) {
        res = new int[k];
        index = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int[][] count = new int[map.size()][2];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int cnt = entry.getValue();
            count[idx][0] = num;
            count[idx][1] = cnt;
            idx++;
        }
        quickSelect(count, 0, count.length - 1, k);
        return res;
    }

    private void quickSelect(int[][] count, int left, int right, int k) {
        if (left > right) {
            return;
        }
        int pos = partition(count, left, right);
        if (k <= pos - left) {
            quickSelect(count, left, pos - 1, k);
        } else {
            for (int i = left; i <= pos; i++) {
                res[index++] = count[i][0];
            }
            if (k > (pos - left + 1)) {
                quickSelect(count, pos + 1, right, k - (pos - left + 1));
            }
        }
    }

    private int partition(int[][] count, int left, int right) {
        int idx = rand.nextInt(right - left + 1) + left;
        swap(count, left, idx);
        int[] x = count[left];
        while (left < right) {
            while (left < right && count[right][1] < x[1]) {
                right--;
            }
            count[left] = count[right];
            while (left < right && count[left][1] >= x[1]) {
                left++;
            }
            count[right] = count[left];
        }
        count[left] = x;
        return left;
    }

    private void swap(int[][] nums, int i, int j) {
        int[] tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        LC347 sln = new LC347();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] res = sln.topKFrequent(nums, k);
        System.out.println(Arrays.toString(res));
    }
}