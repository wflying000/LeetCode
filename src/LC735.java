import java.util.ArrayDeque;
import java.util.Deque;

public class LC735 {
    // 通过栈模拟
    // 如果asteroids[i] > 0, 直接进栈
    // 如果asteroids[i] < 0, 并且栈顶元素大于0, 并且栈顶元素小于asteroids[i]的绝对值则栈顶元素出栈
    // 如果asteroids[i] < 0, 并且栈顶元素大于0, 并且栈顶元素小于asteroids[i]的绝对值, 则栈顶元素出栈, asteroids[i]爆炸
    // 如果asteroids[i] < 0, 并且栈顶元素大于0, 并且栈顶元素大于asteroids[i]的绝对值, 则asteroids[i]爆炸
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                boolean add = true;
                while (!stack.isEmpty() && stack.peek() > 0) {
                    if (stack.peek() < -asteroids[i]) {
                        stack.pop();
                    } else if (stack.peek() == -asteroids[i]) {
                        stack.pop();
                        add = false;
                        break;
                    } else {
                        add = false;
                        break;
                    }
                }
                if (add) {
                    stack.push(asteroids[i]);
                }
            }
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    
    }
}
