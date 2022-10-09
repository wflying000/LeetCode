import java.util.ArrayDeque;
import java.util.Deque;

public class LC856 {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(0);
            } else {
                int left = stack.pop();
                int cur = stack.pop() + Math.max(2 * left, 1);
                stack.push(cur);
            }
        }
        return stack.peek();
    }
}
