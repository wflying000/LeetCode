import java.util.ArrayList;
import java.util.List;

public class LC93 {
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        String[] strs = new String[4];
        backtrack(s, 0, strs, 0, res);
        return res;
    }

    private static void backtrack(String s, int i, String[] strs, int size, List<String> res) {
        if (size == 4) {
            if (i >= s.length()) {
                res.add(String.join(".", strs));
            }
            return;
        }
        if (i >= s.length()) {
            return;
        }
        if (s.charAt(i) == '0') {
            strs[size] = "0";
            backtrack(s, i + 1, strs, size + 1, res);
        }
        int num = 0;
        for (int j = i; j < i + 3 && j < s.length(); j++) {
            num = num * 10 + (s.charAt(j) - '0');
            if (num > 0 && num <= 255) {
                strs[size] = s.substring(i, j + 1);
                backtrack(s, j + 1, strs, size + 1, res);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> res = restoreIpAddresses(s);
        System.out.println(res);
    }
}