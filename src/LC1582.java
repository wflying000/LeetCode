public class LC1582 {
    public static int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rcnt = new int[m];
        int[] ccnt = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    rcnt[i]++;
                    ccnt[j]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            if (rcnt[i] == 1) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 1 && ccnt[j] == 1) {
                        res++;
                        break;
                    }
                }
            }
            
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 0, 0},
                       {0, 0, 1},
                       {1, 0, 0}};
        int res = numSpecial(mat);
        System.out.println(res);
    }
}
