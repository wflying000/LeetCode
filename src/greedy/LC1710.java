import java.util.Arrays;
import java.util.Comparator;

public class LC1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });
        int res = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            int k = Math.min(truckSize, boxTypes[i][0]);
            res += k * boxTypes[i][1];
            truckSize -= k;
            if (truckSize == 0) {
                break;
            }
        }
        return res;
    }
}