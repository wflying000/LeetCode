import java.util.ArrayDeque;
import java.util.Deque;

public class LC1475 {
    public int[] finalPrices(int[] prices) {
        if (prices == null) {
            return new int[0];
        }
        int n = prices.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && res[stack.peek()] >= prices[i]) {
                int idx = stack.pop();
                res[idx] -= prices[i];
            }
            res[i] = prices[i];
            stack.push(i);
        }
        return res;
    }

    public int[] finalPrices2(int[] prices) {
        if (prices == null) {
            return new int[0];
        }
        int n = prices.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
            stack.push(prices[i]);
        }
        return res;
    } 

    public int[] finalPrices3(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = prices[i];
            for (int j = i + 1; j < n; j++) {
                if (res[i] >= prices[j]) {
                    res[i] -= prices[j];
                    break;
                }
            }
        }
        return res;
    }
}
