import java.util.Arrays;

public class LC1619 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int num = arr.length * 5 / 100;
        double res = 0;
        for (int i = num; i < arr.length - num; i++) {
            res += arr[i];
        }
        res /= (arr.length - 2 * num);
        return res;
    }
}
