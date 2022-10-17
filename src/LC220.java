import java.util.HashMap;
import java.util.Map;

public class LC220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        long w = (long)t + 1;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long id = getId(nums[i], w);
            if (map.containsKey(id)) {
                return true;
            }
            if (map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) <= t) {
                return true;
            }
            if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) <= t) {
                return true;
            }
            map.put(id, (long)nums[i]);
            if (i >= k) {
                map.remove(getId(nums[i - k], w));
            }
        }
        return false;
    }

    private long getId(long num, long w) {
        if (num >= 0) {
            return num / w;
        }
        return (num + 1) / w - 1;
    }
}
