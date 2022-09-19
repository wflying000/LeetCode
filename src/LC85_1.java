public class LC85_1 {
    // 与LeetCode输入数据格式不同
    public static int maximalRectangle(String[] matrix) {
        if (matrix == null || matrix.length == 0 || 
            matrix[0] == null || matrix[0].length() == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length();
        int[][] count = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i].charAt(j) == '1') {
                    if (j != n - 1) {
                        count[i][j] = count[i][j + 1] + 1;
                    } else {
                        count[i][j] = 1;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j] != 0) {
                    int k = i - 1;
                    int width = count[i][j];
                    res = Math.max(res, width);
                    while (k >= 0) {
                        if (count[k][j] > 0) {
                            width = Math.min(width, count[k][j]);
                            res = Math.max(res, width * (i - k + 1));
                            k--;
                        } else {
                            break;
                        }
                    }

                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
       String[] matrix = {"10100", "10111", "11111", "10010"};
       int res = maximalRectangle(matrix);
       System.out.println(res);
    }
}
