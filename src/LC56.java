import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC56 {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            }
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                list.add(new int[] {start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        list.add(new int[] {start, end});
        int[][] res = list.toArray(new int[list.size()][]);
        return res;
    }

    public static int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] nums1, int[] nums2) {
                if (nums1[0] != nums2[0]) {
                    return nums1[0] - nums2[0];
                } else {
                    return nums1[1] - nums2[1];
                }
            }
        });
        int n = intervals.length;
        int start = -1;
        int end = -1;
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (start < 0) {
                start = i;
                end = i;
            } else {
                if (intervals[i][0] <= intervals[end][i]) {
                    end = i;
                } else {
                    res.add(new int[]{intervals[start][0], intervals[end][1]});
                    start = i;
                    end = i;
                }
            }
        }
        if (start >= 0) {
            res.add(new int[]{intervals[start][0], intervals[end][0]});
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = merge2(intervals);
        System.out.println(Arrays.deepToString(res));
    }
}
