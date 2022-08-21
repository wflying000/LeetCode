import java.util.HashMap;
import java.util.Map;

public class LC525 {
    public int findMaxLength(int[] nums) {
        if (nums == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC525 sln = new LC525();
        int[] nums = {0, 1, 0};
        int res = sln.findMaxLength(nums);
        System.out.println(res);
    }
}
