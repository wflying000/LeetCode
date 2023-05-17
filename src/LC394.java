import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class LC394 {
    public static String decodeString(String s) {
        Deque<String> str_stack = new ArrayDeque<>();
        Deque<Integer> num_stack = new ArrayDeque<>();
        int i = 0;
        int n = s.length(); 
        while (i < n) {
            StringBuilder sb = new StringBuilder();
            while (i < n && s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                sb.append(s.charAt(i));
                i++;
            }
            if (sb.length() > 0) {
                str_stack.push(sb.toString());
            }
            int num = 0;
            while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num * 10 + (s.charAt(i) - '0');
                i++;
            }
            if (num > 0) {
                num_stack.push(num);
            }
            if (i < n) {
                char ch = s.charAt(i);
                if (ch == '[') {
                    str_stack.push("[");
                } else if (ch == ']') {
                    List<String> list = new ArrayList<>();
                    while (!str_stack.peek().equals("[")) {
                        list.add(str_stack.pop());
                    }
                    str_stack.pop();
                    Collections.reverse(list);
                    StringBuilder tmp = new StringBuilder();
                    for (int j = 0; j < list.size(); j++) {
                        tmp.append(list.get(j));
                    }
                    String str = tmp.toString();
                    int count = num_stack.pop();
                    tmp.setLength(0);
                    for (int j = 0; j < count; j++) {
                        tmp.append(str);
                    } 
                    str_stack.push(tmp.toString());
                }
                i++;
            }
        }
        while (!num_stack.isEmpty()) {
            List<String> list = new ArrayList<>();
            while (!str_stack.peek().equals("[")) {
                list.add(str_stack.pop());
            }
            str_stack.pop();
            Collections.reverse(list);
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < list.size(); j++) {
                tmp.append(list.get(j));
            }
            String str = tmp.toString();
            int count = num_stack.pop();
            tmp.setLength(0);
            for (int j = 0; j < count; j++) {
                tmp.append(str);
            } 
            str_stack.push(tmp.toString());
        }
        List<String> list = new ArrayList<>();
        while (!str_stack.isEmpty()) {
            list.add(str_stack.pop());
        }
        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        String res = decodeString(s);
        System.out.println(res);
    }
}
