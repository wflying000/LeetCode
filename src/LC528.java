public class LC528 {
    int[] pre;
    int sum;
    public LC528(int[] w) {
        pre = new int[w.length];
        pre[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            pre[i] = pre[i - 1] + w[i];
        }
        sum = pre[w.length - 1];
    }
    
    public int pickIndex() {
        int r = (int)(Math.random() * sum) + 1;
        int res = search(r);
        return res;
    }

    private int search(int target) {
        int left = 0;
        int right = pre.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (pre[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}