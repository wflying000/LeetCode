public class LC788 {
    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isGoodNum(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isGoodNum(int num) {
        boolean res = false;
        while (num != 0) {
            int k = num % 10;
            if (k == 3 || k == 4 || k == 7) {
                return false;
            }
            if (k == 2 || k == 5 || k == 6 || k == 9) {
                res = true;
            }
            num /= 10;
        }
        return res;
    }
}
