import java.util.HashMap;
import java.util.Map;

public class LC1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                res = Math.max(res, i - map.get(ch) - 1);
            } else {
                map.put(ch, i);
            }
        }
        return res;
    }
}
