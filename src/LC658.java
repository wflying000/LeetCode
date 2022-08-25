import java.util.ArrayList;
import java.util.List;

public class LC658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        //查找第一个不小于x的数的位置, 离x最近的k个数只能在这个数两边(也可能是一边)
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        left--; //使得arr[1, left] < x, arr[right, ...] >= x
        for (int i = 0; i < k; i++) {
            if (left < 0) {
                right++;
            } else if (right >= arr.length) {
                left--;
            } else if (x - arr[left] <= arr[right] - x) {
                left--;
            } else {
                right++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = left + 1; i < right; i++) {
            res.add(arr[i]);
        }
        return res;

    }
}
