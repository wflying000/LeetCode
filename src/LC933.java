import java.util.LinkedList;
import java.util.Queue;

public class LC933 {
    Queue<Integer> queue;
    public LC933() {
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        queue.offer(t);
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}
