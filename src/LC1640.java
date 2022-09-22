import java.util.HashMap;
import java.util.Map;

public class LC1640 {
    public static boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            map.put(pieces[i][0], i);
        }
        int i = 0;
        while (i < arr.length) {
            if (!map.containsKey(arr[i])) {
                return false;
            }
            int j = map.get(arr[i]);
            for (int k = 0; k < pieces[j].length; k++) {
                if (arr[i] != pieces[j][k]) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {91, 4, 64, 78};
        int[][] pieces = {{78}, {4, 64}, {91}};
        boolean res = canFormArray(arr, pieces);
        System.out.println(res);
    }
}
