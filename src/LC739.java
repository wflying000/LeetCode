// 请根据每日 气温 列表 temperatures ，重新生成一个列表，
// 要求其对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
// 如果气温在这之后都不会升高，请在该位置用 0 来代替。

// 使用单调栈求解，过程中保证从栈底到栈顶温度递减 (栈中实际存储索引)
// 从左到右依次遍历，如果当前温度temp[i]大于栈顶温度temp[top]，则位置top需要需要等待i - top天会
// 遇到更高温度，将top出栈，并更新top位置的结果，重复此过程直到栈为空或者temp[i]小于等于栈顶位置温度

import java.util.ArrayDeque;
import java.util.Deque;

public class LC739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }
        return res;
    }
}
