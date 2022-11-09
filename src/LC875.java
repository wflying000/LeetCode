public class LC875 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = piles[0];
        for (int i = 1; i < piles.length; i++) {
            right = Math.max(right, piles[i]);
        }
        int res = right;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int time = getTime(piles, mid);
            if (time <= h) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    private int getTime(int[] piles, int speed) {
        int res = 0;
        for (int i = 0; i < piles.length; i++) {
            res += (piles[i] + speed - 1) / speed;
        }
        return res;
    }
}