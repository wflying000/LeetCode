import java.util.Arrays;

public class LC870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] index1 = new Integer[n];
        Integer[] index2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            index1[i] = i;
            index2[i] = i;
        }
        Arrays.sort(index1, (a, b) -> {
            return nums1[a] - nums1[b];
        });
        Arrays.sort(index2, (a, b) -> {
            return nums2[a] - nums2[b];
        });

        int[] res = new int[n];
        int left = 0;
        int right = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums1[index1[i]] > nums2[index2[left]]) {
                res[index2[left]] = nums1[index1[i]];
                left++;
            } else {
                res[index2[right]] = nums1[index1[i]];
                right--;
            }
        }
        // boolean[] used = new boolean[n];
        // int i = 0;
        // int j = 0;
        // while (i < n) {
        //     if (nums1[index1[i]] > nums2[index2[j]]) {
        //         res[index2[j]] = nums1[index1[i]];
        //         used[index1[i]] = true;
        //         j++;
        //     }
        //     i++;
        // }
        // while (j < n) {
        //     for (i = 0; i < n; i++) {
        //         if (!used[i]) {
        //             res[index2[j]] = nums1[i];
        //             used[i] = true;
        //             break;
        //         }
        //     }
        //     j++;
        // }
        return res;
    }
}
