import java.util.ArrayDeque;
import java.util.Deque;

public class LC150 {
    public static int evalRPN(String[] tokens) {
        Deque<Integer> numStack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            if (judgeOpt(str)) {
                char ch = str.charAt(0);
                int num2 = numStack.pop();
                int num1 = numStack.pop();
                if (ch == '+') {
                    num1 += num2;
                } else if (ch == '-') {
                    num1 -= num2;
                } else if (ch == '*') {
                    num1 *= num2;
                } else {
                    num1 /= num2;
                }
                numStack.push(num1);
            } else {
                numStack.push(Integer.parseInt(str));
            }
        }
        return numStack.peek();
    }

    private static boolean judgeOpt(String str) {
        if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int res = evalRPN(tokens);
        System.out.println(res);
    
    }
}
