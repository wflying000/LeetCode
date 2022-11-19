class Solution {
    public int largestAltitude(int[] gain) {
        int res = 0;
        int h = 0;
        for (int i = 0; i < gain.length; i++) {
            h += gain[i];
            res = Math.max(res, h);
        }
        return res;
    }
}