import java.util.LinkedList;
import java.util.Queue;

public class LC994 {
    public int orangesRotting(int[][] grid) {
        // 采用BFS
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int count = 0; 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    count++; // 统计新鲜橘子的数量
                }
            }
        }
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int res = 0;
        int t = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            t++;
            for (int i = 0; i < size; i++) {
                // 处在BFS搜索中同一层的所有节点所经过的时间相同，因此在一个循环中全部处理完成
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        queue.offer(new int[] {nx, ny});
                        res = Math.max(res, t);
                        count--; // 更新新鲜橘子数量
                    }
                }
            }
        }

        return count > 0 ? -1 : res; // 如果还存在新鲜橘子则返回-1

    }
}
