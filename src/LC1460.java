import java.util.HashMap;
import java.util.Map;

public class LC1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> smap = new HashMap<>();
        Map<Integer, Integer> tmap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            tmap.put(target[i], tmap.getOrDefault(target[i], 0) + 1);
            smap.put(arr[i], smap.getOrDefault(arr[i], 0) + 1);
        }
        if (smap.size() != tmap.size()) {
            return false;
        }
        for (int key: smap.keySet()) {
            int svalue = smap.get(key);
            if (!tmap.containsKey(key) || tmap.get(key) != svalue) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] target = {1, 2, 3, 4};
        int[] arr = {2, 4, 1, 3};
        boolean res = new LC1460().canBeEqual(target, arr);
        System.out.println(res);
    }
}
