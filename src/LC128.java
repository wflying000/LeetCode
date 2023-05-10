import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC128 {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }
            int num = nums[i];
            int count = 0;
            while (set.contains(num)) {
                if (map.containsKey(num - 1)) {
                    count += map.get(num - 1) + 1;
                    break;
                }
                count++;
                num--;
            }
            map.put(nums[i], count);
            res = Math.max(res, count);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int res = longestConsecutive(nums);
        System.out.println(res);
    }
}
