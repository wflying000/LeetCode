package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC542 {
    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        int max = m + n + 10;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i], max);
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                    queue.offer(new int[] {i, j});
                }
            }
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && res[nx][ny] == max) {
                    res[nx][ny] = res[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {
            {0, 0, 0},
            {0, 1, 0},
            {1, 1, 1}
        };
        int[][] res = updateMatrix(mat);
        System.out.println(Arrays.deepToString(res));
    }
} 
