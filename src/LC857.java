import java.util.Arrays;
import java.util.PriorityQueue;

public class LC857 {
    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> {return quality[b] * wage[a] - quality[a] * wage[b];});
        int totalq = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k - 1; i++) {
            totalq += quality[index[i]];
            pq.offer(quality[index[i]]);
        }
        double res = Double.MAX_VALUE;
        for (int i = k - 1; i < n; i++) {
            totalq += quality[index[i]];
            pq.offer(quality[index[i]]);
            double totalc = totalq * ((double)wage[index[i]] / quality[index[i]]);
            res = Math.min(res, totalc);
            totalq -= pq.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] quality = {10, 20, 5};
        int[] wage = {70, 50, 30};
        int k = 2;
        double res = mincostToHireWorkers(quality, wage, k);
        System.out.println(res);
    }

}

