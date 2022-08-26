import java.util.HashMap;
import java.util.Map;

public class LC76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int start = -1;
        int end = s.length();
        int match = t.length();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (map.get(ch) > 0) {
                    match--;
                }
                map.put(ch, map.get(ch) - 1);
            }

            while (match == 0) {
                if (i + 1 - left < end - start) {
                    start = left;
                    end = i + 1;
                }
                char temp = s.charAt(left);
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                    if (map.get(temp) > 0) {
                        match++;
                    }
                }
                left++;
            }
        }
        return start == -1 ? "" : s.substring(start, end);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = new LC76().minWindow(s, t);
        System.out.println(res);
    }
}
