import java.util.HashMap;
import java.util.Map;

public class LC904 {
    public int totalFruit(int[] fruits) {
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < fruits.length; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}