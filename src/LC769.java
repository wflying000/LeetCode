public class LC769 {
    public int maxChunksToSorted(int[] arr) {
        int max = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                res++;
            }
        }
        return res;
    }
}