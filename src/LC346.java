import java.util.LinkedList;
import java.util.Queue;

public class LC346 {
    int capacity;
    Queue<Integer> queue;
    int sum;
    /** Initialize your data structure here. */
    public LC346(int size) {
        capacity = size;
        queue = new LinkedList<>();
        sum = 0;
    }
    
    public double next(int val) {
        if (queue.size() == capacity) {
            sum -= queue.poll();
        }
        queue.offer(val);
        sum += val;
        return (double)sum / queue.size();
    }
}
